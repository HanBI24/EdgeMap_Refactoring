package com.example.feature_search

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.domain.model.TourInfoItem

@ExperimentalFoundationApi
@Composable
fun SearchTourList(tourInfo: LazyPagingItems<TourInfoItem>) {
    LazyStaggeredGrid(tourInfo)
}

@OptIn(ExperimentalCoilApi::class)
@ExperimentalFoundationApi
@Composable
fun LazyStaggeredGrid(tourInfo: LazyPagingItems<TourInfoItem>) {
    val cellConfiguration = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        StaggeredGridCells.Adaptive(minSize = 175.dp)
    } else StaggeredGridCells.Fixed(2)

    LazyVerticalStaggeredGrid(
        columns = cellConfiguration,
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(tourInfo.itemCount) { index ->
            tourInfo[index]?.let { LazyVerticalStaggeredGridItem(tourInfoItem = it) }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun LazyVerticalStaggeredGridItem(
    modifier: Modifier = Modifier,
    tourInfoItem: TourInfoItem
) {
    val painter = rememberImagePainter(data = tourInfoItem.galWebImageUrl) {
        crossfade(1000)
    }
    val itemSize by rememberSaveable { mutableStateOf(randomSizeGridItem()) }

    Box(
        modifier = modifier.height(itemSize.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = "Tour Info API",
            contentScale = ContentScale.Crop
        )
    }
}

fun randomSizeGridItem() = (150..300).random()
