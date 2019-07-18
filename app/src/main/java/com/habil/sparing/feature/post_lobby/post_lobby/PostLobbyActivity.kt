package com.habil.sparing.feature.post_lobby.post_lobby

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.MainActivity
import com.habil.sparing.R
import com.habil.sparing.model.Lobby
import kotlinx.android.synthetic.main.activity_post_lobby.*
import org.jetbrains.anko.toast

class PostLobbyActivity : AppCompatActivity(), PostLobbyContract.View {


    lateinit var mPresenter: PostLobbyPresenter
    lateinit var preferencesHelper: PreferencesHelper
    private val time: String = System.currentTimeMillis().toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_lobby)
        preferencesHelper = PreferencesHelper()


        mPresenter = PostLobbyPresenter(this)

        toolbar.title = "Preview Lobby"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        val extras = intent.extras
        val judul: String = extras.getString("JUDUL")
        val kategori: String = extras.getString("KATEGORI")
        val catatan: String = extras.getString("CATATAN")
        val venue: String = extras.getString("VANUE")
        val tanggal: String = extras.getString("TANGGAL")
        val waktu: String = extras.getString("WAKTU")
        val durasi: String = extras.getString("DURASI")
        val username = preferencesHelper.getNameUser(this)
        val full_name = preferencesHelper.getFullName(this)
        val team_name = preferencesHelper.getTeamUser(this)





        tv_date.text = tanggal
        tv_user.text = full_name
        tv_judul.text = judul
        tv_lokasi.text = venue
        tv_time.text = waktu
        tv_catatan.text = catatan


        val lobby = Lobby(
            id_lobby = time,
            judul = judul,
            catatan = catatan,
            team_name = team_name,
            venue = venue,
            tanggal = tanggal,
            waktu = waktu,
            kategori = kategori,
            durasi = durasi,
            username = username,
            full_name = full_name
        )

        btn_post.setOnClickListener {
            btn_post.isEnabled = false
            btn_post.text = "Tunggu ya"
            mPresenter.getLobby(lobby)
        }
    }

    override fun message(message: String) {
        toast(message)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun userPost() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }
}
