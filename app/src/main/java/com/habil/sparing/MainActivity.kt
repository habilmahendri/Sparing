package com.habil.sparing

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadHomeFragment(savedInstanceState)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_explore -> {
                    loadExploreFragment(savedInstanceState)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_lobby -> {
                    loadLobbyFragment(savedInstanceState)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    loadNotifFragment(savedInstanceState)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun loadHomeFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, HomeFragment(), HomeFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadExploreFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, ExploreFragment(), ExploreFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadLobbyFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, LobbyFragment(), LobbyFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadNotifFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NotificationFragment(), NotificationFragment::class.java.simpleName)
                .commit()
        }
    }





}
