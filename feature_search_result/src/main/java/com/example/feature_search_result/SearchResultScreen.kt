package com.example.feature_search_result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common.location.rememberFusedLocationSource
import com.example.presentation.viewmodel.SearchResultViewModel
import com.naver.maps.map.compose.ExperimentalNaverMapApi

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun SearchResultScreen(searchPlaceWord: String = "속초") {
    var currentLocation by remember { mutableStateOf("") }
    var isFinished by remember { mutableStateOf(false) }
    val searchResultViewModel = hiltViewModel<SearchResultViewModel>()
    val geoCodeState = searchResultViewModel.geoCodeState.value


    rememberFusedLocationSource().apply {
        activate {
            currentLocation = "${it?.latitude},${it?.longitude}"
            isFinished = true
        }
        if(isFinished) deactivate()
    }

    searchResultViewModel.getGeoCode("속초")

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "${geoCodeState.lng}, ${geoCodeState.lat}"
        )
    }
}