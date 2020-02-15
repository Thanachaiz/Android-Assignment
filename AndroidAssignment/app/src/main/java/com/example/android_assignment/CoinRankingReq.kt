package com.example.android_assignment

import com.example.android_assignment.model.CoinModels
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinRankingReq {

    @GET("coins")
    fun CoinsService(
        @Query("limit") limit : Int
    ): Call<MutableList<CoinModels>>

    object getCoins {

        val BASE_URL = "https://api.coinranking.com/v1/public/"

        val Coins_api_Service: CoinRankingReq
            get() = RetrofitClient.getClient(BASE_URL)!!.create(CoinRankingReq::class.java)
    }
}