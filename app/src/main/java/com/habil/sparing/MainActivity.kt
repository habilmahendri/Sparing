package com.habil.sparing

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.FirebaseDatabase
import com.habil.sparing.feature.explore.ExploreFragment
import com.habil.sparing.feature.home.HomeFragment
import com.habil.sparing.feature.lobby.LobbyFragment
import com.habil.sparing.feature.notification.NotificationFragment


class MainActivity : AppCompatActivity() {
    val home: Fragment = HomeFragment()
    val explore: Fragment = ExploreFragment()
    val lobby: Fragment = LobbyFragment()
    val notif: Fragment = NotificationFragment()

    val fm = supportFragmentManager
    var active = home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

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
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_explore -> {
                fm.beginTransaction().hide(active).show(explore).commit()
                active = explore
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_lobby -> {
                fm.beginTransaction().hide(active).show(lobby).commit()
                active = lobby
                return@OnNavigationItemSelectedListener true
            }R.id.navigation_notifications -> {
                fm.beginTransaction().hide(active).show(notif).commit()
                active = notif

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
