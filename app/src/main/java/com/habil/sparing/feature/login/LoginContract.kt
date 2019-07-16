package com.habil.sparing.feature.login

import com.google.firebase.database.DataSnapshot

interface LoginContract {
    interface View {
        fun userLogin(dataSnapshot: DataSnapshot)
        fun message(message: String)
    }

    interface Presenter {
        fun getUser(username:String,password:String)
    }
}