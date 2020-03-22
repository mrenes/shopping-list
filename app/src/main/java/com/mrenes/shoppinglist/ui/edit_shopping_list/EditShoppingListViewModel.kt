package com.mrenes.shoppinglist.ui.edit_shopping_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrenes.shoppinglist.database.model.ShoppingListEntity
import com.mrenes.shoppinglist.repository.ShoppingListRepository
import com.mrenes.shoppinglist.ui.edit_shopping_list.EditShoppingListContract.*

class EditShoppingListViewModel(
    shoppingListId: String?,
    private val repo: ShoppingListRepository
) : ViewModel() {

    var currentShoppingList: ShoppingListEntity =
        if (shoppingListId == null) {
            ShoppingListEntity.new()
        } else {
            repo.get(shoppingListId)
        }

    private val _shoppingListData = MutableLiveData<ShoppingListData>()
    val shoppingListData: LiveData<ShoppingListData> = _shoppingListData

    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean> = _isSaved

    private val _isArchived = MutableLiveData<Boolean>()
    val isArchived: LiveData<Boolean> = _isArchived

    init {
        _shoppingListData.postValue(ShoppingListData.from(currentShoppingList))
    }

    fun onSaveClick(title: String, text: String) {
        currentShoppingList.title = title
        currentShoppingList.text = text
        repo.save(currentShoppingList)
        _isSaved.postValue(true)
    }

    fun onArchiveClick() {
        repo.archive(currentShoppingList)
        _isArchived.postValue(true)
    }

}
