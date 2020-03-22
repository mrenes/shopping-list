package com.mrenes.shoppinglist.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrenes.shoppinglist.database.model.ShoppingListEntity.Companion.TABLE_NAME
import java.lang.System.currentTimeMillis
import java.util.*

@Entity(tableName = TABLE_NAME)
class ShoppingListEntity(
    @PrimaryKey
    val id: String,
    var title: String,
    var text: String,
    val timeCreated: Long,
    var timeArchived: Long?
) {
    companion object {
        const val TABLE_NAME = "shopping_list"

        fun new(): ShoppingListEntity {
            return ShoppingListEntity(
                id = UUID.randomUUID().toString(),
                title = "",
                text = "",
                timeCreated = currentTimeMillis(),
                timeArchived = null
            )
        }
    }
}