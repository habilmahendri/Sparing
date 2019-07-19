package com.habil.sparing.feature.detail.detail_event

import android.util.Log
import com.google.firebase.database.*
import com.habil.sparing.model.Event

class DetailEventPresenter(private val view: DetailEventContract.View)
    : DetailEventContract.Presenter {

    private lateinit var event: Event
    private var reference: DatabaseReference? = null

    override fun getDetailEvent(id_event: String) {
        reference = FirebaseDatabase.getInstance().reference.child("event").child(id_event)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error Detail Event", databaseError.message)
            }

            override fun onDataChange(databaseSnapshot: DataSnapshot) {
                event = databaseSnapshot.getValue(Event::class.java)!!
                view.showDetailEvent(event)
            }

        })

    }
}