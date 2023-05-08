package com.example.feature_search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.viewmodel.SearchScreenViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen() {
    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()
    val tourInfoItem =
        searchScreenViewModel.tourInfoState.value.toruInfoItem.collectAsLazyPagingItems()
    val searchWord = searchScreenViewModel.searchWord.value

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
                    onValueChange = searchScreenViewModel::onSearchWordChanged,
                    placeholder = { Text("목적지를 입력하세요.") },
                    label = { Text("목적지 검색") },
                    maxLines = 1,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {}
                    ),
                    singleLine = true
                )
            }
        }
        SearchTourList(tourInfoItem)
    }
}