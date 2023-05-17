package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.entity.SearchWordEntity

@Database(
    entities = [SearchWordEntity::class],
    version = 1
)
abstract class SearchWordDatabase : RoomDatabase() {
    abstract val searchWordDao: SearchWordDao
}