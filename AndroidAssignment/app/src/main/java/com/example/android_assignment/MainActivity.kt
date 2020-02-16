package com.example.android_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.api.CoinRankingReq.getCoins.Coins_api_Service
import com.example.android_assignment.adapter.CoinsAdapter
import com.example.android_assignment.model.Coin
import com.example.android_assignment.model.CoinsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val recyclerCoin: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerViewCoins)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApi()
    }

    private fun callApi(){
        Coins_api_Service.CoinsService().enqueue(object : Callback<CoinsModel>{

            override fun onResponse(call: Call<CoinsModel>, response: Response<CoinsModel>) {

                val responseData = response.body()
                if (response.isSuccessful && responseData?.status == "success"){
                    ///response and status success
                    initData(responseData.data.coins)

                }else{
                    ///response or status not success
                    Log.e("Connect error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CoinsModel>, t: Throwable) {
                Log.e("onFailure error", "${t.printStackTrace()}")

            }
        })
    }

    private fun initData(itemResult: List<Coin>) {

        recyclerCoin.also {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.setHasFixedSize(true)
            it.adapter = CoinsAdapter(itemResult)
        }
    }
}
