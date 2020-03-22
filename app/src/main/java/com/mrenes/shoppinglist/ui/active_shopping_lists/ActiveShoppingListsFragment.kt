package com.mrenes.shoppinglist.ui.active_shopping_lists

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mrenes.shoppinglist.R
import com.mrenes.shoppinglist.Router
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.fragment_active_shopping_lists.activeLists_recycler as recycler

class ActiveShoppingListsFragment : Fragment(R.layout.fragment_active_shopping_lists) {

    private val viewModel: ActiveShoppingListsViewModel by viewModel()
    private lateinit var shoppingListsAdapter: ActiveShoppingListsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        shoppingListsAdapter = ActiveShoppingListsAdapter(emptyList()) { shoppingListId ->
            Router.goToEditShoppingList(activity as AppCompatActivity, shoppingListId)
        }

        recycler.layoutManager = GridLayoutManager(
            context, GRID_LAYOUT_COLUMNS
        )

        recycler.adapter = shoppingListsAdapter
    }

    private fun initObservers() {
        viewModel.shoppingLists.observe(this, Observer{shoppingLists ->
            shoppingListsAdapter.shoppingLists = shoppingLists
            shoppingListsAdapter.notifyDataSetChanged()
        })
    }

    companion object {
        private const val GRID_LAYOUT_COLUMNS = 2

        fun newInstance(): ActiveShoppingListsFragment {
            return ActiveShoppingListsFragment()
        }
    }
}
