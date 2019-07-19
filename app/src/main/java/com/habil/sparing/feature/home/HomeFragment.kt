package com.habil.sparing.feature.home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.text.HtmlCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habil.adoption.data.PreferencesHelper
import com.habil.sparing.MainActivity

import com.habil.sparing.R
import com.habil.sparing.adapter.EventAdapter
import com.habil.sparing.adapter.VanueHomeAdapter
import com.habil.sparing.feature.lobby.LobbyContract
import com.habil.sparing.feature.login.LoginPresenter
import com.habil.sparing.model.Event
import com.habil.sparing.model.Vanue
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), HomeContract.View {


    private lateinit var preferencesHelper: PreferencesHelper
    lateinit var mPresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferencesHelper = PreferencesHelper()
        mPresenter = HomePresenter(this)
        mPresenter.getEvent()
        mPresenter.getVanue()

        val fullName:String? = preferencesHelper.getFullName(context!!)
        tv_greeting.text =  HtmlCompat.fromHtml(
            "Hello <b>$fullName<br>Mau main apa hari ini ?</b> ",
            HtmlCompat.FROM_HTML_MODE_LEGACY)

        btn_lobby.setOnClickListener {
            view.context.startActivity(Intent(context, MainActivity::class.java))
        }

    }

    override fun showEvent(event: MutableList<Event>) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_event?.layoutManager = layoutManager
        rv_event?.adapter = EventAdapter(event,context)
    }
    override fun showVanue(vanue: MutableList<Vanue>) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_vanue?.layoutManager = layoutManager
        rv_vanue?.adapter = VanueHomeAdapter(vanue,context)
    }


}
