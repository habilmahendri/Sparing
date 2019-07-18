package com.habil.sparing.feature.detail.detail_event

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.model.Event
import kotlinx.android.synthetic.main.activity_detail_event.*

class DetailEventActivity : AppCompatActivity(), DetailEventContract.View {

    private lateinit var presenter: DetailEventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail Event"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id_event = intent.getStringExtra("id")

        presenter = DetailEventPresenter(this)
        presenter.getDetailEvent(id_event)
    }

    override fun showDetailEvent(event: Event) {
        Glide.with(applicationContext)
                .load(event.image)
                .into(imgPosterEvent)

        tvNamaEvent.text = event.nama
        tvEventKategori.text = event.kategori
        tvEventTempat.text = event.tempat
        tvEventTanggal.text = event.tanggal
        tvEventDeskripsi.text = event.deskripsi
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) this.finish()

        return super.onOptionsItemSelected(item)
    }
}
