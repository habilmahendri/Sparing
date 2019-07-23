package com.habil.sparing.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.feature.detail.detail_event.DetailEventActivity
import com.habil.sparing.model.Event
import kotlinx.android.synthetic.main.item_event_home.view.*
import org.jetbrains.anko.startActivity

class EventAdapter (val event: MutableList<Event>, val context: Context?) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder =
        EventAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_event_home, parent, false
            )
        )

    override fun getItemCount(): Int = event.size


    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) = holder.bind(event[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) {

            Glide.with(itemView)
                .load(event.image)
                .into(itemView.img_event)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailEventActivity>("id" to event.id_event)
            }
        }
    }

}