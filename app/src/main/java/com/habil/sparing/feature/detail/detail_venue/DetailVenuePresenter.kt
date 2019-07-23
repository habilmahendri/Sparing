package com.habil.sparing.feature.detail.detail_venue

import android.util.Log
import com.google.firebase.database.*
import com.habil.sparing.model.Notif
import com.habil.sparing.model.Venue

class DetailVenuePresenter(private val view: DetailVenueContract.View)
    : DetailVenueContract.Presenter {

    lateinit var venue: Venue
    var reference: DatabaseReference? = null
    var fasilitas: MutableList<Venue> = mutableListOf()

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

    override fun getFasilitas(id_fasilitas: String) {
        reference = FirebaseDatabase.getInstance().reference.child("fasilitas").child(id_fasilitas)
        reference!!.addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot) {
                fasilitas.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Venue::class.java)
                    fasilitas.add(p!!)
                }
                view.showFasilitas(fasilitas)
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }

        })
    }

}
