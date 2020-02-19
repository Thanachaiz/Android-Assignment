package com.example.android_assignment.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.android_assignment.model.Coin


class CoinsDataSourceFactory: DataSource.Factory<Int, Coin>(){

    private val coinsLiveDataSource = MutableLiveData<CoinsDataSource>()
    lateinit var coinsDataSource : CoinsDataSource

    override fun create(): DataSource<Int, Coin> {

        coinsDataSource = CoinsDataSource()
        coinsLiveDataSource.postValue(coinsDataSource)

        return coinsDataSource
    }
}