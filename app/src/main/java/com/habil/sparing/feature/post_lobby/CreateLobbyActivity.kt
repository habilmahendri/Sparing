package com.habil.sparing.feature.post_lobby

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lobby_new.*
import android.content.Intent
import android.R


class CreateLobbyActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var list_of_category = arrayOf("Main Apa ?", "Futsal", "Badminton", "Basket")
    var category:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.habil.sparing.R.layout.activity_lobby_new)
        toolbar.title = "Pertandingan Baru"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        spinner!!.onItemSelectedListener = this

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_category)

        // Set layout to use when the list of choices appear
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.adapter = arrayAdapter

        btn_lanjutkan.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString("JUDUL",tv_judul.text.toString())
            mBundle.putString("KATEGORI",category)
            mBundle.putString("CATATAN",tv_note.text.toString())

            val intent = Intent(this, LocationLobby::class.java)
            intent.putExtras(mBundle)
            startActivity(intent)


        }




    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        category = list_of_category[position]

        Log.e("spinner", category)
    }

}
