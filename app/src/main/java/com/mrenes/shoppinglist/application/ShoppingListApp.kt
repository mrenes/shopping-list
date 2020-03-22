package com.mrenes.shoppinglist.application

import android.app.Application
import com.mrenes.shoppinglist.di.databaseModule
import com.mrenes.shoppinglist.di.repositoryModule
import com.mrenes.shoppinglist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShoppingListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShoppingListApp)
            androidLogger()
            modules(
                listOf(
                    viewModelModule,
                    databaseModule,
                    repositoryModule
                )
            )
        }
    }
}