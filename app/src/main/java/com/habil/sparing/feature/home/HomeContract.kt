package com.habil.sparing.feature.home

import com.habil.sparing.model.Event
import com.habil.sparing.model.Lobby
import com.habil.sparing.model.Vanue

interface HomeContract {
    interface View {
        fun showEvent(event: MutableList<Event>)
        fun showVanue(vanue: MutableList<Vanue>)
    }

    interface Presenter {
        fun getEvent()
        fun getVanue()
    }
}