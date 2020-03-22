package com.mrenes.shoppinglist.ui.archived_shopping_lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrenes.shoppinglist.R
import com.mrenes.shoppinglist.ui.archived_shopping_lists.ArchivedShoppingListsContract.*

class ArchivedShoppingListsAdapter(
    var shoppingLists: List<ShoppingListData>,
    private val onShoppingListClick: (id: String) -> Unit
) : RecyclerView.Adapter<ArchivedShoppingListsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_archived_shopping_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoppingList = shoppingLists[position]
        holder.title.text = shoppingList.title
        holder.dateArchived.text = shoppingList.dateArchived

        holder.itemView.setOnClickListener {
            onShoppingListClick(shoppingList.id)
        }
    }

    override fun getItemCount(): Int {
        return shoppingLists.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.archivedLists_singleItem_title)
        val dateArchived: TextView = itemView.findViewById(R.id.archivedLists_singleItem_dateArchived)
    }
}
