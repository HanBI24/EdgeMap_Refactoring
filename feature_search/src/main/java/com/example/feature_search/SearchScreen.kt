package com.example.feature_search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//
//    }

    val items = listOf(
        GridItem("1", Color.Magenta, 130.dp),
        GridItem("2", Color.Red, 30.dp),
        GridItem("3", Color.White, 330.dp),
        GridItem("4", Color.Yellow, 170.dp),
        GridItem("5", Color.LightGray, 200.dp),
        GridItem("6", Color.Blue, 50.dp),
        GridItem("7", Color.DarkGray, 230.dp),
        GridItem("8", Color.Gray, 500.dp),
        GridItem("9", Color.Green, 30.dp),
        GridItem("10", Color.Yellow, 300.dp),
        GridItem("11", Color.Magenta, 210.dp),
        GridItem("12", Color.Gray, 60.dp),
        GridItem("13", Color.Cyan, 200.dp),
        GridItem("14", Color.Red, 150.dp),
        GridItem("15", Color.Yellow, 40.dp)
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items) {
            Item(item = it)
        }
    }
}

@Composable
fun Item(
    modifier: Modifier = Modifier,
    item: GridItem
) {
    Box(
        modifier = modifier
            .background(item.color)
            .height(item.size)
    )
}

data class GridItem(
    val id: String,
    val color: Color,
    val size: Dp
)