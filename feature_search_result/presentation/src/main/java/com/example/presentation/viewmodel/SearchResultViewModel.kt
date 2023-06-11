package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.GeoCodeItem
import com.example.domain.repository.GetGeoCodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val getGeoCodeRepository: GetGeoCodeRepository
) : ViewModel() {

    private lateinit var curGeoCode: String
    private lateinit var goalGeoCode: String

    fun startFindingRouteAndLocation(
        searchPlaceWord: String,
        currentLocationLatLng: String
    ) {
        curGeoCode = currentLocationLatLng
        getGoalGeoCode(searchPlaceWord)
    }

    private fun getGoalGeoCode(searchPlaceWord: String) {
        viewModelScope.launch {
            goalGeoCode =
                returnStringGeoCode(getGeoCodeRepository.getGeoCode(searchPlaceWord))

            if(goalGeoCode.isNotBlank()) getRoute(curGeoCode, goalGeoCode)
        }
    }

    private fun getRoute(curGeoCode: String, goalGeoCode: String) {

    }

    private fun returnStringGeoCode(geoCodeItem: GeoCodeItem): String {
        println("awef return")
        return "${geoCodeItem.lat},${geoCodeItem.lng}"
    }
}