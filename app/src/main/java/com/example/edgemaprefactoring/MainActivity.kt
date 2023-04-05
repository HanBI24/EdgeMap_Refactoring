package com.example.edgemaprefactoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.edgemaprefactoring.ui.theme.EdgeMapRefactoringTheme
import com.example.feature_main.MainScreen
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope

@ExperimentalNaverMapApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdgeMapRefactoringTheme {
                MainScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}