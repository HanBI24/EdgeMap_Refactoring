package com.example.domain.repository.local

import com.example.domain.model.local.SearchWordItem
import kotlinx.coroutines.flow.Flow

interface SearchWordRepository {
    fun getAllSearchWord(): Flow<List<SearchWordItem>>

    suspend fun insertSearchWord(searchWordItem: SearchWordItem)
}