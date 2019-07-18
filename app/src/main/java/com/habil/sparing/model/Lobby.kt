package com.habil.sparing.model

data class Lobby(
    val id_lobby: String = "",
    val judul: String = "",
    val catatan: String = "",
    val team_name: String? = "",
    val venue: String = "",
    val tanggal: String = "",
    val waktu: String = "",
    val kategori: String = "",
    val durasi: String = "",
    val username: String? = "",
    val team_lawan: String = "",
    val full_name: String? = ""

)