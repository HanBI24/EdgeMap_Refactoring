package com.example.feature_search

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.domain.model.TourInfoItem
import com.example.presentation.state.TourInfoState

@ExperimentalFoundationApi
@Composable
fun SearchTourList(
    tourInfo: LazyPagingItems<TourInfoItem>
) {
    LazyStaggeredGrid(tourInfo)
}

@OptIn(ExperimentalCoilApi::class)
@ExperimentalFoundationApi
@Composable
fun LazyStaggeredGrid(
    tourInfo: LazyPagingItems<TourInfoItem>
) {
    val cellConfiguration =
        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            StaggeredGridCells.Adaptive(minSize = 175.dp)
        } else StaggeredGridCells.Fixed(2)


    Box(modifier = Modifier.fillMaxSize()) {
        tourInfo.apply {
            when (loadState.append) {
                is LoadState.Loading -> {
                    CircularProgressIndicator(Modifier.align(Alignment.TopCenter))
                }
                is LoadState.NotLoading -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
                is LoadState.Error -> {
                    CircularProgressIndicator(Modifier.align(Alignment.BottomCenter))
                }
                else -> {
                    LazyVerticalStaggeredGrid(
                        columns = cellConfiguration,
                        contentPadding = PaddingValues(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalItemSpacing = 16.dp
                    ) {
                        items(tourInfo.itemCount) { index ->
                            tourInfo[index]?.let {
                                LazyVerticalStaggeredGridItem(
                                    tourInfoItem = it
                                )
                            }
                        }
                    }
                }
            }
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
        error(R.drawable.ic_error)
    }

    Box(
        modifier = modifier.height(tourInfoItem.photoSize.dp)
    ) {
        ImagePainterState(painter = painter.state)
        Image(
            painter = painter,
            contentDescription = "Tour Info API",
            contentScale = ContentScale.Crop
        )
    }
}

@ExperimentalCoilApi
@Composable
fun ImagePainterState(painter: ImagePainter.State) {
    when (painter) {
        is ImagePainter.State.Loading -> {
            ShowProgressBar()
        }
        is ImagePainter.State.Empty -> {
            ShowProgressBar()
        }
        else -> {ShowProgressBar()}
    }
}

@Composable
fun ShowProgressBar() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            color = Color.Magenta,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}