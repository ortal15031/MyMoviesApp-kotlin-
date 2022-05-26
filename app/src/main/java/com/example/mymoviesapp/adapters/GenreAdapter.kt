package com.example.mymoviesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviesapp.R
import com.example.mymoviesapp.models.Genre
import com.example.mymoviesapp.models.Movies

class GenreAdapter(var list:MutableList<Genre>):RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {
inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
var genreType = itemView.findViewById<TextView>(R.id.genreType)
fun bind(genre: Genre) {
genreType.text = genre.name.toString()
}
}
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
return GenreViewHolder(view)
}
override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
holder.bind(genre = list[position])
}
override fun getItemCount(): Int {
return list.size
}
}
