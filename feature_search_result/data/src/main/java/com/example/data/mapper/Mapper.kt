package com.example.data.mapper

import com.example.data.remote.dto.geocode.Addresse
import com.example.domain.model.GeoCodeItem

object Mapper {
    fun Addresse.toGeoCodeItem(): GeoCodeItem {
        return GeoCodeItem(
            lng = x,
            lat = y
        )
    }
}