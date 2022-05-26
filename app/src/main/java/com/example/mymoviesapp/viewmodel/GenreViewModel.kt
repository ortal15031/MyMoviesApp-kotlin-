package com.example.mymoviesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mymoviesapp.repository.GenreRepository
import com.example.mymoviesapp.resources.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(var genreRepository: GenreRepository):ViewModel() {
fun getGenre()= liveData(Dispatchers.IO) {
emit(Resource.loading(data = null))
try {
emit(Resource.success(data=genreRepository.getGenres()))
}catch (e:Exception){
emit(e.message?.let { Resource.error(message = it, data = null) })
}
}
}