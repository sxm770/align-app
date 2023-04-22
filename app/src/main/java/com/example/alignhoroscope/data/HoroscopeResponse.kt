package com.example.alignhoroscope.data

import com.google.gson.annotations.SerializedName

data class HoroscopeResponse(
    @SerializedName("sign")
    val sign: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("horoscope")
    val horoscope: String
)
