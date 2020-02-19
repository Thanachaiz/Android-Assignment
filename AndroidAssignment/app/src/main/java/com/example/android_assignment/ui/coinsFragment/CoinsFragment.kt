package com.example.android_assignment.ui.coinsFragment

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.android_assignment.R
import com.example.android_assignment.adapter.coinAdapter.CoinsAdapter2
import kotlinx.android.synthetic.main.coins_fragment.*

class CoinsFragment : Fragment() {

    companion object {
        fun newInstance() = CoinsFragment()
    }

    private lateinit var coinsViewModel: CoinsViewModel
    var adapter2 = CoinsAdapter2()
//    private var itemAdapter = CoinsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.coins_fragment, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinsViewModel = ViewModelProviders.of(this).get(CoinsViewModel::class.java)

        coins_refresh.setOnRefreshListener {
            coinsViewModel.refresh()
            coins_refresh.isRefreshing = true
        }

        initData()

    }

    private fun initData(){
        val recyclerBuildItem : RecyclerView = view!!.findViewById(R.id.recyclerViewCoins)
        coinsViewModel.getLiveDataCoins().observe(this, Observer {

            recyclerBuildItem.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = adapter2
            }
            coins_refresh.isRefreshing = false
            adapter2.submitList(it)
        })
    }
}
