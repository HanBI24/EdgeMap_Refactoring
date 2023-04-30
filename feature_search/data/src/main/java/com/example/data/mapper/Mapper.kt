package com.example.data.mapper

import com.example.data.remote.dto.Item
import com.example.domain.model.TourInfoItem

object Mapper {
    fun Item.toTourInfoItem(): TourInfoItem {
        return TourInfoItem(
            galTitle = galTitle,
            galWebImageUrl = galWebImageUrl,
            galPhotographyMonth = galPhotographyMonth,
            galPhotographyLocation = galPhotographyLocation,
            galPhotographer = galPhotographer,
            photoSize = randomSizeGridItem()
        )
    }

    private fun randomSizeGridItem() = (150..300).random()
}