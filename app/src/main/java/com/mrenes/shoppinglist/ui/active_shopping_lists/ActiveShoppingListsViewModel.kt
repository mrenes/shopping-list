package com.mrenes.shoppinglist.ui.active_shopping_lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrenes.shoppinglist.repository.ShoppingListRepository
import com.mrenes.shoppinglist.ui.active_shopping_lists.ActiveShoppingListsContract.*

class ActiveShoppingListsViewModel(
    private val repo: ShoppingListRepository
) : ViewModel() {

    private val _shoppingLists = MutableLiveData<List<ShoppingListData>>()
    val shoppingLists: LiveData<List<ShoppingListData>> = _shoppingLists

    init {
        val activeLists = repo.getAllActive()
            .sortedBy { it.timeCreated }
            .map { ShoppingListData.from(it) }
        _shoppingLists.postValue(activeLists)
    }

}
