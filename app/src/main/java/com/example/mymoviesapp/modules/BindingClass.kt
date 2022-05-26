package com.example.mymoviesapp.modules
import com.example.mymoviesapp.repository.GenreRepository
import com.example.mymoviesapp.repository.GenreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
abstract class BindingClass {
@Binds
abstract fun bindingData(genreRepositoryImpl: GenreRepositoryImpl):GenreRepository
}