package com.habil.sparing.feature.post_lobby.post_lobby

import com.habil.sparing.model.Lobby

interface PostLobbyContract {
    interface View {
        fun userPost()
        fun message(message: String)
    }

    interface Presenter {
        fun getLobby(lobby: Lobby)
    }
}