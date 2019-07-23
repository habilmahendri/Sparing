package com.habil.sparing.feature.detail.detail_venue

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.habil.sparing.R
import com.habil.sparing.adapter.EventExploreAdapter
import com.habil.sparing.adapter.FasilitasAdapter
import com.habil.sparing.model.Venue
import kotlinx.android.synthetic.main.activity_detail_venue.*
import kotlinx.android.synthetic.main.fragment_event.*

class DetailVenueActivity : AppCompatActivity(), DetailVenueContract.View {


    private lateinit var presenter: DetailVenuePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_venue)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail Venue"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id: String = intent.getStringExtra("id")

        presenter = DetailVenuePresenter(this)
        presenter.getDetailVenue(id)
        presenter.getFasilitas(id)
    }

    override fun showDetail(vanue: Venue) {
        Glide.with(applicationContext)
                .load(vanue.image)
                .into(imgVenue)

        tvNamaVenue.text = vanue.nama
        tvLokasiVenue.text = vanue.location
        tvKategori.text = vanue.kategori
        tvHargaVenue.text = vanue.harga

        tvDeskripsiVenue.text = vanue.deskripsi
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) this.finish()

        return super.onOptionsItemSelected(item)
    }

    override fun showFasilitas(venue: MutableList<Venue>) {
        val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvFasilitas?.layoutManager = layoutManager
        rvFasilitas?.adapter = FasilitasAdapter(venue, this)
    }
}
