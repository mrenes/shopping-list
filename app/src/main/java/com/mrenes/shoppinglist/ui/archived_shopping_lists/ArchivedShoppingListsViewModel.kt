package com.mrenes.shoppinglist.ui.archived_shopping_lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrenes.shoppinglist.repository.ShoppingListRepository
import com.mrenes.shoppinglist.ui.archived_shopping_lists.ArchivedShoppingListsContract.*

class ArchivedShoppingListsViewModel(
    private val repo: ShoppingListRepository
) : ViewModel() {

    private val _shoppingLists = MutableLiveData<List<ShoppingListData>>()
    val shoppingLists: LiveData<List<ShoppingListData>> = _shoppingLists

    init {
        val archivedLists = repo.getAllArchived()
            .sortedBy { it.timeArchived }
            .map { ShoppingListData.from(it) }
        _shoppingLists.postValue(archivedLists)
    }

}
