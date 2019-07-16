package com.habil.sparing.feature.home

import com.habil.sparing.model.Event
import com.habil.sparing.model.Lobby

interface HomeContract {
    interface View {
        fun showEvent(event: MutableList<Event>)
    }

    interface Presenter {
        fun getEvent()
    }
}