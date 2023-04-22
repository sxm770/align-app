package com.example.alignhoroscope.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//Repository: A repository is a class that acts as an interface
//between different data sources (e.g., remote API, local database,
//etc.) and the rest of your app. It abstracts the data fetching
//logic and provides clean, well-defined methods for accessing the
//data. Using a repository promotes better code organization,
//separation of concerns, and ease of testing.
class HoroscopeRepository {
    private val horoscopeApi = RetrofitClient.getHoroscopeApi()
//    fun getHoroscope(sign: String, day: String): LiveData<Result<String>> {
//        val liveData = MutableLiveData<Result<String>>()
//        val call = horoscopeApi.getHoroscope(sign, day)
//        call.enqueue(object : Callback<String> {
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                if (response.isSuccessful) {
//                    liveData.postValue(Result.Success(response.body()))
//                } else {
//                    liveData.postValue(Result.Error(Exception("API call failed")))
//                }
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                liveData.postValue(Result.Error(Exception(t)))
//            }
//        })
//        return liveData
//    }
}
