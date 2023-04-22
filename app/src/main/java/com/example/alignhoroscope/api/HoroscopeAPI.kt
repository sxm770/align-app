package com.example.alignhoroscope.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface HoroscopeApi {
    @GET("horoscope")
    fun getHoroscope(
        @Header("X-RapidAPI-Key") apiKey: String?,
        @Header("X-RapidAPI-Host") apiHost: String?,
        @Query("sign") sign: String?,
        @Query("day") day: String?
    ): Call<String?>?
}

