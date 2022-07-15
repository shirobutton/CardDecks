package com.shirobutton.carddecks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shirobutton.carddecks.databinding.CardListItemViewBinding

class CardListViewHolder(
    private val binding: CardListItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardListItem) {
        bindTitle(item)
        bindImage(item)
    }

    private fun bindTitle(item: CardListItem) {
        val context = binding.root.context
        binding.title.text = when (item) {
            is CardTypeA -> item.title
            is CardTypeB -> context.getString(item.titleResId)
            is CardTypeC -> item.title
            is CardTypeD -> context.getString(item.titleResId)
        }
    }

    private fun bindImage(item: CardListItem) =
        when (item) {
            is CardTypeA -> loadImage(item.imageUrl)
            is CardTypeB -> loadImage(item.imageUrl)
            is CardTypeC -> setImageResource(item.imageResId)
            is CardTypeD -> setImageResource(item.imageResId)
        }

    private fun loadImage(imageUrl: String) {
        Glide.with(binding.image)
            .load(imageUrl)
            .into(binding.image)
    }

    private fun setImageResource(@DrawableRes drawableResId: Int) =
        binding.image.setImageResource(drawableResId)

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
