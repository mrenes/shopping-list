package com.mrenes.shoppinglist.database.dao

import androidx.room.*
import com.mrenes.shoppinglist.database.model.ShoppingListEntity

@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(shoppingList: ShoppingListEntity) : Long

    @Update
    fun update(shoppingList: ShoppingListEntity)

    @Query("SELECT * from ${ShoppingListEntity.TABLE_NAME}")
    fun getAll(): List<ShoppingListEntity>

    @Query("SELECT * from ${ShoppingListEntity.TABLE_NAME} WHERE id = :id")
    fun get(id: String): ShoppingListEntity

    @Query("SELECT * from ${ShoppingListEntity.TABLE_NAME} WHERE timeArchived IS NULL")
    fun getAllActive(): List<ShoppingListEntity>

    @Query("SELECT * from ${ShoppingListEntity.TABLE_NAME} WHERE timeArchived IS NOT NULL")
    fun getAllArchived(): List<ShoppingListEntity>

    @Delete
    fun delete(shoppingList: ShoppingListEntity)

    @Query("DELETE FROM ${ShoppingListEntity.TABLE_NAME} WHERE id = :id")
    fun delete(id: String)
}