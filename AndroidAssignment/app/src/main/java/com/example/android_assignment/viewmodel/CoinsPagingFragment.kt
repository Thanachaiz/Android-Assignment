package com.example.android_assignment.viewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.android_assignment.R
import com.example.android_assignment.adapter.pagingAdapter.PageListCoinsViewModel
import com.example.android_assignment.adapter.pagingAdapter.PagingAdapter

class CoinsPagingFragment : Fragment() {

    companion object {
        fun newInstance() = CoinsPagingFragment()
    }

    private lateinit var coinsViewModel: PageListCoinsViewModel
    val adapter = PagingAdapter()
//    private var itemAdapter = CoinsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.coins_fragment, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coinsViewModel = ViewModelProviders.of(this).get(PageListCoinsViewModel::class.java)
        val recyclerBuildItem : RecyclerView = view.findViewById(R.id.recyclerViewCoins)

        coinsViewModel.getLiveDataCoins().observe(this, Observer {

            recyclerBuildItem.also {recyclerBuildItem ->
                recyclerBuildItem.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                recyclerBuildItem.setHasFixedSize(true)
                recyclerBuildItem.adapter = adapter
            }
            adapter.submitList(it)
        })
    }
}
