package com.example.android_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_assignment.CoinRankingReq.getCoins.Coins_api_Service
import com.example.android_assignment.model.CoinModels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Coins_api_Service.CoinsService(1).enqueue(object : Callback<MutableList<CoinModels>>{
            override fun onFailure(call: Call<MutableList<CoinModels>>, t: Throwable) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<MutableList<CoinModels>>,
                response: Response<MutableList<CoinModels>>
            ) {
                //To change body of created functions use File | Settings | File Templates.
                val response = response.body()
                println(response)
            }


        })
    }
}
