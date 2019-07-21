package com.habil.sparing.feature.notification

import com.habil.sparing.model.Notif

interface NotificationContract {

    interface View {
        fun showNotif(notif: MutableList<Notif>)
    }

    interface Presenter {
        fun getAllNotif(username: String)
    }
}