package com.shirobutton.carddecks

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CardListAdapter : ListAdapter<CardListItem, CardListViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardListViewHolder.create(parent)

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<CardListItem>() {
            override fun areItemsTheSame(
                oldItem: CardListItem,
                newItem: CardListItem
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: CardListItem,
                newItem: CardListItem
            ): Boolean = oldItem == newItem
        }
    }
}
