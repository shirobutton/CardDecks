package com.shirobutton.carddecks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        private const val TITLE_RES_ID = R.string.title
        private const val IMAGE_URL = "https://placehold.jp/100x100.png"
        private const val IMAGE_RES_ID = R.drawable.ic_launcher_background

        private fun createData() =
            listOf(
                CardTypeA(
                    title = STRING_TITLE,
                    imageUrl = IMAGE_URL
                ),
                CardTypeB(
                    titleResId = TITLE_RES_ID,
                    imageUrl = IMAGE_URL
                ),
                CardTypeC(
                    title = STRING_TITLE,
                    imageResId = IMAGE_RES_ID
                ),
                CardTypeD(
                    titleResId = TITLE_RES_ID,
                    imageResId = IMAGE_RES_ID
                )
            )
    }
}
