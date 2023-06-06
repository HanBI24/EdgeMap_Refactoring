package com.example.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.GeoCodeItem
import com.example.domain.repository.GetGeoCodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val getGeoCodeRepository: GetGeoCodeRepository
) : ViewModel() {

    private val _geoCodeState = mutableStateOf(GeoCodeItem("", ""))
    val geoCodeState: State<GeoCodeItem> = _geoCodeState

    fun getGeoCode(searchPlaceWord: String) {
        viewModelScope.launch {
            _geoCodeState.value = getGeoCodeRepository.getGeoCode(searchPlaceWord)
        }
    }
}