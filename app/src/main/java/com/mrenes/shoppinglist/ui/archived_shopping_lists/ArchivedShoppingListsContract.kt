package com.mrenes.shoppinglist.ui.archived_shopping_lists

import android.text.format.DateFormat
import com.mrenes.shoppinglist.database.model.ShoppingListEntity

interface ArchivedShoppingListsContract {

    data class ShoppingListData(
        val id: String,
        val title: String,
        val dateArchived: String
    ) {
        companion object {
            fun from(shoppingList: ShoppingListEntity): ShoppingListData {
                // TODO: title and date logic should be provided by the ViewModel
                val dateArchived = if (shoppingList.timeArchived != null) {
                    DateFormat.format(
                        "dd/MM/yy HH:mm",
                        shoppingList.timeArchived!!
                    ).toString()
                } else {
                    NOT_AVAILABLE
                }
                val title = if (shoppingList.title.isEmpty()) {
                    NOT_AVAILABLE
                } else {
                    shoppingList.title
                }
                return ShoppingListData(
                    id = shoppingList.id,
                    title = title,
                    dateArchived = dateArchived
                )
            }

            private const val NOT_AVAILABLE = "N/A"
        }
    }
}
