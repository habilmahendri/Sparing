package com.habil.sparing.feature.splashscreen_intro


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habil.sparing.R
import com.habil.sparing.feature.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_intro.*
import org.jetbrains.anko.intentFor


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_lanjutkan.setOnClickListener {
            startActivity(context!!.intentFor<LoginActivity>())
            activity!!.finishAffinity()
        }
    }

}
