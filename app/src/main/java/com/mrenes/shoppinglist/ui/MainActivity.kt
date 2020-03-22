package com.mrenes.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrenes.shoppinglist.R
import com.mrenes.shoppinglist.Router
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigation()
        Router.goToActiveShoppingLists(this)
    }

    private fun initNavigation() {
        main_navMenu.setOnNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.main_navMenuActive -> {
                    Router.goToActiveShoppingLists(this)
                    true
                }
                R.id.main_navMenuNew -> {
                    Router.goToEditShoppingList(
                        this,
                        null
                    )
                    true
                }
                R.id.main_navMenuArchived -> {
                    Router.goToArchivedShoppingLists(this)
                    true
                }
                else -> false
            }
        }
    }
}
