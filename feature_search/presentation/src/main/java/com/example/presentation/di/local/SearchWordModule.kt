package com.example.presentation.di.local

import android.content.Context
import androidx.room.Room
import com.example.data.local.SearchWordDao
import com.example.data.local.SearchWordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchWordModule {

    @Provides
    @Singleton
    fun provideSearchWordDao(
        searchWordDatabase: SearchWordDatabase
    ): SearchWordDao {
        return searchWordDatabase.searchWordDao
    }

    @Provides
    @Singleton
    fun provideSearchWordDatabase(
        @ApplicationContext context: Context
    ): SearchWordDatabase {
        return Room.databaseBuilder(
            context,
            SearchWordDatabase::class.java,
            "searchwordentity"
        ).fallbackToDestructiveMigration()
            .build()
    }
}