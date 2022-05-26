package com.example.mymoviesapp.modules

import com.example.mymoviesapp.api.Api
import com.example.mymoviesapp.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleClass {
@Provides
@Singleton
fun getRetrofitBuilder(): Retrofit = Retrofit.Builder()
.baseUrl(Constants.BASE_URL)
.addConverterFactory(GsonConverterFactory.create())
.build()
@Provides
@Singleton
fun getApi(): Api {
return getRetrofitBuilder().create(Api::class.java)
}
}