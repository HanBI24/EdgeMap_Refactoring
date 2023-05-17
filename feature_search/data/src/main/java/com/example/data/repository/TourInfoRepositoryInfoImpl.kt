package com.example.data.repository

import com.example.data.mapper.Mapper.toTourInfoItem
import com.example.data.remote.api.TourInfoApi
import com.example.domain.model.remote.TourInfoItem
import com.example.domain.repository.remote.TourInfoRepository
import javax.inject.Inject

class TourInfoRepositoryInfoImpl @Inject constructor(
    private val tourInfoApi: TourInfoApi
) : TourInfoRepository {
    override suspend fun getTourInfo(numOfRows: Int, pageNo: Int): List<TourInfoItem> {
        return tourInfoApi.getTourInfo(
            numOfRows = numOfRows,
            pageNo = pageNo
        ).response.body.items.item.map {
            it.toTourInfoItem()
        }
    }

    override suspend fun getTourInfoSize(numOfRows: Int, pageNo: Int): Int {
        return tourInfoApi.getTourInfo(
            numOfRows = numOfRows,
            pageNo = pageNo
        ).response.body.totalCount
    }
}