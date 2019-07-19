package com.habil.sparing.feature.profile

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.MenuItem
import android.view.View
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.R
import com.habil.sparing.model.User
import kotlinx.android.synthetic.main.activity_profile.*
import org.jetbrains.anko.toast

class ProfileActivity : AppCompatActivity(), ProfileContract.View {

    private lateinit var presenter: ProfilePresenter
    private lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Profile"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        preferencesHelper = PreferencesHelper()
        val username = preferencesHelper.getNameUser(this)

        presenter = ProfilePresenter(this)
        presenter.getDetailProfile(username!!)

    }

    override fun showDetailProfile(user: User) {
        edtFullname.setText(user.full_name)
        edtUsername.setText(user.user_name)
        edtEmail.setText(user.email)
        edtPhoneNumber.setText(user.phone_number)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) this.finish()

        return super.onOptionsItemSelected(item)
    }
}
