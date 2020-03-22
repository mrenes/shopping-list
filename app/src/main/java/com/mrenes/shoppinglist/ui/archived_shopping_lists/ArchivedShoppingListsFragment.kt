package com.mrenes.shoppinglist.ui.archived_shopping_lists

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mrenes.shoppinglist.R
import com.mrenes.shoppinglist.Router
import kotlinx.android.synthetic.main.fragment_archived_shopping_lists.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.fragment_archived_shopping_lists.archivedLists_recycler as recycler

class ArchivedShoppingListsFragment : Fragment(R.layout.fragment_archived_shopping_lists) {

    private val viewModel: ArchivedShoppingListsViewModel by viewModel()
    private lateinit var shoppingListsAdapter: ArchivedShoppingListsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        shoppingListsAdapter = ArchivedShoppingListsAdapter(emptyList()) {
            //Router.goToEditShoppingList(activity as AppCompatActivity, shoppingListId)
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

        fun newInstance(): ArchivedShoppingListsFragment {
            return ArchivedShoppingListsFragment()
        }
    }
}
