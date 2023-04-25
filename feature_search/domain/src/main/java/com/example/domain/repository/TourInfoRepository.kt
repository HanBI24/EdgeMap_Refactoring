package com.example.domain.repository

interface TourInfoRepository {
    suspend fun getTourInfo(
        numOfRows: Int,
        pageNo: Int
    )
}