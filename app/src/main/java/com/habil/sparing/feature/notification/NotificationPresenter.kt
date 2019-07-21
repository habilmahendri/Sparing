package com.habil.sparing.feature.notification

import com.google.firebase.database.*
import com.habil.sparing.model.Notif

class NotificationPresenter(private val view: NotificationContract.View)
    : NotificationContract.Presenter {

    var notif: MutableList<Notif> = mutableListOf()
    var reference: DatabaseReference? = null

    override fun getAllNotif(username: String) {
        reference = FirebaseDatabase.getInstance().reference.child("notif").child(username)
        reference!!.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                notif.clear()

                for (dataSnapshot1 in dataSnapshot.children) {
                    val p = dataSnapshot1.getValue(Notif::class.java)
                    notif.add(p!!)
                }
                view.showNotif(notif)
            }

        })
    }
}