package com.habil.sparing.feature.profile

import android.util.Log
import com.google.firebase.database.*
import com.habil.sparing.model.User
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.content.pm.PackageManager
import com.google.android.gms.common.util.ClientLibraryUtils.getPackageInfo
import android.content.pm.PackageInfo
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity

class ProfilePresenter(private val view: ProfileContract.View)
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
            }

        })
    }

    override fun editProfile(user: User) {
        reference = FirebaseDatabase.getInstance().reference.child("Users").child(user.user_name)
        reference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                Log.e("edit profile",user.user_name)
                if (dataSnapshot.exists()) {

                } else {
                    dataSnapshot.ref.setValue(user)
                    view.showEditProfile()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }


}