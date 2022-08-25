package com.felix.cryptoprice.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felix.cryptoprice.data.Repository
import com.felix.cryptoprice.data.Resource
import com.felix.cryptoprice.data.api.model.detail.GetDetailResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel(private val repository: Repository): ViewModel() {

    private val _detail = MutableLiveData<Resource<Response<GetDetailResponse>>>()
    val detailResponse : LiveData<Resource<Response<GetDetailResponse>>> get() = _detail

    fun getInfo(type: String = ""){
        viewModelScope.launch {
            _detail.postValue(Resource.loading())
            try {
                val detail = Resource.success(repository.getInfo(type))
                _detail.postValue(detail)
            }catch (e: Exception){
                _detail.postValue(Resource.error(e.message ?: "Error"))
            }
        }
    }
}