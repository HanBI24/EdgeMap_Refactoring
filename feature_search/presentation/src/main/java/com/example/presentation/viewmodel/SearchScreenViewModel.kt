package com.example.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.common.Constants.ITEM_PER_PAGE
import com.example.data.paging.TourInfoPagingSource
import com.example.domain.model.local.SearchWordItem
import com.example.domain.repository.local.SearchWordRepository
import com.example.domain.repository.remote.TourInfoRepository
import com.example.presentation.state.TourInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val tourInfoRepository: TourInfoRepository,
    private val searchWordRepository: SearchWordRepository
) : ViewModel() {

    private val _tourInfoState = mutableStateOf(TourInfoState())
    val tourInfoState: State<TourInfoState> = _tourInfoState

    private val _searchWord = mutableStateOf("")
    val searchWord: State<String> = _searchWord

    fun onSearchWordChanged(searchWord: String) {
        _searchWord.value = searchWord
    }

    fun makeSearchWordEmpty() {
        _searchWord.value = ""
    }

    fun getAllSearchWord() = searchWordRepository.getAllSearchWord()

    suspend fun insertSearchWord(searchWord: String) {
        viewModelScope.launch {
            searchWordRepository.insertSearchWord(
                SearchWordItem(searchWord)
            )
        }
    }

    suspend fun deleteSearchWord(searchWord: String) {
        viewModelScope.launch {
            searchWordRepository.deleteSearchWord(
                SearchWordItem(searchWord)
            )
        }
    }

    init {
        _tourInfoState.value = tourInfoState.value.copy(
            toruInfoItem = Pager(PagingConfig(pageSize = ITEM_PER_PAGE)) {
                TourInfoPagingSource(tourInfoRepository)
            }.flow.cachedIn(viewModelScope)
        )
    }
}