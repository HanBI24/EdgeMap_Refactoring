package com.example.presentation.di.repository

import com.example.common.di.RetrofitAnnotationClass
import com.example.data.remote.api.GeoCodeApi
import com.example.data.repository.GetGeoCodeRepositoryImpl
import com.example.domain.repository.GetGeoCodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    @RetrofitAnnotationClass.GeoCodeType
    fun provideGeoCodeRepository(
        @RetrofitAnnotationClass.GeoCodeType geoCodeApi: GeoCodeApi
    ): GetGeoCodeRepository {
        return GetGeoCodeRepositoryImpl(geoCodeApi)
    }
}