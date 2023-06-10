package com.example.presentation.di.remote

import com.example.common.Constants.TOUR_BASE_URL
import com.example.common.di.RetrofitAnnotationClass
import com.example.data.remote.api.TourInfoApi
import com.example.data.repository.remote.TourInfoRepositoryInfoImpl
import com.example.domain.repository.remote.TourInfoRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TourInfoModule {

    private val gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    @RetrofitAnnotationClass.TourInfoType
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(TOUR_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    @RetrofitAnnotationClass.TourInfoType
    fun provideTourInfoApi(
        @RetrofitAnnotationClass.TourInfoType retrofit: Retrofit
    ): TourInfoApi {
        return retrofit.create(TourInfoApi::class.java)
    }
}