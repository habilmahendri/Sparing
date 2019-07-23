package com.habil.sparing.feature.lobby.lobby_kategori

import com.google.firebase.database.*
import com.habil.sparing.model.Lobby
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference


class LobbyKategoriPresenter(private val view: LobbyKategoriContract.View) : LobbyKategoriContract.Presenter {

    var list: MutableList<Lobby> = mutableListOf()
    var firebaseDatabase = FirebaseDatabase.getInstance()

    override fun getAllLobbyKategori(kategori: String) {
        val ref = firebaseDatabase.reference.child("lobby").orderByChild("kategori").equalTo(kategori)
        ref!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {

            }

            override fun onDataChange(databaseSnapshot: DataSnapshot) {
                list.clear()

                for (dataSnapshot1 in databaseSnapshot.children) {
                    val p = dataSnapshot1.getValue(Lobby::class.java)
                    list.add(p!!)
                }
                view.showAllLobbyKategori(list)
            }
        })
    }
}