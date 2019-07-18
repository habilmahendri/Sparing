package com.habil.sparing.feature.explore.tabs.vanue

import com.google.firebase.database.*
import com.habil.sparing.model.Venue

class VanuePresenter(val mView: VanueContract.View) : VanueContract.Presenter {
    var listVanue: MutableList<Venue> = mutableListOf()
    var reference: DatabaseReference?= null

    override fun getVanue() {
        reference = FirebaseDatabase.getInstance().reference.child("vanue")
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listVanue.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Venue::class.java)
                    listVanue.add(p!!)

                }
                mView.showVanue(listVanue)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}