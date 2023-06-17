package com.example.alignhoroscope

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(
    private val horoscopeRepository: HoroscopeRepository
) : ViewModel() {

    val horoscope = mutableStateOf("")

    fun fetchHoroscope(zodiacSign: String) {
        viewModelScope.launch {
            horoscope.value = horoscopeRepository.fetchHoroscope(zodiacSign).toString()
        }
    }
}

