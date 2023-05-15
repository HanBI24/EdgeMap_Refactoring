package com.example.webview

import androidx.compose.runtime.Composable
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebViewScreen(url: String) {
    val webViewState = rememberWebViewState(
            url = url,
            additionalHttpHeaders = emptyMap()
        )
    WebView(state = webViewState)
}