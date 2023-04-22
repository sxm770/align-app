package com.example.alignhoroscope.viewmodels

import HoroscopeRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alignhoroscope.data.HoroscopeResponse
import com.example.alignhoroscope.util.Resource
import kotlinx.coroutines.launch

class HoroscopeViewModel(private val repository: HoroscopeRepository) : ViewModel() {

    private val _horoscope = MutableLiveData<Resource<HoroscopeResponse>>()
    val horoscope: LiveData<Resource<HoroscopeResponse>> = _horoscope

//    fun fetchHoroscope(apiKey: String, apiHost: String, sign: String, day: String) {
//        viewModelScope.launch {
//            _horoscope.value = Resource.Loading()
//            try {
//                val response = repository.getHoroscope(apiKey, apiHost, sign, day)
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        _horoscope.value = Resource.Success(it)
//                    }
//                } else {
//                    _horoscope.value = Resource.Error("Error fetching horoscope")
//                }
//            } catch (e: Exception) {
//                _horoscope.value = Resource.Error("Error fetching horoscope: ${e.localizedMessage}")
//            }
//        }
//    }
}

