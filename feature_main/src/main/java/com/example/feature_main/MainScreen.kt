package com.example.feature_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.common.location.rememberFusedLocationSource
import com.naver.maps.map.compose.*

@ExperimentalNaverMapApi
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        val cameraPositionState = rememberCameraPositionState()
        NaverMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            locationSource = rememberFusedLocationSource(),
            properties = MapProperties(
                locationTrackingMode = LocationTrackingMode.Follow
            ),
            uiSettings = MapUiSettings(
                isLocationButtonEnabled = true,
            ),
        ) {

        }
    }
}