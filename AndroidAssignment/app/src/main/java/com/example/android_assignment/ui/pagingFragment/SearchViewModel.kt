package com.example.android_assignment.ui.pagingFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.android_assignment.datasource.CoinsDataSource
import com.example.android_assignment.datasource.CoinsDataSourceFactory
import com.example.android_assignment.datasource.PAGE_LIMIT
import com.example.android_assignment.model.Coin
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.lifecycle.Transformations
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





class SearchViewModel : ViewModel(){

    private var listResult = MutableLiveData<CoinsDataSource>().apply {
        this.also {
            ItemViewModel()
        }
    }
    private lateinit var itemPagedList: LiveData<PagedList<Coin>>
    var filterTextAll = MutableLiveData<String>()


    fun ItemViewModel(){

        val coinsDataSourceFactory = CoinsDataSourceFactory()
        listResult = CoinsDataSourceFactory().getItemLiveData()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_LIMIT)
            .build()

        itemPagedList = LivePagedListBuilder(coinsDataSourceFactory, config).build()
    }

    fun getLive(): LiveData<PagedList<Coin>>{

        if (itemPagedList == null){
            itemPagedList = MutableLiveData()
        }

        return itemPagedList
    }
}