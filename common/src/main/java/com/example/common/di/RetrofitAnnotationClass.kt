package com.example.common.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object RetrofitAnnotationClass {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class TourInfoType

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GeoCodeType
}
