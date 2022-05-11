package si.uni_lj.fri.pbd.miniapp3.rest

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import si.uni_lj.fri.pbd.miniapp3.Constants
import timber.log.Timber

object ServiceGenerator {

    private var sBuilder: Retrofit.Builder? = null
    private var sHttpClient: OkHttpClient.Builder? = null
    private var sRetrofit: Retrofit? = null

    init {
        sHttpClient = OkHttpClient.Builder()
        sBuilder = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        sRetrofit = sBuilder?.client(sHttpClient?.addInterceptor(interceptor)?.build()!!)?.build()
        Timber.d("Retrofit built with base url: %s", sRetrofit?.baseUrl()?.toUrl().toString())
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return sRetrofit!!.create(serviceClass)
    }
}
