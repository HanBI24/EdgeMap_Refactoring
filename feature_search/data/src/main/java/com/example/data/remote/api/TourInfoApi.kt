package com.example.data.remote.api

import com.example.data.feature_search.BuildConfig
import com.example.data.remote.dto.TourInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TourInfoApi {
    @GET("/B551011/PhotoGalleryService1/galleryList1")
    suspend fun getTourInfo(
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("MobileOS") mobileOS: String = "AND",
        @Query("MobileApp") mobileApp: String = "EdgeMap",
        @Query("_type") type: String = "json",
        @Query("serviceKey") serviceKey: String = BuildConfig.Service_Key
    ): TourInfoDto
}