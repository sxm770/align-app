import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.alignhoroscope.api.HoroscopeApi


object RetrofitClient {
    private const val BASE_URL = "https://sameer-kumar-aztro-v1.p.rapidapi.com/"
    private val retrofit: Retrofit

    init {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-RapidAPI-Key", "fd7fe46ae1msh1ea3cf087dfadc9p1969ebjsn0558213f4849")
                .addHeader("X-RapidAPI-Host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
    }

    fun getHoroscopeApi(): HoroscopeApi {
        return retrofit.create(HoroscopeApi::class.java)
    }
}
