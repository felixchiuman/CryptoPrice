package com.felix.cryptoprice.data.api.service

class ApiHelper (val apiService: ApiService){

    suspend fun getTrending() = apiService.getTrending()
}