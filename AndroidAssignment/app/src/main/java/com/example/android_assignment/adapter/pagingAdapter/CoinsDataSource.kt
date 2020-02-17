package com.example.android_assignment.adapter.pagingAdapter

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.android_assignment.api.CoinRankingReq.getCoins.Coins_api_Service
import com.example.android_assignment.model.Coin
import com.example.android_assignment.model.CoinsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.ceil

const val PAGE_LIMIT = 10
const val PAGE_OFFSET = 1

class CoinsDataSource : PageKeyedDataSource<Int, Coin>(){

    var TOTAL_PAGE = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Coin>) {

        Coins_api_Service.CoinsPageing(
            PAGE_LIMIT,
            PAGE_OFFSET
        ).enqueue(object : Callback<CoinsModel> {

            override fun onResponse(call: Call<CoinsModel>, response: Response<CoinsModel>) {
                val result = response.body()
                if (response.isSuccessful && result?.status == "success") {

                    val dataCoins = result.data.coins
                    if (!dataCoins.isNullOrEmpty()) {

                        Log.d("TESTDATA", dataCoins.toString())

                        callback.onResult(dataCoins, null, PAGE_OFFSET +1)

                    }
                } else {
                    //Response Error
                    Log.e("Response Error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CoinsModel>, t: Throwable) {
                //Response Fail
                Log.e("onFailure", "${t.message}")
            }
        })
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Coin>) {

        Coins_api_Service.CoinsPageing(params.key,
            PAGE_OFFSET
        ).enqueue(object : Callback<CoinsModel> {

            override fun onResponse(call: Call<CoinsModel>, response: Response<CoinsModel>) {
                val result = response.body()
                if (response.isSuccessful && result?.status == "success") {

                    val dataCoins = result.data.coins
                    val total = result.data.stats.total
                    val totalCoin = ceil(total/ PAGE_LIMIT.toDouble())
                    TOTAL_PAGE = totalCoin.toInt()

                    val keyPa = if (params.key < TOTAL_PAGE) params.key + 1 else null

                    if (!dataCoins.isNullOrEmpty()) {

                        Log.e("loadAfter", "${params.key}")

                        callback.onResult(dataCoins, keyPa)

                    }
                } else {
                    //Response Error
                    Log.e("Response Error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CoinsModel>, t: Throwable) {
                //Response Fail
                Log.e("onFailure", "${t.message}")
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Coin>) {

    }

}