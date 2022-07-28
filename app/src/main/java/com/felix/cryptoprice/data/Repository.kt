package com.felix.cryptoprice.data

import com.felix.cryptoprice.data.api.service.ApiHelper

class Repository(private val apiHelper: ApiHelper) {

    suspend fun  getTrending() = apiHelper.getTrending()
}