package com.example.edgemaprefactoring.navigation

sealed class BottomNavScreen(val route: String){
    object Home: BottomNavScreen(route = "home")
    object Search : BottomNavScreen(route = "search")
    object Favorite : BottomNavScreen(route = "favorite")
}