package com.shirobutton.carddecks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shirobutton.carddecks.databinding.CardListItemViewBinding

class CardListViewHolder(
    private val binding: CardListItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardListItem) {
        binding.title.text = getTitle(item)
        Glide.with(binding.image)
            .load(item.imageUrl)
            .into(binding.image)
    }

    private fun getTitle(item: CardListItem) =
        when (item) {
            is CardTypeA -> item.title
            is CardTypeB -> binding.root.context.getString(item.titleResId)
        }

    companion object {
        fun create(parent: ViewGroup): CardListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CardListItemViewBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return CardListViewHolder(binding)
        }
    }
}
