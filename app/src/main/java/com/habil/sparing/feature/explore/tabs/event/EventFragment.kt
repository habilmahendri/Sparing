package com.habil.sparing.feature.explore.tabs.event


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.habil.sparing.R
import com.habil.sparing.adapter.EventExploreAdapter
import com.habil.sparing.model.Event
import kotlinx.android.synthetic.main.fragment_event.*


class EventFragment : Fragment() , EventContract.View{
    lateinit var mPresenter: EventPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = EventPresenter(this)
        mPresenter.getEvent()

    }

    override fun showEvent(event: MutableList<Event>) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_event_explore?.layoutManager = layoutManager
        rv_event_explore?.adapter = EventExploreAdapter(event,context)
    }


}
