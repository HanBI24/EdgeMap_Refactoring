package com.example.data.remote.api

import com.example.data.BuildConfig
import com.example.data.remote.dto.geocode.GeoCodeDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GeoCodeApi {

    @Headers(
        "X-NCP-APIGW-API-KEY-ID: ${BuildConfig.Client_ID}",
        "X-NCP-APIGW-API-KEY: ${BuildConfig.Client_Secret}"
    )
    @GET("/map-geocode/v2/geocode")
    suspend fun getGeoCode(
        @Query("query") searchPlaceWord: String
    ): GeoCodeDto
}