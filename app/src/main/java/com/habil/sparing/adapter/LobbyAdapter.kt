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
import com.habil.sparing.feature.detail.detail_lobby.DetailLobbyActivity
import com.habil.sparing.model.Lobby
import kotlinx.android.synthetic.main.item_lobby.view.*
import org.jetbrains.anko.startActivity

class LobbyAdapter(private val context: Context, private val lobby: List<Lobby>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lobby, parent, false))
    }

    override fun getItemCount(): Int = lobby.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(lobby[position])
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imgKategori = view.findViewById<ImageView>(R.id.imgKategori)
    private val btnMasukRuangLobby = view.findViewById<Button>(R.id.btnMasukRuangLobby)

    fun bindItem(lobby: Lobby) {
        Glide.with(itemView)
            .load(lobby.kategori)
            .into(imgKategori)
        itemView.tvUsername.text = lobby.username

        itemView.tvJudul.text = lobby.judul
        itemView.tvTanggal.text = lobby.tanggal
        itemView.tvWaktu.text = "${lobby.waktu} - ${lobby.selesai} "
        itemView.tvTeam.text = lobby.team_name
        itemView.tvTeamLawan.text = lobby.team_lawan

        itemView.btnMasukRuangLobby.setOnClickListener {
            itemView.context.startActivity<DetailLobbyActivity>("id" to lobby.id_lobby)

        }

    }
}