package com.habil.sparing.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.feature.profile.profile_lawan.ProfileLawanActivity
import com.habil.sparing.model.Lobby
import com.habil.sparing.model.Notif
import kotlinx.android.synthetic.main.item_notif.view.*
import org.jetbrains.anko.startActivity


class NotifAdapter(private val context: Context, private val notif: List<Notif>) :
        RecyclerView.Adapter<NotifAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notif, parent, false))
    }

    override fun getItemCount(): Int = notif.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(notif[position])

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("ResourceAsColor")
        fun bindItem(notif: Notif) {
            if (notif.kategori == "Futsal"){
                itemView.imgKategori.setImageResource(R.drawable.ic_footbal_icon_notif)
                itemView.viewKategori.setBackgroundResource(R.color.colorPrimary)
            } else if (notif.kategori == "Badminton") {
                itemView.imgKategori.setImageResource(R.drawable.ic_shuttlecock_icon_notif)
                itemView.viewKategori.setBackgroundResource(R.color.colorKategoriBadminton)
            } else {
                itemView.imgKategori.setImageResource(R.drawable.ic_basketball_icon_notif)
                itemView.viewKategori.setBackgroundResource(R.color.colorKategoriBasket)
            }

            itemView.tvHari.text = notif.tanggal.substring(0, notif.tanggal.indexOf(","))
            itemView.tvUsername.text = notif.username_lawan
            itemView.tvDeskripsi.text = "Saya siap sparing dengan anda !"
            itemView.tvWaktu.text = notif.waktu

            itemView.setOnClickListener {
                itemView.context.startActivity<ProfileLawanActivity>("username" to notif.username_lawan,
                    "id_lobby" to notif.id_lobby)
            }
        }
    }
}

