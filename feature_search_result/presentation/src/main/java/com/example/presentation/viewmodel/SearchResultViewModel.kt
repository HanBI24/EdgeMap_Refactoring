package com.example.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _curGeoCode = mutableStateOf("")
    val curGeoCode: State<String> = _curGeoCode

    private val _goalGeoCode = mutableStateOf("")
    val goalGeoCode: State<String> = _goalGeoCode

    fun setCurGeoCode(curGeoCode: String) {
        _curGeoCode.value = curGeoCode
    }

    fun startFindingRouteAndLocation(
        searchPlaceWord: String,
        currentLocationLatLng: String
    ) {
        _curGeoCode.value = currentLocationLatLng
        getGoalGeoCode(searchPlaceWord)
    }

    private fun getGoalGeoCode(searchPlaceWord: String) {
        viewModelScope.launch {
            _goalGeoCode.value =
                returnStringGeoCode(getGeoCodeRepository.getGeoCode(searchPlaceWord))

            if(_goalGeoCode.value.isNotBlank())
                getRoute(_curGeoCode.value, _goalGeoCode.value)
        }
    }

    private fun getRoute(curGeoCode: String, goalGeoCode: String) {
        println("awef vm $curGeoCode, $goalGeoCode")
    }

    private fun returnStringGeoCode(geoCodeItem: GeoCodeItem): String {
        return "${geoCodeItem.lat},${geoCodeItem.lng}"
    }
}