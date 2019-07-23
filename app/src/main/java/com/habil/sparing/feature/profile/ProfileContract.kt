package com.habil.sparing.feature.profile

import com.habil.sparing.model.User

interface ProfileContract {

    interface View {
        fun showEditProfile()

        fun showDetailProfile(user: User)
        fun lihatPertandingan()
    }

    interface Presenter {
        fun getDetailProfile(username: String)
        fun editProfile(user: User)
        fun getDetailProfileLawan(username: String)
    }
}