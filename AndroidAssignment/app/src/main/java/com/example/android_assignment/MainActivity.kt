package com.example.android_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.android_assignment.ui.coinsFragment.CoinsFragment
import com.example.android_assignment.ui.pagingFragment.CoinsPagingFragment
import com.example.android_assignment.ui.searchFragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CoinsFragment.newInstance())
                .commitNow()
        }

        navView.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.navigation_recyclerView ->{
                    showFragment(CoinsFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_pagingView ->{
                    showFragment(CoinsPagingFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_searchView ->{
                    showFragment(SearchFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun showFragment(frag: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.apply {
            replace(R.id.container, frag)
            commit()
            addToBackStack(null)
        }
    }
}
