package com.example.feature_search

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.common.Constants.TOUR_INFO_WEB_VIEW_BASE_URL
import com.example.domain.model.TourInfoItem

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
        TourInfoCircleIndicator(tourInfo)
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
//        placeholder(R.drawable.ic_error)
        error(R.drawable.ic_error)
    }
    val tourInfoItemContext = LocalContext.current

    Box(
        modifier = modifier
            .height(tourInfoItem.photoSize.dp)
            .clickable {
                val tourInfoItemBrowserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(TOUR_INFO_WEB_VIEW_BASE_URL + tourInfoItem.galTitle)
                )
                ContextCompat.startActivity(
                    tourInfoItemContext,
                    tourInfoItemBrowserIntent,
                    null
                )
            }
    ) {
        Image(
            painter = painter,
            contentDescription = "Tour Info API",
            contentScale = ContentScale.Crop,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun TourInfoCircleIndicator(
    tourInfo: LazyPagingItems<TourInfoItem>
) {
    BoxScopeWithLayout {
        tourInfo.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    // 처음 로드될 때
                    // 또는 데이터 새로고침할 때
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
                loadState.append is LoadState.Loading -> {
                    // 데이터 추가될 때
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
//                is LoadState.NotLoading -> {
//                    로드가 완료되고 아무런 동작을 하지 않을 때
//                    CircularProgressIndicator(Modifier.align(Alignment.Center))
//                }
//                is LoadState.Error -> {
//                    로드 중 에러 발생
//                    CircularProgressIndicator(Modifier.align(Alignment.BottomCenter))
//                }
            }
        }
    }
}

@Composable
fun BoxScopeWithLayout(
    tourInfoIndicator: @Composable BoxScope.() -> Unit
) = Box(modifier = Modifier.fillMaxSize()) { tourInfoIndicator() }

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
        else -> {}
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