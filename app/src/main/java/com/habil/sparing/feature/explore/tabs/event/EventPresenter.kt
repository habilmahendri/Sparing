package com.habil.sparing.feature.explore.tabs.event

import com.google.firebase.database.*
import com.habil.sparing.model.Event

class EventPresenter (val mView: EventContract.View) : EventContract.Presenter {
    var listVanue: MutableList<Event> = mutableListOf()
    var reference: DatabaseReference?= null

    override fun getEvent() {
        reference = FirebaseDatabase.getInstance().reference.child("event")
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listVanue.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Event::class.java)
                    listVanue.add(p!!)

                }
                mView.showEvent(listVanue)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}