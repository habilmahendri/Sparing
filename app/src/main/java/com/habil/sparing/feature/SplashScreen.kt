package com.habil.sparing.feature

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.MainActivity
import com.habil.sparing.R
import com.habil.sparing.feature.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    private lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar!!.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        setContentView(R.layout.activity_splash_screen)
        preferencesHelper = PreferencesHelper()


        val animation:Animation = AnimationUtils.loadAnimation(this, R.anim.app_splash)
        splash.startAnimation(animation)

        Handler().postDelayed({

            if (preferencesHelper.getLoggedStatus(this)) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))

            }
            finish()
        }, 1500)
    }
}
