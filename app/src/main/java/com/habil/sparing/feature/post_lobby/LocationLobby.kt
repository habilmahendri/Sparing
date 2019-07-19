package com.habil.sparing.feature.post_lobby

import android.R
import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_location_lobby.*
import java.text.SimpleDateFormat
import java.util.*
import android.app.TimePickerDialog
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.habil.sparing.feature.post_lobby.post_lobby.PostLobbyActivity


class LocationLobby : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var list_of_duration = arrayOf("1 Jam", "2 Jam", "3 Jam")
    var duration:String = ""
    var calendar = Calendar.getInstance()
    var year = calendar.get(Calendar.YEAR)
    var month = calendar.get(Calendar.MONTH)
    var dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    private var dateFormatter: SimpleDateFormat? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.habil.sparing.R.layout.activity_location_lobby)

        toolbar.title = "Lokasi & Waktu"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val id = Locale("in", "ID")
        dateFormatter = SimpleDateFormat("EEEE, dd MMM yyyy", id)
        val extras = intent.extras

        Log.e("bundle", extras.getString("JUDUL"))


        spinner!!.onItemSelectedListener = this

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, list_of_duration)

        // Set layout to use when the list of choices appear
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.adapter = arrayAdapter



        open_calendar.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this@LocationLobby,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                   // tv_date.text = "$day + $month + $year"
                    val newDate = Calendar.getInstance()
                    newDate.set(year, month, day)
                    tv_date.text = dateFormatter!!.format(newDate.time)
                }, year, month, dayOfMonth
            )
            datePickerDialog.show()
        }

        openTime.setOnClickListener {
            // TODO Auto-generated method stub
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mcurrentTime.get(Calendar.MINUTE)
            val mTimePicker: TimePickerDialog

            mTimePicker = TimePickerDialog(this@LocationLobby,
                TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    tv_time.text = "$selectedHour:$selectedMinute"
                }, hour, minute, true
            )//Yes 24 hour time

            mTimePicker.setTitle("Select Time")
            mTimePicker.show()
        }

        btn_lanjutkan.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString("JUDUL",extras.getString("JUDUL"))
            mBundle.putString("KATEGORI",extras.getString("KATEGORI"))
            mBundle.putString("CATATAN",extras.getString("CATATAN"))
            mBundle.putString("VANUE",id_vanue.text.toString())
            mBundle.putString("TANGGAL",tv_date.text.toString())
            mBundle.putString("WAKTU",tv_time.text.toString())
            mBundle.putString("DURASI",duration)

            val intent = Intent(this, PostLobbyActivity::class.java)
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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        duration = list_of_duration[p2]

    }
}
