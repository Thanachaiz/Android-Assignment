package com.example.android_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.api.CoinRankingReq.getCoins.Coins_api_Service
import com.example.android_assignment.adapter.CoinsAdapter
import com.example.android_assignment.model.Coin
import com.example.android_assignment.model.CoinsModel
import com.example.android_assignment.viewmodel.CoinsFragment
import com.example.android_assignment.viewmodel.CoinsPagingFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CoinsPagingFragment.newInstance())
                .commitNow()
        }
    }
}
