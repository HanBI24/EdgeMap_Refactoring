package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.SearchWordEntity
import com.example.domain.model.local.SearchWordItem
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchWordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchWord(searchWord: SearchWordEntity)

    @Query("DELETE FROM searchwordentity WHERE searchWord = :searchWord")
    suspend fun deleteSearchWord(searchWord: String)

    @Query("SELECT DISTINCT searchWord FROM searchwordentity ORDER BY id DESC")
    fun getAllSearchWord(): Flow<List<SearchWordEntity>>
}