package com.example.mymoviesapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.mymoviesapp.models.Genres
import com.example.mymoviesapp.models.Movies
import com.example.mymoviesapp.models.Results
import retrofit2.Response

interface GenreRepository {
suspend fun getGenres():Response<Genres>
}