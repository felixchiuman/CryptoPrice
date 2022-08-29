package com.felix.cryptoprice.ui.home.trending

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.felix.cryptoprice.data.Repository
import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import com.felix.cryptoprice.ui.rule.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class TrendingViewModelTest {

    private lateinit var viewModel: TrendingViewModel
    private lateinit var repository: Repository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        repository = mock()
        viewModel = TrendingViewModel(repository)
    }

    @Test
    fun getTrendingLatest()= runTest {
        val trendingResponse = mock<Response<GetTrendingLatestResponse>>()

        given(repository.getTrending()).willReturn(trendingResponse)

        viewModel.getTrendingLatest()

        advanceUntilIdle()

        Mockito.verify(repository, times(1)).getTrending()
        assertNotNull(viewModel.trendingResponse.value?.status)
        assertEquals(viewModel.trendingResponse.value?.data, trendingResponse)
    }
}