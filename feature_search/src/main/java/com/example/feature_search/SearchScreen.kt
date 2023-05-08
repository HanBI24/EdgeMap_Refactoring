package com.example.feature_search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.viewmodel.SearchScreenViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()
    val tourInfoItem = searchScreenViewModel.tourInfoState.value.toruInfoItem.collectAsLazyPagingItems()
    var searchWord by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(12.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = searchWord,
                    onValueChange = { searchWord = it }
                )
            }
        }
        SearchTourList(tourInfoItem)
    }
}