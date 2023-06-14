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
import kotlinx.coroutines.*

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun SearchResultScreen(searchPlaceWord: String = "속초") {
    var currentLocationLatLng by remember { mutableStateOf("") }
    var isFinished by remember { mutableStateOf(false) }
    val searchResultViewModel = hiltViewModel<SearchResultViewModel>()

    rememberFusedLocationSource().apply {
        activate {
            currentLocationLatLng = "${it?.latitude},${it?.longitude}"
            isFinished = true
        }
        if(isFinished) deactivate()
    }

    if(currentLocationLatLng != "")
        searchResultViewModel.startFindingRouteAndLocation(
            "속초",
            currentLocationLatLng
        )


    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = ""
        )
    }
}