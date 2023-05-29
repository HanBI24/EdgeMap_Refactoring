package com.example.data.repository.local

import com.example.data.local.SearchWordDao
import com.example.data.mapper.Mapper.toSearchWordEntity
import com.example.data.mapper.Mapper.toSearchWordItem
import com.example.domain.model.local.SearchWordItem
import com.example.domain.repository.local.SearchWordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchWordRepositoryImpl @Inject constructor(
    private val searchWordDao: SearchWordDao
) : SearchWordRepository {

    override fun getAllSearchWord(): Flow<List<SearchWordItem>> {
        return searchWordDao.getAllSearchWord().map { list ->
            list.map { it.toSearchWordItem() }
        }
    }

    override suspend fun insertSearchWord(searchWordItem: SearchWordItem) {
        searchWordDao.insertSearchWord(
            searchWord = searchWordItem.toSearchWordEntity(
                searchWordItem.searchWord
            )
        )
    }

    override suspend fun deleteSearchWord(searchWordItem: SearchWordItem) {
        searchWordDao.deleteSearchWord(
            searchWord = searchWordItem.toSearchWordEntity(
                searchWordItem.searchWord
            ).searchWord
        )
    }
}