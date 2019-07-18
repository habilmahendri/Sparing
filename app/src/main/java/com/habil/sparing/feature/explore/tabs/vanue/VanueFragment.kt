package com.habil.sparing.feature.explore.tabs.vanue


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habil.sparing.R
import com.habil.sparing.adapter.VanueExploreAdapter
import com.habil.sparing.model.Venue
import kotlinx.android.synthetic.main.fragment_vanue.*

class VanueFragment : Fragment(), VanueContract.View {
    lateinit var mPresenter: VanuePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vanue, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = VanuePresenter(this)
        mPresenter.getVanue()
    }


    override fun showVanue(vanue: MutableList<Venue>) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_vanue?.layoutManager = layoutManager
        rv_vanue?.adapter = VanueExploreAdapter(vanue,context)
    }

}
