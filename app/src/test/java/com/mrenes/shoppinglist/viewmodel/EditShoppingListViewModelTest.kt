package com.mrenes.shoppinglist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mrenes.shoppinglist.database.model.ShoppingListEntity
import com.mrenes.shoppinglist.repository.ShoppingListRepository
import com.mrenes.shoppinglist.ui.edit_shopping_list.EditShoppingListContract
import com.mrenes.shoppinglist.ui.edit_shopping_list.EditShoppingListViewModel
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class EditShoppingListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val repo = mock<ShoppingListRepository>()

    @Test
    fun `init - create new shopping list`() {
        val vm = newViewModel(id = null)

        assertEquals("", vm.currentShoppingList.title)
        assertEquals("", vm.currentShoppingList.text)
    }

    @Test
    fun `init - edit existing shopping list`() {
        val id = "custom id"
        val expectedEntity = fakeShoppingListEntity(id = id)
        whenever(repo.get(id)).thenReturn(expectedEntity)
        val vm = newViewModel(id = id)

        assertEquals(expectedEntity, vm.currentShoppingList)
    }

    @Test
    fun `save list`() {
        val id = "some id"
        val title = "some title"
        val text = "some text"
        val expectedEntity = fakeShoppingListEntity(
            id = id
        )
        whenever(repo.get(id)).thenReturn(expectedEntity)
        val vm = newViewModel(id = id)

        vm.onSaveClick(title, text)

        assertEquals(expectedEntity, vm.currentShoppingList)
        assertEquals(title, vm.currentShoppingList.title)
        assertEquals(text, vm.currentShoppingList.text)
        verify(repo).save(expectedEntity)
        assertEquals(true, vm.isSaved.value)
    }

    @Test
    fun `archive list`() {
        val id = "some id"
        val expectedEntity = fakeShoppingListEntity(
            id = id
        )
        whenever(repo.get(id)).thenReturn(expectedEntity)
        val vm = newViewModel(id = id)

        vm.onArchiveClick()

        verify(repo).archive(expectedEntity)
        assertEquals(true, vm.isArchived.value)
    }

    private fun newViewModel(
        id: String? = null
    ): EditShoppingListViewModel {
        return EditShoppingListViewModel(
            shoppingListId = id,
            repo = repo
        )
    }

    private fun fakeShoppingListEntity(
        id: String = "1234",
        title: String = "title",
        text: String = "text"
    ): ShoppingListEntity {
        return ShoppingListEntity(
            id = id,
            title = title,
            text = text,
            timeCreated = 999,
            timeArchived = null
        )
    }
}
