package com.habil.sparing.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import com.habil.sparing.R
import java.net.HttpURLConnection
import java.net.URL




class MyMessagingService : FirebaseMessagingService() {

    var bitmap: Bitmap? = null

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        val imageUri = remoteMessage!!.data["image"]
        val message = remoteMessage.data["message"]
        val title = remoteMessage.data["title"]


        //To get a Bitmap image from the URL received
        bitmap = getBitmapfromUrl(imageUri!!)

        showNotification(title, message, bitmap)
    }

    fun showNotification(title: String?, message: String?, image: Bitmap?) {
        val notification = NotificationCompat.Builder(this, "MyNotifications")
            .setSmallIcon(com.habil.sparing.R.drawable.ic_arrow_back_black_24dp)
            .setContentTitle(title)
            .setContentText(message)
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(image)
            )
            .build()

        val manager: NotificationManagerCompat = NotificationManagerCompat.from(this)
        manager.notify(999, notification)
    }

    fun getBitmapfromUrl(imageUrl: String): Bitmap? {
        try {
            val url = URL(imageUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            return BitmapFactory.decodeStream(input)

        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            return null

        }

    }
}