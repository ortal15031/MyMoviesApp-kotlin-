package com.example.mymoviesapp.models

import com.google.gson.annotations.SerializedName

data class Movies(
var genreIds: MutableList<Int>,
val id: Int,
@SerializedName("original_title")
val originalTitle: String?,
val popularity: Double?,
@SerializedName("poster_path")
val posterPath: String?,
@SerializedName("release_date")
val releaseDate: String?,
val title: String
)
