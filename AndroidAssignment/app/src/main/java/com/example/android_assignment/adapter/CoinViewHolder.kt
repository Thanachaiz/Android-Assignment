package com.example.android_assignment.adapter

import android.graphics.drawable.PictureDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.android_assignment.R
import com.example.android_assignment.model.Coin
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CoinViewHolder(view: View) :RecyclerView.ViewHolder(view){

    ///view
    private var imageCoin: ImageView = view.findViewById(R.id.image_coins)
    private var textName: TextView = view.findViewById(R.id.txt_nameCoins)
    private var textDescription: TextView = view.findViewById(R.id.txt_descriptionCoins)
    private var layout_Coins: ConstraintLayout = view.findViewById(R.id.constraint_view)

    ///view2
    private var imageCoin2: ImageView = view.findViewById(R.id.image_coins2)
    private var textName2: TextView = view.findViewById(R.id.txt_nameCoins2)
    private var layout_Coins2: ConstraintLayout = view.findViewById(R.id.constraint_view2)


    fun bind(result: Coin?) = with(itemView) {

        if (result != null) {

            if (adapterPosition > 0 && (adapterPosition % 5) == 0) {

                layout_Coins.visibility = View.GONE
                layout_Coins2.visibility = View.VISIBLE
                val requestBuilder: RequestBuilder<PictureDrawable> = GlideToVectorYou
                    .init()
                    .with(this.context)
                    .requestBuilder

                requestBuilder
                    .load(result.iconUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.btc_icon)
                    .into(imageCoin2)

                textName2.text = result.name

            } else {
                layout_Coins2.visibility = View.GONE
                layout_Coins.visibility = View.VISIBLE

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
            }

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