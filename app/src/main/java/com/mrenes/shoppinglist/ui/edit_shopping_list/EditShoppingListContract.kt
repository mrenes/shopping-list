package com.mrenes.shoppinglist.ui.edit_shopping_list

import com.mrenes.shoppinglist.database.model.ShoppingListEntity

interface EditShoppingListContract {

    data class ShoppingListData(
        val title: String,
        val text: String
    ) {
        companion object {
            fun from(shoppingList: ShoppingListEntity): ShoppingListData =
                ShoppingListData(
                    title = shoppingList.title,
                    text = shoppingList.text
                )

        }
    }
}
