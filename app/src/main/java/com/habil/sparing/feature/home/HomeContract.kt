package com.habil.sparing.feature.home

import com.habil.sparing.model.Event
import com.habil.sparing.model.Venue

interface HomeContract {
    interface View {
        fun showEvent(event: MutableList<Event>)
        fun showVanue(vanue: MutableList<Venue>)
    }

    interface Presenter {
        fun getEvent()
        fun getVanue()
    }
}