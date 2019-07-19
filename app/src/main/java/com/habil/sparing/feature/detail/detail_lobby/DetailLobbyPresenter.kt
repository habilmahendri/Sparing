package com.habil.sparing.feature.detail.detail_lobby

import com.google.firebase.database.*
import com.habil.sparing.model.Lobby

class DetailLobbyPresenter(val mView: DetailLobbyContract.View) : DetailLobbyContract.Presenter  {
    private var detail: DatabaseReference? = null
    lateinit var lobby: Lobby

    override fun getDetailLobby(id_lobby: String) {
        detail = FirebaseDatabase.getInstance().reference.child("lobby").child(id_lobby)
        detail!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                lobby = dataSnapshot.getValue(Lobby::class.java)!!
                mView.showDetail(lobby)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })}
}