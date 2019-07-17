package com.habil.sparing.feature.home

import com.google.firebase.database.*
import com.habil.sparing.model.Event
import com.habil.sparing.model.Vanue


class HomePresenter(val mView: HomeContract.View) : HomeContract.Presenter {

    var reference: Query?= null
    var listEvent: MutableList<Event> = mutableListOf()
    var listVanue: MutableList<Vanue> = mutableListOf()

    override fun getEvent() {
        reference = FirebaseDatabase.getInstance().reference.child("event").limitToFirst(4)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listEvent.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Event::class.java)
                    listEvent.add(p!!)

                }
                mView.showEvent(listEvent)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })}

    override fun getVanue() {
        reference = FirebaseDatabase.getInstance().reference.child("vanue").limitToFirst(4)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listVanue.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Vanue::class.java)
                    listVanue.add(p!!)

                }
                mView.showVanue(listVanue)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

}