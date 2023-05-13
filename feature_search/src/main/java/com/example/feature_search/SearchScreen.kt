package com.example.feature_search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.navigation.BottomNavScreen
import com.example.presentation.viewmodel.SearchScreenViewModel

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    navController: NavHostController
) {
    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()
    val tourInfoItem =
        searchScreenViewModel.tourInfoState.value.toruInfoItem.collectAsLazyPagingItems()
    val searchWord = searchScreenViewModel.searchWord.value
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(12.dp)
            .addFocusCleaner(focusManager)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                SearchTextField(
                    searchWord,
                    searchScreenViewModel,
                    navController
                )
            }
        }
        SearchTourList(tourInfoItem)
    }
}

@Composable
fun SearchTextField(
    searchWord: String,
    searchScreenViewModel: SearchScreenViewModel,
    navController: NavHostController
) {
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
            onSearch = {
                if(searchWord.isBlank()) return@KeyboardActions
                navController.navigate(
                    route = BottomNavScreen.SearchResult.passSearchWord(searchWord)
                )
            }
        ),
        singleLine = true
    )
}

fun Modifier.addFocusCleaner(
    focusManager: FocusManager,
    doOnClear: () -> Unit = {}
): Modifier {
    return this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            doOnClear()
            focusManager.clearFocus()
        })
    }
}