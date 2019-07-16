package com.habil.sparing.feature.lobby

import com.habil.sparing.model.Lobby

interface LobbyContract {

    interface View {
        fun showAllLobby(lobby: MutableList<Lobby>)
    }

    interface Presenter {
        fun getAllLobby()
    }
}