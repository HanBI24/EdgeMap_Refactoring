package com.example.feature_main.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(val route: String, val title: String, val icon: ImageVector){
    object Home : BottomNavScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Search : BottomNavScreen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object Favorite : BottomNavScreen(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )
}