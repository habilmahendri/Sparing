package com.habil.sparing.feature.register

import com.google.firebase.database.*
import com.habil.sparing.model.User

class RegisterPresenter(val mView:RegisterContract.View):RegisterContract.Presenter {
    var reference: DatabaseReference? = null


    override fun getUser(user: User) {
        reference = FirebaseDatabase.getInstance().reference.child("Users").child(user.user_name)
        reference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if (dataSnapshot.exists()) {
                    mView.message("username tidak tersedia")
                } else {
                    dataSnapshot.ref.setValue(user)
                    mView.userRegister()
                    mView.message("Register sukses")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

}