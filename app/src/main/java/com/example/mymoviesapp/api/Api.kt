package com.example.mymoviesapp.api

import com.example.mymoviesapp.models.Genres
import com.example.mymoviesapp.models.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
@GET("3/movie/popular")
suspend fun getMovies(@Query("api_key") api_key:String,
@Query("primary_release_date.gte") start_year:String,
@Query("primary_release_date.lte") end_year:String,
@Query("page") page_number:Int): Response<Results>

@GET("3/genre/movie/list")
suspend fun getGenres(@Query("api_key") api_key:String,
@Query("language") language:String): Response<Genres>
}