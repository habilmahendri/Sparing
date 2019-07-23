package com.habil.sparing.feature.lobby.lobby_kategori

import com.habil.sparing.model.Lobby

interface LobbyKategoriContract {

    interface View {
        fun showAllLobbyKategori(lobby: MutableList<Lobby>)
    }

    interface Presenter {
        fun getAllLobbyKategori(kategori: String)
    }
}