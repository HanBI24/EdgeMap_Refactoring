package com.example.feature_main.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.feature_main.R

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector){
    object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Search : BottomNavItem(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object Favorite : BottomNavItem(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )
}