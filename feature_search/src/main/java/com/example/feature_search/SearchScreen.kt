package com.example.feature_search

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.viewmodel.SearchScreenViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()
    val tourInfo = searchScreenViewModel.getTourInfoPagination().collectAsLazyPagingItems()
    Log.d("args", tourInfo.toString())
    SearchTourList(tourInfo)
}