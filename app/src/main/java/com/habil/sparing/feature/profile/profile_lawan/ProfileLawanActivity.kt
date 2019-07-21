package com.habil.sparing.feature.profile.profile_lawan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.habil.sparing.R
import com.habil.sparing.feature.detail.detail_lobby.DetailLobbyActivity
import com.habil.sparing.model.User
import kotlinx.android.synthetic.main.activity_profile_lawan.*
import org.jetbrains.anko.startActivity

class ProfileLawanActivity : AppCompatActivity(), ProfileLawanContract.View {

    private lateinit var mPresenter: ProfileLawanPresenter
    private var idPertandingan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_lawan)

        val usernameLawan = intent.getStringExtra("username")
        idPertandingan = intent.getStringExtra("id_lobby")

        setSupportActionBar(toolbar)
        supportActionBar?.title = usernameLawan
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mPresenter = ProfileLawanPresenter(this)
        mPresenter.getDetailProfile(usernameLawan)
    }

    override fun showDetailProfile(user: User) {
        edtFullname.setText(user.full_name)
        edtUsername.setText(user.user_name)
        edtEmail.setText(user.email)
        edtPhoneNumber.setText(user.phone_number)
    }

    override fun lihatPertandingan() {
        btnLihatPertandingan.setOnClickListener {
            startActivity<DetailLobbyActivity>("id" to idPertandingan)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
