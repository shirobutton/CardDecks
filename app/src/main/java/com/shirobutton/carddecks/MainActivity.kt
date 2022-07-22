package com.shirobutton.carddecks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import com.shirobutton.carddecks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindRecyclerView(binding)
    }

    private fun bindRecyclerView(binding: ActivityMainBinding) {
        val adapter = CardListAdapter()
        adapter.submitList(createData())
        binding.root.adapter = adapter
        binding.root.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        private const val STRING_TITLE = "StringTitle"
        private val TITLE_RES_ID = R.string.title.asStringResource()
        private val IMAGE_URL = "https://placehold.jp/100x100.png".toUri()
        private val IMAGE_RES_ID = R.drawable.ic_launcher_background.asDrawableResource()

        private fun createData() =
            listOf(
                CardListItem(
                    STRING_TITLE,
                    IMAGE_URL
                ),
                CardListItem(
                    TITLE_RES_ID,
                    IMAGE_URL
                ),
                CardListItem(
                    STRING_TITLE,
                    IMAGE_RES_ID
                ),
                CardListItem(
                    TITLE_RES_ID,
                    IMAGE_RES_ID
                )
            )
    }
}
