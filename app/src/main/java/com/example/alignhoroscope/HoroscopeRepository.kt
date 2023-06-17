package com.example.alignhoroscope

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class HoroscopeRepository {

    private val client = OkHttpClient()

    private val jsonMediaType = "application/json; charset=utf-8".toMediaType()

    fun fetchHoroscope(zodiacSign: String): String? {
        val requestBody = JSONObject()
            .put("prompt", "horoscope-prompt")
            .put("max_tokens", 60)
            .toString()
            .toRequestBody(jsonMediaType)

        val request = Request.Builder()
            .url("https://api.openai.com/v1/engines/davinci-codex/completions")
            .post(requestBody)
            .addHeader("Authorization", "Bearer my-secret-key")
            .addHeader("Content-Type", "application/json")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Error: ${response.message}")
            } else {
                return response.body?.string()
            }
        }
    }
}
