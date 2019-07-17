package com.habil.sparing.feature.explore.tabs.vanue

import com.habil.sparing.model.Vanue

interface VanueContract {
    interface View {
        fun showVanue(vanue: MutableList<Vanue>)
    }

    interface Presenter {
        fun getVanue()
    }
}