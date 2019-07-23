package com.habil.sparing.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habil.sparing.R
import com.habil.sparing.model.Venue
import kotlinx.android.synthetic.main.item_fasilitas.view.*

class FasilitasAdapter(val event: MutableList<Venue>, val context: Context?) :
        RecyclerView.Adapter<FasilitasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FasilitasAdapter.ViewHolder =
            FasilitasAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fasilitas, parent, false)
            )

    override fun getItemCount(): Int = event.size


    override fun onBindViewHolder(holder: FasilitasAdapter.ViewHolder, position: Int) = holder.bind(event[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(venue: Venue) {

            itemView.tv_fasilitas.text = venue.fasilitas


        }
    }

}