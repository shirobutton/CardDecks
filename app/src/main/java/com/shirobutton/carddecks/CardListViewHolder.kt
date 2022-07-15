package com.shirobutton.carddecks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shirobutton.carddecks.databinding.CardListItemViewBinding

class CardListViewHolder(
    private val binding: CardListItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardListItem) {
        bindTitle(item.titleContainer)
        bindImage(item.imageContainer)
    }

    private fun bindTitle(item: TitleContainer) {
        binding.title.text = item.getString(binding.root.context)
    }

    private fun bindImage(item: ImageContainer) =
        item.into(binding.image)

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
