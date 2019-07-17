package com.habil.sparing.feature.explore.tabs.event

import com.habil.sparing.model.Event
import com.habil.sparing.model.Vanue

interface EventContract {
    interface View {
        fun showEvent(event: MutableList<Event>)
    }

    interface Presenter {
        fun getEvent()
    }
}