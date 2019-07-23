package com.habil.sparing.feature.lobby.lobby_kategori

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.habil.sparing.R
import com.habil.sparing.adapter.LobbyAdapter
import com.habil.sparing.model.Lobby
import kotlinx.android.synthetic.main.activity_lobby_kategori.*

class LobbyKategoriActivity : AppCompatActivity(), LobbyKategoriContract.View {

    private var listLobby: MutableList<Lobby> = mutableListOf()
    private lateinit var presenter: LobbyKategoriPresenter
    var kategori: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby_kategori)

        setSupportActionBar(toolbar)

        kategori = intent.getStringExtra("kategori")
        supportActionBar!!.title = "Lobby ${kategori}"

        presenter = LobbyKategoriPresenter(this)
        presenter.getAllLobbyKategori(kategori!!)
    }

    override fun showAllLobbyKategori(lobby: MutableList<Lobby>) {
        lobby.reverse()
        listLobby.clear()
        listLobby.addAll(lobby)
        val linearLayoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        rvLobby?.layoutManager = linearLayoutManager
        rvLobby?.adapter = LobbyAdapter(applicationContext, listLobby)
    }
}
