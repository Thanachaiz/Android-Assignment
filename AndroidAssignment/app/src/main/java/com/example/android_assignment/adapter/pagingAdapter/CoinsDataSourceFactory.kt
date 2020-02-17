package com.example.android_assignment.adapter.pagingAdapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.android_assignment.model.Coin


class CoinsDataSourceFactory: DataSource.Factory<Int, Coin>(){

    private val coinsLiveDataSource = MutableLiveData<CoinsDataSource>()


    override fun create(): DataSource<Int, Coin> {
        val coinsDataSource = CoinsDataSource()
        coinsLiveDataSource.postValue(coinsDataSource)

        return coinsDataSource
    }

    fun getItemLiveData(): MutableLiveData<CoinsDataSource> {
        return coinsLiveDataSource
    }
}