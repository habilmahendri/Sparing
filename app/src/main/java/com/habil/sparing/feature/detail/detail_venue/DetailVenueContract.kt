package com.habil.sparing.feature.detail.detail_venue

import com.habil.sparing.model.Venue

interface DetailVenueContract {

    interface View {
        fun showDetail(vanue: Venue)
        fun showFasilitas(venue: MutableList<Venue>)
    }

    interface Presenter {
        fun getDetailVenue(id_venue: String)
        fun getFasilitas(id_fasilitas: String)
    }
}