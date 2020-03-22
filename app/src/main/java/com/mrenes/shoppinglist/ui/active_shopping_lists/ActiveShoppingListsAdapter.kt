package com.mrenes.shoppinglist.ui.active_shopping_lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrenes.shoppinglist.R
import com.mrenes.shoppinglist.ui.active_shopping_lists.ActiveShoppingListsContract.*

class ActiveShoppingListsAdapter(
    var shoppingLists: List<ShoppingListData>,
    private val onShoppingListClick: (id: String) -> Unit
) : RecyclerView.Adapter<ActiveShoppingListsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_active_shopping_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoppingList = shoppingLists[position]
        holder.title.text = shoppingList.title
        holder.dateCreated.text = shoppingList.dateCreated

        holder.itemView.setOnClickListener {
            onShoppingListClick(shoppingList.id)
        }
    }

    override fun getItemCount(): Int {
        return shoppingLists.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.activeLists_singleItem_title)
        val dateCreated: TextView = itemView.findViewById(R.id.activeLists_singleItem_dateCreated)
    }
}
