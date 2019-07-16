package com.habil.sparing.feature.register

import com.habil.sparing.model.User

interface RegisterContract {
    interface View {
        fun userRegister()
        fun message(message: String)
    }

    interface Presenter {
        fun getUser(user: User)
    }
}