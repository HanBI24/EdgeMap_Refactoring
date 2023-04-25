package com.example.feature_search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.viewmodel.SearchScreenViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()
    val tourInfo = searchScreenViewModel.getTourInfoPagination().collectAsLazyPagingItems()

    SearchTourList(tourInfo)
}