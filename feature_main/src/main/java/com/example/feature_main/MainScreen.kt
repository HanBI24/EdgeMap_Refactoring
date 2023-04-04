package com.example.feature_main

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Text("Hello feature_main")
    }
}