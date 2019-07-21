package com.habil.sparing.feature.profile.profile_lawan

import android.util.Log
import com.google.firebase.database.*
import com.habil.sparing.model.User
import com.habil.sparing.feature.profile.ProfileContract


class ProfileLawanPresenter(private val view: ProfileLawanContract.View)
    : ProfileContract.Presenter {

    var reference: DatabaseReference? = null
    lateinit var  user: User

    override fun getDetailProfile(username: String) {
        reference = FirebaseDatabase.getInstance().reference.child("Users").child(username)
        reference!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error Profile ", databaseError.message)
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                user = dataSnapshot!!.getValue(User::class.java)!!
                view.showDetailProfile(user)
                view.lihatPertandingan()
            }

        })
    }

}