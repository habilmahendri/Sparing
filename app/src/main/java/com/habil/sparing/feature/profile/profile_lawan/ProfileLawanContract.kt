package com.habil.sparing.feature.profile.profile_lawan

import com.habil.sparing.model.User

interface ProfileLawanContract {

    interface View {
        fun showDetailProfile(user: User)
        fun lihatPertandingan()
    }

    interface Presenter {
        fun getDetailProfile(username: String)
    }
}