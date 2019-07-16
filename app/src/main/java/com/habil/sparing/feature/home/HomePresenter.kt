package com.habil.sparing.feature.home

import android.util.Log
import com.google.firebase.database.*
import com.habil.sparing.feature.lobby.LobbyPresenter
import com.habil.sparing.model.Event
import com.habil.sparing.model.Lobby


class HomePresenter(val mView: HomeContract.View) : HomeContract.Presenter {
    var reference: Query?= null
    var list: MutableList<Event> = mutableListOf()

    override fun getEvent() {
        reference = FirebaseDatabase.getInstance().reference.child("event").limitToFirst(1)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Event::class.java)
                    list.add(p!!)
                    Log.e("size", list.size.toString())

                }
                mView.showEvent(list)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })}
}