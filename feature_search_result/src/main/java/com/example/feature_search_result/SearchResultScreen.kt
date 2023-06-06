package com.example.feature_search_result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.common.location.rememberFusedLocationSource
import com.naver.maps.map.compose.ExperimentalNaverMapApi

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun SearchResultScreen(searchWord: String = "서울") {
    var currentLocation by remember { mutableStateOf("") }
    var isFinished by remember { mutableStateOf(false) }

    rememberFusedLocationSource().apply {
        activate {
            currentLocation = "${it?.latitude},${it?.longitude}"
            isFinished = true
        }
        if(isFinished) deactivate()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = currentLocation
        )
    }
}