package com.habil.sparing.feature.detail.detail_lobby

import com.habil.sparing.model.Lobby
import com.habil.sparing.model.Notif

interface DetailLobbyContract {
    interface View {
        fun showDetail(lobby:Lobby)
        fun showNotif()
        fun showLawan()

    }

    interface Presenter {
        fun getDetailLobby(id_lobby: String)
        fun sendNotif(id_notif:String,notif:Notif)
        fun sendLawan(team_lawan:String,id_lobby: String)
    }
}