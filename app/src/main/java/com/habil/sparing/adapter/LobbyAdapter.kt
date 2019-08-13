package com.habil.sparing.adapter

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
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
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity

class LobbyAdapter(private val context: Context, private val lobby: List<Lobby>) :
    RecyclerView.Adapter<LobbyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lobby, parent, false))
    }

    override fun getItemCount(): Int = lobby.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(lobby[position])

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgKategori = view.findViewById<ImageView>(R.id.imgKategori)
        private val imgProfile = view.findViewById<ImageView>(R.id.imgProfile)

        fun bindItem(lobby: Lobby) {
            imgProfile.setImageResource(R.drawable.ic_profile_notif)

            var kategori = lobby.kategori
            if (kategori == "Futsal") imgKategori.setImageResource(R.drawable.ic_football_icon)
            else if (kategori == "Basket") imgKategori.setImageResource(R.drawable.ic_basketball_icon)
            else imgKategori.setImageResource(R.drawable.ic_shuttlecock_icon)

            itemView.tvUsername.text = lobby.full_name
            itemView.tvJudul.text = lobby.judul
            itemView.tvTanggal.text = lobby.tanggal
            itemView.tvWaktu.text = lobby.waktu
            itemView.tvTeam.text = lobby.team_name

            if (lobby.team_lawan != null) itemView.tvTeamLawan.text = lobby.team_lawan
            else itemView.tvTeamLawan.text = "..."

            itemView.btnMasukRuangLobby.setOnClickListener {

                //itemView.context.startActivity<DetailLobbyActivity>("id" to lobby.id_lobby)
                itemView.context.startActivity(  itemView.context.intentFor<DetailLobbyActivity>("id" to lobby.id_lobby).newTask())

            }
        }

    }
}
