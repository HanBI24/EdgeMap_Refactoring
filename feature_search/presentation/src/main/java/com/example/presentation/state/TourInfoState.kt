package com.example.presentation.state

import androidx.paging.PagingData
import com.example.domain.model.TourInfoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class TourInfoState(
    val toruInfoItem: Flow<PagingData<TourInfoItem>> = emptyFlow()
)