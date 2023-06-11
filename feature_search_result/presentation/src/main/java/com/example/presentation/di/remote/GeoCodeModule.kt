package com.example.presentation.di.remote

import com.example.common.Constants.GEO_CODE_BASE_URL
import com.example.common.di.GeoCodeType
import com.example.data.remote.api.GeoCodeApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GeoCodeModule {

    private val gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    @GeoCodeType
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GEO_CODE_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    @GeoCodeType
    fun provideGeoCodeApi(
        @GeoCodeType retrofit: Retrofit
    ): GeoCodeApi {
        return retrofit.create(GeoCodeApi::class.java)
    }
}