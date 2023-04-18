package com.example.edgemaprefactoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.feature_main.navigation.SetupNavGraph
import com.example.edgemaprefactoring.ui.theme.EdgeMapRefactoringTheme
import com.example.feature_main.MainScreenSetNavigation
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalNaverMapApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdgeMapRefactoringTheme {
                navController = rememberNavController()
                MainScreenSetNavigation(navController)
            }
        }
    }
}