package com.example.data.repository

import com.example.common.di.RetrofitAnnotationClass
import com.example.data.mapper.Mapper.toGeoCodeItem
import com.example.data.remote.api.GeoCodeApi
import com.example.domain.model.GeoCodeItem
import com.example.domain.repository.GetGeoCodeRepository
import javax.inject.Inject

class GetGeoCodeRepositoryImpl @Inject constructor(
    @RetrofitAnnotationClass.GeoCodeType private val geoCodeApi: GeoCodeApi
) : GetGeoCodeRepository {

    override suspend fun getGeoCode(searchPlaceWord: String): GeoCodeItem {
        return geoCodeApi.getGeoCode(
            searchPlaceWord = searchPlaceWord
        ).addresses[0].toGeoCodeItem()
    }
}