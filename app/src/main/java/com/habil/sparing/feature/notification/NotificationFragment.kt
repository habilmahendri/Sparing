package com.habil.sparing.feature.notification


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habil.adoption.data.PreferencesHelper

import com.habil.sparing.R
import com.habil.sparing.adapter.NotifAdapter
import com.habil.sparing.model.Notif
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : Fragment(), NotificationContract.View {

    private lateinit var mPresenter: NotificationPresenter
    private var listNotif: MutableList<Notif> = mutableListOf()
    private lateinit var preferencesHelper: PreferencesHelper

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferencesHelper = PreferencesHelper()
        val username = preferencesHelper.getNameUser(requireContext())

        mPresenter = NotificationPresenter(this)
        mPresenter.getAllNotif(username!!)
    }

    override fun showNotif(notif: MutableList<Notif>) {
        listNotif.clear()
        listNotif.addAll(notif)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvNotif?.layoutManager = linearLayoutManager
        rvNotif?.adapter = NotifAdapter(requireContext(), listNotif)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }


}
