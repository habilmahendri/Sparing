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
import kotlinx.android.synthetic.main.item_venue.view.*
import org.jetbrains.anko.startActivity

class VanueHomeAdapter(val event: MutableList<Venue>, val context: Context?) :
    RecyclerView.Adapter<VanueHomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VanueHomeAdapter.ViewHolder =
        VanueHomeAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_venue, parent, false
            )
        )

    override fun getItemCount(): Int = event.size


    override fun onBindViewHolder(holder: VanueHomeAdapter.ViewHolder, position: Int) = holder.bind(event[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(vanue: Venue) {

            Glide.with(itemView)
                .load(vanue.image)
                .into(itemView.img_event)
            itemView.tv_name.text = vanue.nama
            itemView.tv_harga.text = "Mulai dari ${vanue.harga}"

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailVenueActivity>("id" to vanue.id_vanue)
            }
        }
    }
}