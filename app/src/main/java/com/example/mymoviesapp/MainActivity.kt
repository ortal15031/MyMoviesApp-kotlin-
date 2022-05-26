package com.example.mymoviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.flatMap
import androidx.paging.liveData
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymoviesapp.adapters.MoviesAdapter
import com.example.mymoviesapp.databinding.ActivityMainBinding
import com.example.mymoviesapp.models.Genre
import com.example.mymoviesapp.models.Genres
import com.example.mymoviesapp.models.Movies
import com.example.mymoviesapp.paging.MoviePaging
import com.example.mymoviesapp.resources.Status
import com.example.mymoviesapp.viewmodel.GenreViewModel
import com.example.mymoviesapp.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.sign

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
private lateinit var moviesViewModel :MoviesViewModel
private lateinit var genreViewModel:GenreViewModel
private lateinit var moviesAdapter: MoviesAdapter
private lateinit var genreList:MutableList<Genre>
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
binding=ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)
getGenres()
}
private fun getGenres(){
genreList= mutableListOf()
genreViewModel=ViewModelProvider(this, defaultViewModelProviderFactory)[GenreViewModel::class.java]
genreViewModel.getGenre().observe(this@MainActivity,Observer{item->
item?.let { res ->
 when (res.status) {
Status.SUCCESS -> {
var tmpList= res?.data?.body()?.genres
genreList= tmpList!!.toMutableList()
getMovies()
}
Status.ERROR -> {
Toast.makeText(applicationContext, "Unable to load data right now",
Toast.LENGTH_LONG).show()
res.message?.let { Log.e("Error", it) }
}
}
}
})
}
private  fun getMovies() {
moviesAdapter = MoviesAdapter(genreList)
moviesViewModel = ViewModelProvider(this, defaultViewModelProviderFactory)[MoviesViewModel::class.java]
moviesViewModel.pager.observe(this@MainActivity, Observer { movies->
 moviesAdapter.submitData(lifecycle,movies)
initRecyclerView()
})
}
private fun initRecyclerView(){
binding.recyclerView.apply{
layoutManager= LinearLayoutManager(this@MainActivity)
adapter=moviesAdapter
}
}
}
