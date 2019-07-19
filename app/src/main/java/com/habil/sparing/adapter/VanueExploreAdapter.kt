package com.habil.sparing.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.feature.detail.detail_venue.DetailVenueActivity
import com.habil.sparing.model.Venue
import kotlinx.android.synthetic.main.item_vanue_explore.view.*
import org.jetbrains.anko.startActivity

class VanueExploreAdapter (val event: MutableList<Venue>, val context: Context?) :
    RecyclerView.Adapter<VanueExploreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VanueExploreAdapter.ViewHolder =
        VanueExploreAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_vanue_explore, parent, false
            )
        )

    override fun getItemCount(): Int = event.size


    override fun onBindViewHolder(holder: VanueExploreAdapter.ViewHolder, position: Int) = holder.bind(event[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(vanue: Venue) {

            Glide.with(itemView)
                .load(vanue.image)
                .into(itemView.img_vanue)
            itemView.tv_nameVanue.text = vanue.nama
            itemView.tv_locationVanue.text = vanue.location
            itemView.tv_hargaVanue.text = vanue.harga

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailVenueActivity>("id" to vanue.id_vanue)
            }

        }
    }
}