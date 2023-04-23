package com.example.feature_search

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
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
fun SearchTourList() {
    LazyStaggeredGrid()
}

@ExperimentalFoundationApi
@Composable
fun LazyStaggeredGrid() {
    val items: () -> List<GridItem> = {
        val k = arrayListOf<GridItem>()
        for(i in 0..100) {
            k.add(GridItem(i.toString(), Color.LightGray, randomSizeGridItem().dp))
        }
        k.toList()
    }

    val cellConfiguration = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        StaggeredGridCells.Adaptive(minSize = 175.dp)
    } else StaggeredGridCells.Fixed(2)

    LazyVerticalStaggeredGrid(
        columns = cellConfiguration,
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(items()) {
            LazyVerticalStaggeredGridItem(item = it)
        }
    }
}

fun randomSizeGridItem() = (150..300).random()

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