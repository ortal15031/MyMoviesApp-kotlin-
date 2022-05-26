package com.example.mymoviesapp.repository

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.mymoviesapp.api.Api
import com.example.mymoviesapp.constants.Constants
import com.example.mymoviesapp.models.Genres
import com.example.mymoviesapp.models.Movies
import com.example.mymoviesapp.models.Results
import com.example.mymoviesapp.paging.MoviePaging
import retrofit2.Response
import javax.inject.Inject
class GenreRepositoryImpl @Inject constructor(var api:Api):GenreRepository {
override suspend fun getGenres():Response<Genres> =
api.getGenres(api_key = Constants.API_KEY,
language = Constants.LANGUAGE)
}