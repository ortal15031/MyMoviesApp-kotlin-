package com.example.mymoviesapp.models

import com.google.gson.annotations.SerializedName

data class Results(
val page: Int,
val results: MutableList<Movies>,
@SerializedName("total_pages")
val totalPages: Int,
@SerializedName("total_results")
val totalResults: Int
)
