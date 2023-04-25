package com.example.domain.repository

import com.example.domain.model.TourInfoItem

interface TourInfoRepository {
    suspend fun getTourInfo(numOfRows: Int, pageNo: Int): List<TourInfoItem>
}