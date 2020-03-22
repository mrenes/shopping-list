package com.mrenes.shoppinglist.ui.edit_shopping_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.mrenes.shoppinglist.R
import com.mrenes.shoppinglist.Router
import com.mrenes.shoppinglist.getExtraOrDefault
import kotlinx.android.synthetic.main.fragment_edit_shopping_list.*
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.fragment_edit_shopping_list.editList_archive as archive
import kotlinx.android.synthetic.main.fragment_edit_shopping_list.editList_save as save
import kotlinx.android.synthetic.main.fragment_edit_shopping_list.editList_text as text
import kotlinx.android.synthetic.main.fragment_edit_shopping_list.editList_title as title

class EditShoppingListFragment : Fragment(R.layout.fragment_edit_shopping_list) {

    private val viewModel: EditShoppingListViewModel by viewModel {
        parametersOf(
            getExtraOrDefault(EXTRA_SHOPPING_LIST_ID)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers(view)
        setListeners()
    }

    private fun setListeners() {
        save.setOnClickListener {
            viewModel.onSaveClick(
                title = title.text.toString(),
                text = text.text.toString()
            )
        }
        archive.setOnClickListener {
            viewModel.onArchiveClick()
        }
    }

    private fun initObservers(view: View) {
        viewModel.shoppingListData.observe(this, Observer {
            title.setText(it.title)
            text.setText(it.text)
        })

        viewModel.isArchived.observe(this, Observer {
            Snackbar.make(view, getString(R.string.archivedLists_archived), Snackbar.LENGTH_SHORT)
                .show()
            Router.goToActiveShoppingLists(activity as AppCompatActivity)
        })

        viewModel.isSaved.observe(this, Observer {
            Snackbar.make(view, getString(R.string.editList_saved), Snackbar.LENGTH_SHORT)
                .show()
            Router.goToActiveShoppingLists(activity as AppCompatActivity)
        })
    }

    companion object {
        const val EXTRA_SHOPPING_LIST_ID = "EditShoppingListFragment:EXTRA_SHOPPING_LIST_ID"

        fun newInstance(shoppingListId: String?): EditShoppingListFragment {
            val bundle = Bundle().apply {
                putString(EXTRA_SHOPPING_LIST_ID, shoppingListId)
            }
            return EditShoppingListFragment().apply {
                arguments = bundle
            }
        }
    }
}
