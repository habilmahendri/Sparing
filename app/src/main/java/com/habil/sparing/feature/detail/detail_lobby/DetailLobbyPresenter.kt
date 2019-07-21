package com.habil.sparing.feature.detail.detail_lobby

import com.google.firebase.database.*
import com.habil.sparing.model.Lobby
import com.habil.sparing.model.Notif

class DetailLobbyPresenter(val mView: DetailLobbyContract.View) : DetailLobbyContract.Presenter {


    private var reference: DatabaseReference? = null
    lateinit var lobby: Lobby

    override fun getDetailLobby(id_lobby: String) {
        reference = FirebaseDatabase.getInstance().reference.child("lobby").child(id_lobby)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                lobby = dataSnapshot.getValue(Lobby::class.java)!!
                mView.showDetail(lobby)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

        override fun sendNotif(id_notif:String,notif: Notif) {
        reference = FirebaseDatabase.getInstance().reference.child("notif").child(id_notif).child(notif.id_notif!!)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.ref.setValue(notif)
                mView.showNotif()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

//    override fun sendNotif(username: Notif, id_notif: String) {
//        reference = FirebaseDatabase.getInstance().reference.child("notif").child(username.username!!).child(id_notif)
//        reference!!.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                dataSnapshot.ref.setValue(username)
//                mView.showNotif()
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//
//            }
//        })
//    }

    override fun sendLawan(team_lawan: String, id_lobby: String) {
        reference = FirebaseDatabase.getInstance().reference.child("lobby").child(id_lobby)
        reference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.ref.child("team_lawan").setValue(team_lawan)
                mView.showLawan()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

}