package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.SearchWordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchWordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchWord(searchWord: SearchWordEntity)

    @Delete
    suspend fun deleteSearchWord(searchWord: SearchWordEntity)

    @Query("SELECT DISTINCT searchWord FROM searchwordentity ORDER BY id DESC")
    fun getAllSearchWord(): Flow<List<SearchWordEntity>>
}