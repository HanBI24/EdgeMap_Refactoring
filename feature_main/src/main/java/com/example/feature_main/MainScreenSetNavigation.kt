package com.example.feature_main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.feature_main.navigation.SetupNavGraph

@ExperimentalFoundationApi
@Composable
fun MainScreenSetNavigation(navController: NavHostController) {
    SetupNavGraph(navController = navController)
}