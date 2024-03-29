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
import com.habil.sparing.R

import com.habil.sparing.adapter.EventAdapter
import com.habil.sparing.adapter.VanueHomeAdapter
import com.habil.sparing.feature.lobby.lobby_kategori.LobbyKategoriActivity
import com.habil.sparing.feature.post_lobby.CreateLobbyActivity
import com.habil.sparing.model.Event
import com.habil.sparing.model.Venue
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
            view.context.startActivity(Intent(context, CreateLobbyActivity::class.java))
        }

        cardFutsal.setOnClickListener {
            val intent = Intent(activity, LobbyKategoriActivity::class.java)
            intent.putExtra("kategori", "Futsal")
            startActivity(intent)
        }

        cardBadminton.setOnClickListener {
            val intent = Intent(activity, LobbyKategoriActivity::class.java)
            intent.putExtra("kategori", "Badminton")
            startActivity(intent)
        }

        cardBasket.setOnClickListener {
            val intent = Intent(activity, LobbyKategoriActivity::class.java)
            intent.putExtra("kategori", "Basket")
            startActivity(intent)
        }
    }

    override fun showEvent(event: MutableList<Event>) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_event?.layoutManager = layoutManager
        rv_event?.adapter = EventAdapter(event,context)
    }
    override fun showVanue(vanue: MutableList<Venue>) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_vanue?.layoutManager = layoutManager
        rv_vanue?.adapter = VanueHomeAdapter(vanue,context)
    }

}
