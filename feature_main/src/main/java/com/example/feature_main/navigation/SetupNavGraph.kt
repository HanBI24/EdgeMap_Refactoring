package com.example.feature_main.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_favorite.FavoriteScreen
import com.example.feature_main.MainScreen
import com.example.feature_search.SearchScreen

@ExperimentalFoundationApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreen.Home.route
    ) {
        composable(route = BottomNavScreen.Home.route) {
            MainScreen(navController = navController)
        }
        composable(route = BottomNavScreen.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(route = BottomNavScreen.Favorite.route) {
            FavoriteScreen()
        }
    }
}