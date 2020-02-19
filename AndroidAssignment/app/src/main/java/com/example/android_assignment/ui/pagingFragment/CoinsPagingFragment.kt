package com.example.android_assignment.ui.pagingFragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.R
import com.example.android_assignment.adapter.pagingAdapter.PagingAdapter
import com.example.android_assignment.model.Coin
import kotlinx.android.synthetic.main.coins_fragment.*


class CoinsPagingFragment : Fragment() {

    companion object {
        fun newInstance() =
            CoinsPagingFragment()
    }

    private lateinit var coinsViewModel: PageListCoinsViewModel

    private lateinit var recyclerBuildItem: RecyclerView
    var adapter = PagingAdapter()
    private var checkScreen : String? = null
    private var spanCount = 0

//    private var itemAdapter = CoinsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.coinspaging_fragment, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkScreen = resources.getString(R.string.screen)
        coinsViewModel = ViewModelProviders.of(this).get(PageListCoinsViewModel::class.java)
        recyclerBuildItem = view.findViewById(R.id.recyclerViewCoins)

        coins_refresh.setOnRefreshListener {
            coinsViewModel.refresh()
        }

        coinsViewModel.uiList.observe(this, Observer {
            coins_refresh.isRefreshing = false
            initData(it)
        })

        getInitialData()
    }

    private fun getInitialData() {
        coins_refresh.isRefreshing = true
        coinsViewModel.refresh()
    }

    private fun initData(result: PagedList<Coin>){
        recyclerBuildItem.also { recyclerBuildItem ->

            spanCount = when (checkScreen){
                "tablet" ->{
                    2
                }
                "tablet7" ->{
                    2
                }
                "tablet10" ->{
                    3
                }
                else ->{
                    1
                }
            }
            recyclerBuildItem.layoutManager = GridLayoutManager(context, spanCount)
            recyclerBuildItem.setHasFixedSize(true)
            recyclerBuildItem.adapter = adapter
        }
        adapter.submitList(result)
    }
}
