package com.example.feature_main.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.common.Constants.PASS_SEARCH_WORD
import com.example.feature_favorite.FavoriteScreen
import com.example.feature_main.MainScreen
import com.example.feature_search.SearchScreen
import com.example.feature_search_result.SearchResultScreen
import com.example.navigation.BottomNavScreen

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
        composable(
            route = BottomNavScreen.SearchResult.route,
            arguments = listOf(navArgument(PASS_SEARCH_WORD) {
                type = NavType.StringType
            })
        ) {
            SearchResultScreen(it.arguments?.getString(PASS_SEARCH_WORD) ?: "")
        }
    }
}