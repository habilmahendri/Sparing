package com.habil.sparing.feature.detail.detail_lobby

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.R
import com.habil.sparing.model.Lobby
import com.habil.sparing.model.Notif
import kotlinx.android.synthetic.main.activity_detail_lobby.*
import org.jetbrains.anko.toast

class DetailLobbyActivity : AppCompatActivity(), DetailLobbyContract.View {

    lateinit var mPresenter: DetailLobbyPresenter
    private lateinit var preferencesHelper: PreferencesHelper
    var username: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lobby)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        val id: String = intent.getStringExtra("id")
        preferencesHelper = PreferencesHelper()
        username = preferencesHelper.getNameUser(this)

        mPresenter = DetailLobbyPresenter(this)
        mPresenter.getDetailLobby(id)
    }

    override fun showDetail(lobby: Lobby) {
        val dialog = Dialog(this@DetailLobbyActivity)
        dialog.setContentView(R.layout.item_dialog_logout)
        val btn_logout = dialog.findViewById(R.id.btn_logout) as Button
        val btn_kembali = dialog.findViewById(R.id.btn_kembali) as Button
        val tv_deks = dialog.findViewById(R.id.tv_deks) as TextView
        val tv_tittle = dialog.findViewById(R.id.tv_tittle) as TextView
        val img = dialog.findViewById(R.id.img) as ImageView

        tv_date.text = lobby.tanggal
        tv_user.text = lobby.full_name
        toolbar.title = lobby.judul

        tv_judul.text = lobby.judul
        tv_lokasi.text = lobby.venue
        tv_time.text = "${lobby.waktu} - ${lobby.selesai}"
        tv_catatan.text = lobby.catatan
        tv_pembayaran.text = lobby.pembayaran
        Log.e("lobby detail", lobby.catatan)

        val notif = Notif(
            full_name = lobby.full_name,
            id_notif = lobby.id_lobby,
            id_lobby = lobby.id_lobby,
            username = lobby.username,
            tanggal = lobby.tanggal,
            kategori = lobby.kategori,
            username_lawan = username,
            waktu = lobby.waktu
        )


        if (lobby.username.equals(username)) {
            btn_lobby.text = "Sudah dapat lawan ?"
            btn_lobby.setOnClickListener {
                dialog.setContentView(R.layout.item_dialog_addteam)
                val edt_tim = dialog.findViewById(R.id.edt_tim) as EditText
                val btn_update = dialog.findViewById(R.id.btn_update) as Button
                dialog.show()
                dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val window = dialog.window
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

                btn_update.setOnClickListener {
                    mPresenter.sendLawan(edt_tim.text.toString(), lobby.id_lobby)
                }

            }
        } else {
            btn_lobby.text = "Join"
            btn_lobby.setOnClickListener {

                tv_tittle.text = getString(R.string.tittle)
                tv_deks.text =getString(R.string.deks)
                btn_logout.text = "Ya, kami main"
                btn_kembali.text = "kembali"

                btn_logout.setOnClickListener {
                    mPresenter.sendNotif(lobby.username!!, notif)
                    dialog.hide()
                    dialog.setContentView(R.layout.item_dialog_success)
                    val btn_success = dialog.findViewById(R.id.btn_success) as Button
                    dialog.show()
                    btn_success.setOnClickListener {
                        finish()
                    }

                }
                btn_kembali.setOnClickListener {
                    dialog.hide()
                }


                img.setImageResource(R.drawable.ic_undraw_game_day_ucx9)

                dialog.show()
                dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val window = dialog.window
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            }

        }
    }

    override fun showNotif() {
        this.toast("Minta bergabung")
    }

    override fun showLawan() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
