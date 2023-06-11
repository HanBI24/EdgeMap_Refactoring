package com.example.data.repository.remote

import com.example.common.di.TourInfoType
import com.example.data.mapper.feature_search.Mapper.toTourInfoItem
import com.example.data.remote.api.TourInfoApi
import com.example.domain.model.remote.TourInfoItem
import com.example.domain.repository.remote.TourInfoRepository
import javax.inject.Inject

class TourInfoRepositoryInfoImpl @Inject constructor(
    @TourInfoType private val tourInfoApi: TourInfoApi
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