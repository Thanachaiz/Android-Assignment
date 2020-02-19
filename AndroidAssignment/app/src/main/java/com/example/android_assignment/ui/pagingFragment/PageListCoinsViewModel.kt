package com.example.android_assignment.ui.pagingFragment

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.android_assignment.datasource.CoinsDataSource
import com.example.android_assignment.datasource.CoinsDataSourceFactory
import com.example.android_assignment.datasource.PAGE_LIMIT
import com.example.android_assignment.model.Coin


class PageListCoinsViewModel : ViewModel() {


    var uiList = MediatorLiveData<PagedList<Coin>>()
    private lateinit var itemPagedList: LiveData<PagedList<Coin>>
    private val coinsDataSourceFactory = CoinsDataSourceFactory()

    private val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_LIMIT)
            .build()

    fun refresh() {
        if (::itemPagedList.isInitialized)
        // refresh
            coinsDataSourceFactory.coinsDataSource.invalidate()
        else {
            // initialize
            itemPagedList = LivePagedListBuilder(coinsDataSourceFactory, config).build()
            uiList.addSource(itemPagedList) {
                uiList.value = it
            }
        }
    }
}