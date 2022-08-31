package com.felix.cryptoprice.data.repository

import com.felix.cryptoprice.data.Repository
import com.felix.cryptoprice.data.api.model.detail.GetDetailResponse
import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import com.felix.cryptoprice.data.api.service.ApiHelper
import com.felix.cryptoprice.data.api.service.ApiService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Test
import retrofit2.Response

class RepositoryTest {

    //collaborator
    private lateinit var apiService: ApiService
    private lateinit var apiHelper: ApiHelper

    //system underTest
    private lateinit var repository: Repository

    @Before
    fun setUp(){
        apiService = mockk()
        apiHelper = mockk()

        repository = Repository(apiHelper)
    }

    @Test
    fun getTrending(): Unit = runBlocking {
        val trendingResponse = mockk<Response<GetTrendingLatestResponse>>()

        every{
            runBlocking {
                apiHelper.getTrending()
            }
        } returns trendingResponse

        repository.getTrending()

        verify {
           runBlocking {
               apiHelper.getTrending()
                }
           }
        }

    @Test
    fun getInfo(): Unit = runBlocking {
        val getInfoResponse = mockk<Response<GetDetailResponse>>()

        val symbol = "btc"

        every{
            runBlocking {
                apiHelper.getInfo(symbol)
            }
        } returns getInfoResponse

        repository.getInfo(symbol)

        verify {
            runBlocking {
                apiHelper.getInfo(symbol)
            }
        }
    }
}