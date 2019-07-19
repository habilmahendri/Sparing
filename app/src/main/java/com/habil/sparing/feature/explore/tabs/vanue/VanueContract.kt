package com.habil.sparing.feature.explore.tabs.vanue

import com.habil.sparing.model.Venue

interface VanueContract {
    interface View {
        fun showVanue(vanue: MutableList<Venue>)
    }

    interface Presenter {
        fun getVanue()
    }
}