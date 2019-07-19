package com.habil.sparing.feature.detail.detail_lobby

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.habil.sparing.R
import com.habil.sparing.model.Lobby

class DetailLobbyActivity : AppCompatActivity(),DetailLobbyContract.View  {
    lateinit var mPresenter: DetailLobbyPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lobby)


        val extras = intent.extras
        val id: String = intent.getStringExtra("id")

        mPresenter = DetailLobbyPresenter(this)
        mPresenter.getDetailLobby(id)
    }

    override fun showDetail(lobby: Lobby) {

        Log.e("lobby detail",lobby.catatan)
    }

}
