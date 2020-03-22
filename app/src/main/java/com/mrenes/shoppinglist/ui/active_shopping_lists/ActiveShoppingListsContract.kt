package com.mrenes.shoppinglist.ui.active_shopping_lists

import android.text.format.DateFormat
import com.mrenes.shoppinglist.database.model.ShoppingListEntity

interface ActiveShoppingListsContract {

    data class ShoppingListData(
        val id: String,
        val title: String,
        val dateCreated: String
    ) {
        companion object {
            fun from(shoppingList: ShoppingListEntity): ShoppingListData {
                // TODO: title logic should be provided by the ViewModel
                val title = if (shoppingList.title.isEmpty()) {
                    NOT_AVAILABLE
                } else {
                    shoppingList.title
                }
                return ShoppingListData(
                    id = shoppingList.id,
                    title = title,
                    dateCreated = DateFormat.format(
                        "dd/MM/yy HH:mm",
                        shoppingList.timeCreated
                    ).toString()
                )
            }

            private const val NOT_AVAILABLE = "N/A"
        }
    }
}
