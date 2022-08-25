package com.felix.cryptoprice.data.api.service

import com.felix.cryptoprice.data.api.model.detail.GetDetailResponse
import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("cryptocurrency/listings/latest")
    suspend fun getTrending(): Response<GetTrendingLatestResponse>

    @GET("cryptocurrency/info")
    suspend fun getInfo(@Query("symbol")type: String = ""): Response<GetDetailResponse>
}