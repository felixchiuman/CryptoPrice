package com.felix.cryptoprice.di

import com.felix.cryptoprice.data.api.service.ApiHelper
import com.felix.cryptoprice.data.api.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://pro-api.coinmarketcap.com/v1/"
val networkModule = module {
    single{
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single{
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url.newBuilder()
                    .addQueryParameter("CMC_PRO_API_KEY","006671ca-2773-4e10-82c8-b941311f8da1")
                    .build()

                val request = original.newBuilder()
                    .url(url)
                    .build()
                chain.proceed(request)
            }
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single {
        get<Retrofit>().create(ApiService::class.java)
    }
    singleOf(::ApiHelper)
}