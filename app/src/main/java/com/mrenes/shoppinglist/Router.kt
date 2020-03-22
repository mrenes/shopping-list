package com.mrenes.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import com.mrenes.shoppinglist.ui.active_shopping_lists.ActiveShoppingListsFragment
import com.mrenes.shoppinglist.ui.archived_shopping_lists.ArchivedShoppingListsFragment
import com.mrenes.shoppinglist.ui.edit_shopping_list.EditShoppingListFragment

object Router {

    fun goToEditShoppingList(
        activity: AppCompatActivity,
        shoppingListId: String?
    ) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, EditShoppingListFragment.newInstance(shoppingListId))
            .commit()
    }

    fun goToArchivedShoppingLists(activity: AppCompatActivity) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ArchivedShoppingListsFragment.newInstance())
            .commit()
    }

    fun goToActiveShoppingLists(activity: AppCompatActivity) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ActiveShoppingListsFragment.newInstance())
            .commit()
    }
}