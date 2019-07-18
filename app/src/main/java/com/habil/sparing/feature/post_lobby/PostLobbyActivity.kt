package com.habil.sparing.feature.post_lobby

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.habil.sparing.R
import kotlinx.android.synthetic.main.activity_post_lobby.*

class PostLobbyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_lobby)

        toolbar.title = "Preview Lobby"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        val extras = intent.extras

        tv_judul.text = extras.getString("JUDUL")
        tv_lokasi.text = extras.getString("VANUE")
       // Log.e("bundle post", )
    }
}
