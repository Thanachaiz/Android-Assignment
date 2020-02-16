package com.example.android_assignment.api

import com.example.android_assignment.model.CoinsModel
import retrofit2.Call
import retrofit2.http.GET

interface CoinRankingReq {

    @GET("coins")
    fun CoinsService() : Call<CoinsModel>

    object getCoins {

        val BASE_URL = "https://api.coinranking.com/v1/public/"

        val Coins_api_Service: CoinRankingReq
            get() = RetrofitClient.getClient(BASE_URL)!!.create(
                CoinRankingReq::class.java)
    }
}