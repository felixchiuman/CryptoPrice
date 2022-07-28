package com.felix.cryptoprice.data.api.service

import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("cryptocurrency/listing/latest")
    suspend fun getTrending(): Response<GetTrendingLatestResponse>
}