package com.habil.sparing.feature.login

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.MainActivity
import com.habil.sparing.R
import com.habil.sparing.feature.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(), LoginContract.View  {

    lateinit var mPresenter: LoginPresenter
    lateinit var preferencesHelper: PreferencesHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar!!.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(R.layout.activity_login)
        preferencesHelper = PreferencesHelper()



        btn_login.setOnClickListener {

            if (edt_username.text.toString().trim().isNotEmpty() && edt_password.text.toString().trim().isNotEmpty()) {
                btn_login.text = "Tunggu ya.."
                btn_login.isEnabled = false
                callFirebase(edt_username.text.toString(), edt_password.text.toString())
            } else {
                btn_login.isEnabled = true
                btn_login.text = "Login"
                toast("masukkan data dengan benar")

            }
        }

        btn_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun userLogin(dataSnapshot: DataSnapshot) {
        preferencesHelper.setFullName(this, dataSnapshot.child("full_name").value.toString())
        preferencesHelper.setEmailUser(this,dataSnapshot.child("email").value.toString())
        preferencesHelper.setNameUser(this,dataSnapshot.child("user_name").value.toString())
        preferencesHelper.setLoggedIn(this, true)

        startActivity(applicationContext.intentFor<MainActivity>())
        finish()


    }

    override fun message(message: String) {
        btn_login.isEnabled = true
        btn_login.text = "Login"
        toast(message)
    }

    private fun callFirebase(username: String, password: String) {
        mPresenter = LoginPresenter(this)
        mPresenter.getUser(username, password)
    }


}
