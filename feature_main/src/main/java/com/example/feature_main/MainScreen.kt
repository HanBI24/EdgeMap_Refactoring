package com.example.feature_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap

@ExperimentalNaverMapApi
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        NaverMap(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}