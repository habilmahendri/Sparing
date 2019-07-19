package com.habil.sparing

import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import com.habil.sparing.feature.explore.ExploreFragment
import com.habil.sparing.feature.home.HomeFragment
import com.habil.sparing.feature.lobby.LobbyFragment
import com.habil.sparing.feature.notification.NotificationFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import android.widget.TextView
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.feature.splashscreen_intro.SplashScreen




class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val home: Fragment = HomeFragment()
    val explore: Fragment = ExploreFragment()
    val lobby: Fragment = LobbyFragment()
    val notif: Fragment = NotificationFragment()
    private lateinit var preferencesHelper: PreferencesHelper


    val fm = supportFragmentManager
    var active = home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Home"
        setSupportActionBar(toolbar)

        preferencesHelper = PreferencesHelper()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val mChannel = NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT)


            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val headerView = navigationView.getHeaderView(0)
        val navFullName = headerView.findViewById(R.id.nav_fullName) as TextView
        val navEmail = headerView.findViewById(R.id.nav_email) as TextView
        navFullName.text = preferencesHelper.getFullName(this)
        navEmail.text = preferencesHelper.getEmailUser(this)

        fm.beginTransaction().add(R.id.main_container, notif, "4").hide(notif).commit()
        fm.beginTransaction().add(R.id.main_container, lobby, "3").hide(lobby).commit()
        fm.beginTransaction().add(R.id.main_container, explore, "2").hide(explore).commit()
        fm.beginTransaction().add(R.id.main_container, home, "1").commit()

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(home).commit()
                active = home
                toolbar.title = "Home"

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_explore -> {
                fm.beginTransaction().hide(active).show(explore).commit()
                active = explore
                toolbar.title = "Explore"

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_lobby -> {
                fm.beginTransaction().hide(active).show(lobby).commit()
                active = lobby
                toolbar.title = "Lobby"

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fm.beginTransaction().hide(active).show(notif).commit()
                active = notif
                toolbar.title = "Notification"

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_profile -> {
                // Handle the camera action
            }
            R.id.nav_pusatBantuan -> {

            }
            R.id.nav_logout -> {
                val dialog = Dialog(this@MainActivity)
                dialog.setContentView(R.layout.item_dialog_logout)
                val btn_logout = dialog.findViewById(R.id.btn_logout) as Button
                val btn_kembali = dialog.findViewById(R.id.btn_kembali) as Button
                val i = Intent(this@MainActivity, SplashScreen::class.java)


                btn_logout.setOnClickListener {
                    preferencesHelper.reset(this)
                    startActivity(i)
                    finish()
                }

                btn_kembali.setOnClickListener {
                    dialog.hide()
                }

                dialog.show()
                dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val window = dialog.window
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
