import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HoroscopeApi {
    private fun getBaseUrl(zodiacSign: String, date: String) = "https://api.example.com/$zodiacSign/$date/"
    fun getHoroscope(zodiacSign: String, date: String): HoroscopeApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(getBaseUrl(zodiacSign, date))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(HoroscopeApi::class.java)
    }
}