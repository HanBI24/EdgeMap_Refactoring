package com.example.presentation.state

import com.example.domain.model.TourInfoItem

data class TourInfoState(
    val toruInfoItem: List<TourInfoItem> = emptyList()
)
