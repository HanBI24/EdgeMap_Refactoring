package com.example.feature_search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircleList()
    }
}

@Composable
fun CircleList() {
    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy((-92).dp)
    ) {
        items(30) { CircleItem() }
    }
}

@Composable
fun CircleItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.45f)
            .height(180.dp)
            .clip(CircleShape)
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello")
    }
}