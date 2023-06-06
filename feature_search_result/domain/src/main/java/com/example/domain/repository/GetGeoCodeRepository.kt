package com.example.domain.repository

import com.example.domain.model.GeoCodeItem

interface GetGeoCodeRepository {

    suspend fun getGeoCode(searchPlaceWord: String): GeoCodeItem
}