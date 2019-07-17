package com.habil.sparing.feature.explore


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.habil.sparing.R
import com.habil.sparing.adapter.ViewPagerAdapter
import com.habil.sparing.feature.explore.tabs.event.EventFragment
import com.habil.sparing.feature.explore.tabs.vanue.VanueFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vPager = view.findViewById<ViewPager>(R.id.viewpager_main)
        val tabs = view.findViewById<TabLayout>(R.id.tabs_main)
        setupViewPager(vPager)
    }
    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(VanueFragment(), "Vanue")
        adapter.addFragment(EventFragment(), "Event")
        viewPager?.adapter = adapter
    }
}
