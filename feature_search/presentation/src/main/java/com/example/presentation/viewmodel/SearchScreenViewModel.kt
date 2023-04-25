package com.example.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.common.Constants.ITEM_PER_PAGE
import com.example.data.paging.TourInfoPagingSource
import com.example.domain.model.TourInfoItem
import com.example.domain.repository.TourInfoRepository
import com.example.presentation.state.TourInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val tourInfoRepository: TourInfoRepository
) : ViewModel() {

    private val _tourInfoState = mutableStateOf(TourInfoState())
    val tourInfoState: State<TourInfoState> = _tourInfoState

    fun getTourInfoPagination(): Flow<PagingData<TourInfoItem>> {
        return Pager(PagingConfig(pageSize = ITEM_PER_PAGE)) {
            TourInfoPagingSource(tourInfoRepository)
        }.flow.cachedIn(viewModelScope)
    }
}