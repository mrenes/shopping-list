package com.mrenes.shoppinglist.repository

import com.mrenes.shoppinglist.database.dao.ShoppingListDao
import com.mrenes.shoppinglist.database.model.ShoppingListEntity
import java.lang.System.currentTimeMillis

class ShoppingListRepository(
    private val dao: ShoppingListDao
) {

    fun get(id: String): ShoppingListEntity {
        return dao.get(id)
    }

    fun getAllActive(): List<ShoppingListEntity> {
        return dao.getAllActive()
    }

    fun getAllArchived(): List<ShoppingListEntity> {
        return dao.getAllArchived()
    }

    fun save(shoppingList: ShoppingListEntity) {
        if (dao.insert(shoppingList) == -1L) {
            dao.update(shoppingList)
        }
    }

    fun archive(shoppingList: ShoppingListEntity) {
        shoppingList.timeArchived = currentTimeMillis()
        dao.update(shoppingList)
    }
}