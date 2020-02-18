package com.example.android_assignment.adapter.coinAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.model.Coin
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android_assignment.adapter.CoinViewHolder


class CoinsAdapter2: ListAdapter<Coin, RecyclerView.ViewHolder>(REPO_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CoinViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val coinsItem = getItem(position)
        if (coinsItem != null) {
            (holder as CoinViewHolder).bind(coinsItem)
        }
    }

    companion object{
        var TAG = "coinsAdapter2"
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Coin>() {
            override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean =
                oldItem == newItem
        }
    }
}