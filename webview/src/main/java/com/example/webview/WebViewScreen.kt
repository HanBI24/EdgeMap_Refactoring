package com.example.webview

import androidx.compose.runtime.Composable
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebViewScreen() {
    val webViewState = rememberWebViewState(
            url = "www.naver.com",
            additionalHttpHeaders = emptyMap()
        )
    WebView(state = webViewState)
}