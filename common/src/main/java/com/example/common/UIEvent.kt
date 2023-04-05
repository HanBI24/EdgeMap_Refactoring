package com.example.common

sealed class UIEvent {
    data class ShowSnackbar(val message: String): UIEvent()
}
