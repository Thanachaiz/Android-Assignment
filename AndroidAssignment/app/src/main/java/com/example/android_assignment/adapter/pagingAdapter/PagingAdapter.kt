package com.example.android_assignment.adapter.pagingAdapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.adapter.CoinViewHolder
import com.example.android_assignment.model.Coin

class PagingAdapter: PagedListAdapter<Coin, RecyclerView.ViewHolder>(COIN_COMPARATOR){

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
        private val COIN_COMPARATOR = object : DiffUtil.ItemCallback<Coin>() {
            override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean =
                oldItem == newItem
        }
    }
}