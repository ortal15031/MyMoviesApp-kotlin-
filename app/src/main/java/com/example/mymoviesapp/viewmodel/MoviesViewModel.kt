package com.example.mymoviesapp.viewmodel
import android.app.Application
import android.content.res.Resources
import android.content.res.loader.ResourcesLoader
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.mymoviesapp.api.Api
import com.example.mymoviesapp.constants.Constants
import com.example.mymoviesapp.models.Movies
import com.example.mymoviesapp.models.Results
import com.example.mymoviesapp.paging.MoviePaging
import com.example.mymoviesapp.resources.Resource
import com.example.mymoviesapp.resources.Resource.Companion.error
import com.example.mymoviesapp.resources.Resource.Companion.loading
import com.example.mymoviesapp.resources.Resource.Companion.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(var api: Api): ViewModel() {
val pager=Pager(PagingConfig(pageSize = 20,
enablePlaceholders = false,
)){
MoviePaging(api = api)
}.liveData.cachedIn(viewModelScope)
}