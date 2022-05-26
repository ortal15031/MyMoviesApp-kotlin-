package com.example.mymoviesapp.adapters

import android.content.Context
import android.view.Gravity.apply
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.example.mymoviesapp.BR
import com.example.mymoviesapp.R
import com.example.mymoviesapp.constants.Constants
import com.example.mymoviesapp.databinding.MovieItemBinding
import com.example.mymoviesapp.models.Genre
import com.example.mymoviesapp.models.Genres
import com.example.mymoviesapp.models.Movies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoviesAdapter(
var list:MutableList<Genre>
) : PagingDataAdapter<Movies,MoviesAdapter.MoviesViewHolder>(differCallback){
companion object {
private val differCallback = object : DiffUtil.ItemCallback<Movies>() {
//Returns true if there are duplicate items
override fun areItemsTheSame(oldItem: Movies, newItem: Movies) =
oldItem.id == newItem.id
//Returns true if content is same
override fun areContentsTheSame(oldItem: Movies, newItem: Movies) =
oldItem == newItem
}
}
inner class MoviesViewHolder(val viewDataBinding: MovieItemBinding) : RecyclerView.ViewHolder(viewDataBinding.root){
var genreAdapter=GenreAdapter(list = list)
fun bind(movie:Movies,position:Int){
viewDataBinding.apply{
movieTitle.text = movie.title.toString()
releaseDate.text=movie.releaseDate.toString()
Glide.with(itemView).load(Constants.IMG_PATH+movie.posterPath).into(movieImg)
recycler.apply {
adapter=genreAdapter
layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
}
}
}
}
override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
val currentItem=getItem(position)
currentItem?.let { holder.bind(movie= it, position = position) }

}
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
val binding=MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
return MoviesViewHolder(binding)
}
}