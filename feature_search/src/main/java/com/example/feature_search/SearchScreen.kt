package com.example.feature_search

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
    LazyStaggeredGrid()
}

@ExperimentalFoundationApi
@Composable
fun LazyStaggeredGrid() {
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
        GridItem("15", Color.Yellow, 40.dp),
        GridItem("16", Color.Blue, 100.dp)
    )

    val cellConfiguration = if (LocalConfiguration.current.orientation == ORIENTATION_LANDSCAPE) {
        StaggeredGridCells.Adaptive(minSize = 175.dp)
    } else StaggeredGridCells.Fixed(2)

    LazyVerticalStaggeredGrid(
        columns = cellConfiguration,
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(items) {
            LazyVerticalStaggeredGridItem(item = it)
        }
    }
}

@Composable
fun LazyVerticalStaggeredGridItem(
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