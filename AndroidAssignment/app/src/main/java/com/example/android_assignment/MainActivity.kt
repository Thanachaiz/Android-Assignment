package com.example.android_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_assignment.`ีร`.CoinsFragment
import com.example.android_assignment.`ีร`.pagingFragment.CoinsPagingFragment

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
