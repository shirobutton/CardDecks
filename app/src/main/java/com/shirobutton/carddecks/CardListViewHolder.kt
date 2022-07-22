package com.shirobutton.carddecks

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shirobutton.carddecks.databinding.CardListItemViewBinding

class CardListViewHolder(
    private val binding: CardListItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardListItem<*, *>) {
        bindTitle(item.titleResource)
        bindImage(item.imageResource)
    }

    private fun <T> bindTitle(titleResource: T) {
        val context = binding.root.context
        binding.title.text = when (titleResource) {
            is String -> titleResource
            is StringResourceId -> context.getString(titleResource.value)
            else -> throw IllegalArgumentException()
        }
    }

    private fun <T> bindImage(imageResource: T) =
        when (imageResource) {
            is Uri -> loadImage(imageResource)
            is DrawableResourceId -> setImageResource(imageResource.value)
            else -> throw IllegalArgumentException()
        }

    private fun loadImage(imageUrl: Uri) {
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
