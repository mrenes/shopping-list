package com.mrenes.shoppinglist.di

import androidx.room.Room
import com.mrenes.shoppinglist.database.ShoppingListDatabase
import com.mrenes.shoppinglist.repository.ShoppingListRepository
import com.mrenes.shoppinglist.ui.active_shopping_lists.ActiveShoppingListsViewModel
import com.mrenes.shoppinglist.ui.archived_shopping_lists.ArchivedShoppingListsViewModel
import com.mrenes.shoppinglist.ui.edit_shopping_list.EditShoppingListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (shoppingListId: String) -> EditShoppingListViewModel(shoppingListId, get()) }
    viewModel { ActiveShoppingListsViewModel(get()) }
    viewModel { ArchivedShoppingListsViewModel(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            ShoppingListDatabase::class.java,
            ShoppingListDatabase.DB_NAME
        )
            .allowMainThreadQueries()
            .build()
    }
    single { get<ShoppingListDatabase>().shoppingListDao }
}

val repositoryModule = module {
    single { ShoppingListRepository(get()) }
}