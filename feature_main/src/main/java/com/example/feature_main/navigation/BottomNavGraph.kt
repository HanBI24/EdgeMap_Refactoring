package com.example.feature_main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_main.MainScreen
import com.example.feature_search.SearchScreen
import com.naver.maps.map.compose.ExperimentalNaverMapApi

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(route = BottomNavItem.Home.route) {
            MainScreen()
        }
        composable(route = BottomNavItem.Search.route) {
            SearchScreen()
        }
//        composable(route = BottomNavItem.Home.route) {
//            MainScreen()
//        }
    }
}