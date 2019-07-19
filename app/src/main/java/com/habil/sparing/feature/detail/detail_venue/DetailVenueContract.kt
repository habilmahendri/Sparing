package com.habil.sparing.feature.detail.detail_venue

import com.habil.sparing.model.Venue

interface DetailVenueContract {

    interface View {
        fun showDetail(vanue: Venue)
    }

    interface Presenter {
        fun getDetailVenue(id_venue: String)
    }
}