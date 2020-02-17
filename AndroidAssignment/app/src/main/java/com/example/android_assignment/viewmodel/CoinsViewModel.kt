package com.example.android_assignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_assignment.api.CoinRankingReq
import com.example.android_assignment.model.Coin
import com.example.android_assignment.model.CoinsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinsViewModel : ViewModel() {

    private var listResult = MutableLiveData<List<Coin>>().apply {
        this.also {
            callApi()
        }
    }

    private fun callApi() {
        CoinRankingReq.getCoins.Coins_api_Service.CoinsService().enqueue(object :
            Callback<CoinsModel> {

            override fun onResponse(call: Call<CoinsModel>, response: Response<CoinsModel>) {

                val responseData = response.body()
                if (response.isSuccessful && responseData?.status == "success") {
                    ///response and status success

                    val data : List<Coin> = (responseData.data.coins)
                    listResult.value = data

                } else {
                    ///response or status not success
                    Log.e("Connect error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CoinsModel>, t: Throwable) {
                Log.e("onFailure error", "${t.printStackTrace()}")

            }
        })
    }

    fun getLiveDataCoins(): LiveData<List<Coin>>{

        if (listResult == null){
            listResult = MutableLiveData()
        }

        return listResult
    }
}