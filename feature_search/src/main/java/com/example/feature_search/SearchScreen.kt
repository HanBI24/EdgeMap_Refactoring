package com.example.feature_search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.domain.model.local.SearchWordItem
import com.example.navigation.BottomNavScreen
import com.example.presentation.viewmodel.SearchScreenViewModel
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    navController: NavHostController
) {
    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()
    val tourInfoItem =
        searchScreenViewModel.tourInfoState.value.toruInfoItem.collectAsLazyPagingItems()
    val searchWordList =
        searchScreenViewModel.getAllSearchWord().collectAsState(initial = listOf()).value
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
                SearchBarField(
                    searchWord,
                    searchScreenViewModel,
                    navController,
                    searchWordList
                )
            }
        }
        SearchTourList(tourInfoItem, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarField(
    searchWord: String,
    searchScreenViewModel: SearchScreenViewModel,
    navController: NavHostController,
    searchWordList: List<SearchWordItem>
) {
    var active by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        query = searchWord,
        onQueryChange = searchScreenViewModel::onSearchWordChanged,
        active = active,
        colors = SearchBarDefaults.colors(
            containerColor = Color.DarkGray,
            dividerColor = Color.LightGray
        ),
        onActiveChange = { active = it },
        placeholder = { Text("목적지를 입력하세요.") },
        onSearch = {
            if (searchWord.isEmpty()) return@SearchBar
            active = false
            scope.launch {
                searchScreenViewModel.insertSearchWord(searchWord)
            }
            navController.navigate(
                route = BottomNavScreen.SearchResult.passSearchWord(searchWord)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (active) {
                Icon(
                    modifier = Modifier.clickable {
                        if (searchWord.isNotEmpty())
                            searchScreenViewModel.makeSearchWordEmpty()
                        else active = false
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon"
                )
            }
        }
    ) {
        searchWordList.forEach {
            Row(
                modifier = Modifier
                    .padding(14.dp)
                    .weight(1f)
                    .clickable {
                        scope.launch {
                            searchScreenViewModel.insertSearchWord(it.searchWord)
                        }
                        navController.navigate(
                            route = BottomNavScreen.SearchResult.passSearchWord(it.searchWord)
                        )
                    }
            ) {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "History Icon"
                )
                Text(text = it.searchWord)
                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = {
                        scope.launch {
                            println("awef")
                            searchScreenViewModel.deleteSearchWord(it)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove List Icon"
                    )
                }
            }
        }
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
                if (searchWord.isEmpty()) return@KeyboardActions
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