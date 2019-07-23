package com.habil.sparing.feature.lobby

import com.google.firebase.database.*
import com.habil.sparing.model.Lobby
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference






class LobbyPresenter(private val view: LobbyContract.View) : LobbyContract.Presenter {

    var reference: DatabaseReference?= null
    var list: MutableList<Lobby> = mutableListOf()

    override fun getAllLobby() {
        reference = FirebaseDatabase.getInstance().reference.child("lobby")
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Lobby::class.java)
                    list.add(p!!)
                }
                view.showAllLobby(list)


            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}