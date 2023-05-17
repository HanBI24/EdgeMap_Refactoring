package com.example.domain.repository.remote

import com.example.domain.model.remote.TourInfoItem

interface TourInfoRepository {
    suspend fun getTourInfo(numOfRows: Int, pageNo: Int): List<TourInfoItem>

    suspend fun getTourInfoSize(numOfRows: Int, pageNo: Int): Int
}