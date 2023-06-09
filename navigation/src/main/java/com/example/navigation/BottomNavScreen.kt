package com.example.navigation

import com.example.common.Constants.PASS_SEARCH_WORD
import com.example.common.Constants.PASS_WEB_VIEW_URL


sealed class BottomNavScreen(val route: String){
    object Home: BottomNavScreen(route = "home")
    object Search: BottomNavScreen(route = "search")
    object Favorite: BottomNavScreen(route = "favorite")
    object SearchResult: BottomNavScreen(route = "search_result/{$PASS_SEARCH_WORD}") {
        fun passSearchWord(word: String): String {
            return "search_result/$word"
        }
    }
    object WebView: BottomNavScreen(route = "web_view/{$PASS_WEB_VIEW_URL}") {
        fun passTourImageUrl(url: String): String {
            return "web_view/$url"
        }
    }
}