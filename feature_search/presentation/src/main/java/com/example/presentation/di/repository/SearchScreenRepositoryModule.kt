package com.example.presentation.di.repository

import com.example.common.di.RetrofitAnnotationClass
import com.example.data.local.SearchWordDao
import com.example.data.remote.api.TourInfoApi
import com.example.data.repository.local.SearchWordRepositoryImpl
import com.example.data.repository.remote.TourInfoRepositoryInfoImpl
import com.example.domain.repository.local.SearchWordRepository
import com.example.domain.repository.remote.TourInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchScreenRepositoryModule {

    @Provides
    @Singleton
    fun provideTourInfoRepository(
        @RetrofitAnnotationClass.TourInfoType tourInfoApi: TourInfoApi
    ): TourInfoRepository {
        return TourInfoRepositoryInfoImpl(tourInfoApi)
    }

    @Provides
    @Singleton
    fun provideSearchWordRepository(
        searchWordDao: SearchWordDao
    ): SearchWordRepository {
        return SearchWordRepositoryImpl(searchWordDao)
    }
}