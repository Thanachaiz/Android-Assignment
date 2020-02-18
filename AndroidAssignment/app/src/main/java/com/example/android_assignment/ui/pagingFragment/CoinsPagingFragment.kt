package com.example.android_assignment.ui.pagingFragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.R
import com.example.android_assignment.adapter.pagingAdapter.PagingAdapter


class CoinsPagingFragment : Fragment() {

    companion object {
        fun newInstance() =
            CoinsPagingFragment()
    }

    private lateinit var coinsViewModel: PageListCoinsViewModel
    var adapter = PagingAdapter()
    private var checkScreen : String? = null
    private var spanCount = 0

//    private var itemAdapter = CoinsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.coins_fragment, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkScreen = resources.getString(R.string.screen)
        coinsViewModel = ViewModelProviders.of(this).get(PageListCoinsViewModel::class.java)
        val recyclerBuildItem : RecyclerView = view.findViewById(R.id.recyclerViewCoins)
        // Create the observer which updates the UI.
//        val nameObserver = Observer<PagedList<Coin>> { it ->
//            // Update the UI, in this case, a TextView.
//            recyclerBuildItem.also {recyclerBuildItem ->
//                recyclerBuildItem.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                recyclerBuildItem.setHasFixedSize(true)
//                recyclerBuildItem.adapter = adapter
//            }
//            adapter.submitList(it)
//        }
//
//        coinsViewModel.getLiveDataCoins().observe(this, nameObserver)
        coinsViewModel.getLiveDataCoins().observe(this, Observer {

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
            adapter.submitList(it)
        })
    }
}
