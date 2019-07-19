package com.habil.sparing.feature.detail.detail_venue

import android.util.Log
import com.google.firebase.database.*
import com.habil.sparing.model.Venue

class DetailVenuePresenter(private val view: DetailVenueContract.View)
    : DetailVenueContract.Presenter {

    lateinit var venue: Venue
    var reference: DatabaseReference?= null

    override fun getDetailVenue(id_venue: String) {
        reference = FirebaseDatabase.getInstance().reference.child("vanue").child(id_venue)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error Detail Venue", databaseError.message)
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                venue = dataSnapshot.getValue(Venue::class.java)!!
                view.showDetail(venue)
            }

        })
    }
}
