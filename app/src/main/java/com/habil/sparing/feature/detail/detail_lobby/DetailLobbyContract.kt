package com.habil.sparing.feature.detail.detail_lobby

import com.habil.sparing.model.Lobby

interface DetailLobbyContract {
    interface View {
        fun showDetail(lobby:Lobby)
    }

    interface Presenter {
        fun getDetailLobby(id_lobby: String)
    }
}