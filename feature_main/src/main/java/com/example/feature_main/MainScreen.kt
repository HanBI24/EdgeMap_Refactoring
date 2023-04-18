package com.example.feature_main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.common.location.rememberFusedLocationSource
import com.example.feature_main.navigation.BottomNavScreen
import com.naver.maps.map.compose.*

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Box(
        modifier = modifier
    ) {
        NaverMapView(modifier = Modifier.fillMaxSize())

        BottomButtonView(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(20.dp)
                .clip(shape = RoundedCornerShape(12.dp)),
            navController = navController
        )

    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun NaverMapView(modifier: Modifier = Modifier) {
    val cameraPositionState = rememberCameraPositionState()

    NaverMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        locationSource = rememberFusedLocationSource(),
        properties = MapProperties(
            locationTrackingMode = LocationTrackingMode.Follow
        ),
        uiSettings = MapUiSettings(
            isLocationButtonEnabled = true,
        ),
    )
}

@Composable
fun BottomButtonView(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val bottomButtonTitleList = mapOf(
        "목적지 검색" to Icons.Default.Search,
        "즐겨찾기" to Icons.Default.Favorite
    )

    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.background(color = Color.White)
        ) {
            bottomButtonTitleList.forEach { entry ->
                BottomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    entry,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun BottomButton(
    modifier: Modifier = Modifier,
    bottomButtonEntry: Map.Entry<String, ImageVector>,
    navController: NavHostController
) {
    OutlinedButton(
        onClick = {
            when (bottomButtonEntry.key) {
                "목적지 검색" -> { navController.navigate(route = BottomNavScreen.Search.route) }
                "즐겨찾기" -> { navController.navigate(route = BottomNavScreen.Favorite.route) }
            }
        },
        modifier = modifier,
        border = BorderStroke(0.dp, Color.Transparent),
        colors = ButtonDefaults
            .outlinedButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.Magenta
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = bottomButtonEntry.value,
                contentDescription = "Bottom Button Icon"
            )
            Text(text = bottomButtonEntry.key)
        }
    }
}