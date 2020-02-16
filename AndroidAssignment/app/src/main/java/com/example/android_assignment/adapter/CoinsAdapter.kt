package com.example.android_assignment.adapter

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.PictureDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment.R
import com.example.android_assignment.model.Coin
import android.net.Uri
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


class CoinsAdapter(
    var dataCoins : List<Coin>? = null
): RecyclerView.Adapter<CoinsAdapter.ItemViewHolder>() {



    companion object{
        var TAG = "coinsAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coins_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = dataCoins?.size ?: 0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val response = dataCoins?.get(position)
        Log.d("TESTData", response.toString())
        holder.bindTo(response)
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var imageCoin : ImageView = view.findViewById(R.id.image_coins)
        private var textName : TextView = view.findViewById(R.id.txt_nameCoins)
        private var textDescription : TextView = view.findViewById(R.id.txt_descriptionCoins)

        fun bindTo(result: Coin?) = with(itemView){
            val mActivity = itemView.context as Activity
            if (result != null){

                val requestBuilder: RequestBuilder<PictureDrawable> = GlideToVectorYou
                    .init()
                    .with(this.context)
                    .requestBuilder

                requestBuilder
                    .load(result.iconUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.btc_icon)
                    .into(imageCoin)


                textName.text = result.name

                textDescription.text = result.description
            }else{

                Toast.makeText(itemView.context, "Not found Coins!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}