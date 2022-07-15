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
        bindTitle(item.titleContainer)
        bindImage(item.imageContainer)
    }

    private fun bindTitle(item: TitleContainer) {
        val context = binding.root.context
        binding.title.text = when (item) {
            is StringTitleContainer -> item.title
            is StringResourceTitleContainer -> context.getString(item.titleResId)
        }
    }

    private fun bindImage(item: ImageContainer) =
        when (item) {
            is ImageUrlContainer -> loadImage(item.imageUrl)
            is ImageResourceContainer -> setImageResource(item.imageResId)
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
