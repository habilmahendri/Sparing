package com.habil.sparing.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.model.Event
import kotlinx.android.synthetic.main.item_event_explore.view.*

class EventExploreAdapter (val event: MutableList<Event>, val context: Context?) :
    RecyclerView.Adapter<EventExploreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventExploreAdapter.ViewHolder =
        EventExploreAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_event_explore, parent, false
            )
        )

    override fun getItemCount(): Int = event.size


    override fun onBindViewHolder(holder: EventExploreAdapter.ViewHolder, position: Int) = holder.bind(event[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) {

            Glide.with(itemView)
                .load(event.image)
                .into(itemView.img_event)
        }
    }

}