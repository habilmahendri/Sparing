package com.habil.sparing.feature.detail.detail_event

import com.habil.sparing.model.Event

interface DetailEventContract {

    interface View {
        fun showDetailEvent(event: Event)
    }

    interface Presenter {
        fun getDetailEvent(id_event: String)
    }
}