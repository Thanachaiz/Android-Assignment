package com.example.android_assignment.ui.pagingFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.android_assignment.adapter.pagingAdapter.CoinsDataSource
import com.example.android_assignment.adapter.pagingAdapter.CoinsDataSourceFactory
import com.example.android_assignment.adapter.pagingAdapter.PAGE_LIMIT
import com.example.android_assignment.model.Coin

class PageListCoinsViewModel : ViewModel(){

    private var listResult = MutableLiveData<CoinsDataSource>().apply {
        this.also {
            ItemViewModel()
        }
    }
    private lateinit var itemPagedList: LiveData<PagedList<Coin>>


    fun ItemViewModel(){

        val coinsDataSourceFactory =
            CoinsDataSourceFactory()
        listResult = CoinsDataSourceFactory().getItemLiveData()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_LIMIT)
            .build()

        itemPagedList = LivePagedListBuilder(coinsDataSourceFactory, config).build()
    }

    fun getLiveDataCoins(): LiveData<PagedList<Coin>>{

        if (itemPagedList == null){
            itemPagedList = MutableLiveData()
        }

        return itemPagedList
    }
}