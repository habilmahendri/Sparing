package com.habil.sparing.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.feature.detail.DetailLobbyActivity
import com.habil.sparing.model.Lobby
import kotlinx.android.synthetic.main.item_notif.view.*
import org.jetbrains.anko.startActivity

class NotifAdapter(private val context: Context, private val lobby: List<Lobby>) :
        RecyclerView.Adapter<NotifAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notif, parent, false))
    }

    override fun getItemCount(): Int = lobby.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(lobby[position])

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgKategori = view.findViewById<ImageView>(R.id.imgKategori)

        fun bindItem(lobby: Lobby) {

            itemView.tvHari.text = lobby.tanggal

        }
    }
}