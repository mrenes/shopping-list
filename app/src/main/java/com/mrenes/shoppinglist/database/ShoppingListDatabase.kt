package com.mrenes.shoppinglist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrenes.shoppinglist.database.ShoppingListDatabase.Companion.DB_VERSION
import com.mrenes.shoppinglist.database.dao.ShoppingListDao
import com.mrenes.shoppinglist.database.model.ShoppingListEntity

@Database(
    version = DB_VERSION,
    entities = [
        ShoppingListEntity::class
    ]
)
abstract class ShoppingListDatabase : RoomDatabase() {
    abstract val shoppingListDao: ShoppingListDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "ShoppingListsDatabase"
    }
}