package com.example.alignhoroscope

import retrofit2.http.GET

interface ZodiacSignAPI {

    @GET("endpoint")
    suspend fun getZodiacData(): ZodiacSign


}