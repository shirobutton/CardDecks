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

    private fun createData() =
        List(3) {
            CardTypeA(
                title = it.toString(),
                imageUrl = "https://placehold.jp/100x100.png"
            )
        }
}
