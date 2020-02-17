package com.example.android_assignment.adapter

import android.graphics.drawable.PictureDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.android_assignment.R
import com.example.android_assignment.model.Coin
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CoinViewHolder(view: View) :RecyclerView.ViewHolder(view){

    private var imageCoin: ImageView = view.findViewById(R.id.image_coins)
    private var textName: TextView = view.findViewById(R.id.txt_nameCoins)
    private var textDescription: TextView = view.findViewById(R.id.txt_descriptionCoins)

    fun bind(result: Coin?) = with(itemView) {

        if (result != null) {
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
        } else {

            textName.text = "Loading..."
            textDescription.visibility = View.GONE
            imageCoin.visibility = View.GONE
        }
    }

    companion object {
        fun create(parent: ViewGroup): CoinViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.coins_layout, parent, false)
            return CoinViewHolder(view)
        }
    }
}