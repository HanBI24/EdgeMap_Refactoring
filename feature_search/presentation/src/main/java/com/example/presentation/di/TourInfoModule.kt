package com.example.presentation.di

import com.example.common.Constants.TOUR_BASE_URL
import com.example.data.remote.api.TourInfoApi
import com.example.data.repository.TourInfoRepositoryInfoImpl
import com.example.domain.repository.TourInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TourInfoModule {

    @Provides
    @Singleton
    fun provideTourInfoRepository(
        tourInfoApi: TourInfoApi
    ): TourInfoRepository {
        return TourInfoRepositoryInfoImpl(tourInfoApi)
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(TOUR_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTourInfoApi(
        retrofit: Retrofit
    ): TourInfoApi {
        return retrofit.create(TourInfoApi::class.java)
    }
}