package com.example.data.remote.api

import com.example.data.remote.dto.geocode.GeoCodeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodeApi {

    @GET("/map-geocode/v2/geocode")
    suspend fun getGeoCode(
        @Query("query") searchPlaceWord: String
    ): GeoCodeDto
}