package com.habil.sparing.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.text.HtmlCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habil.adoption.data.PreferencesHelper

import com.habil.sparing.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var preferencesHelper: PreferencesHelper

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

        val fullName:String? = preferencesHelper.getFullName(context!!)
        tv_greeting.text =  HtmlCompat.fromHtml(
            "Hello <b>$fullName<br>Mau main apa hari ini ?</b> ",
            HtmlCompat.FROM_HTML_MODE_LEGACY)

    }


}
