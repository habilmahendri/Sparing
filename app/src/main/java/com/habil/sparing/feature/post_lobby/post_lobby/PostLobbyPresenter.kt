package com.habil.sparing.feature.post_lobby.post_lobby

import com.google.firebase.database.*
import com.habil.sparing.feature.register.RegisterContract
import com.habil.sparing.model.Lobby
import com.habil.sparing.model.User

class PostLobbyPresenter(val mView: PostLobbyContract.View): PostLobbyContract.Presenter {
    var reference: DatabaseReference? = null

    override fun getLobby(lobby: Lobby) {
        reference = FirebaseDatabase.getInstance().reference.child("lobby").child(lobby.id_lobby)
        reference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                dataSnapshot.ref.setValue(lobby)
                mView.userPost()
                mView.message("Anda berhasil membuat lobby baru")
//                if (dataSnapshot.exists()) {
//                    mView.message("username tidak tersedia")
//                } else {
//
//                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }) }



}