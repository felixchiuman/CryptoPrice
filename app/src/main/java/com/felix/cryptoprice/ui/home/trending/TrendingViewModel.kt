package com.felix.cryptoprice.ui.home.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.cryptoprice.data.Repository
import com.felix.cryptoprice.data.Resource
import com.felix.cryptoprice.data.api.model.trending.GetTrendingLatestResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class TrendingViewModel(private val repository: Repository): ViewModel() {

    private val _trendingResponse = MutableLiveData<Resource<Response<GetTrendingLatestResponse>>>()
    val trendingResponse : LiveData<Resource<Response<GetTrendingLatestResponse>>> get() = _trendingResponse

    fun getTrendingLatest() {
        viewModelScope.launch {
            _trendingResponse.postValue(Resource.loading())
            try {
                _trendingResponse.postValue(Resource.success(repository.getTrending()))
            }catch (e: Exception) {
                _trendingResponse.postValue(Resource.error(e.message))
            }
        }
    }
}