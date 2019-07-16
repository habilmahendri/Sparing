package com.habil.sparing.feature.login

import com.google.firebase.database.*

class LoginPresenter(val mView: LoginContract.View) : LoginContract.Presenter  {

    var reference: DatabaseReference? = null

    override fun getUser(username: String, password: String) {
        reference = FirebaseDatabase.getInstance().reference.child("Users").child(username)
        reference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val pass: String = dataSnapshot.child("password").value.toString()

                if (dataSnapshot.exists()) {
                    if (password == pass) {
                        mView.userLogin(dataSnapshot)
                        mView.message("Login sukses")

                    } else {
                        mView.message("password salah")
                    }
                } else {
                    mView.message("username tidak tersedia")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}