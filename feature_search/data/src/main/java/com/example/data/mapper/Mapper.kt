package com.example.data.mapper.feature_search

import com.example.data.local.entity.SearchWordEntity
import com.example.data.remote.dto.Item
import com.example.domain.model.local.SearchWordItem
import com.example.domain.model.remote.TourInfoItem

object Mapper {

    fun SearchWordEntity.toSearchWordItem(): SearchWordItem {
        return SearchWordItem(searchWord = searchWord)
    }

    fun SearchWordItem.toSearchWordEntity(searchWord: String): SearchWordEntity {
        return SearchWordEntity(searchWord = searchWord)
    }

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