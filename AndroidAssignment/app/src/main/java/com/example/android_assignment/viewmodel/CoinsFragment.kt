package com.example.android_assignment.viewmodel

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
import com.example.android_assignment.adapter.CoinsAdapter
import com.example.android_assignment.adapter.CoinsAdapter2

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        coinsViewModel = ViewModelProviders.of(this).get(CoinsViewModel::class.java)

        val recyclerBuildItem : RecyclerView = view!!.findViewById(R.id.recyclerViewCoins)

        coinsViewModel.getLiveDataCoins().observe(this, Observer {

            recyclerBuildItem.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = adapter2
            }
            adapter2.submitList(it)
        })
    }

}
