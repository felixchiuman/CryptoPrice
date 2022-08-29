package com.felix.cryptoprice.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.felix.cryptoprice.data.Repository
import com.felix.cryptoprice.data.api.model.detail.GetDetailResponse
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
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private lateinit var repository: Repository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        repository = mock()
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun getInfo()= runTest {
        val detailResponse = mock<Response<GetDetailResponse>>()

        given(repository.getInfo()).willReturn(detailResponse)

        viewModel.getInfo()

        advanceUntilIdle()

        Mockito.verify(repository, times(1)).getInfo()
        assertNotNull(viewModel.detailResponse.value?.status)
        assertEquals(viewModel.detailResponse.value?.data, detailResponse)
    }
}