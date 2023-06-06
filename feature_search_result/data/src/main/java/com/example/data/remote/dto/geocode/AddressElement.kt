package com.example.data.remote.dto.geocode

data class AddressElement(
    val code: String,
    val longName: String,
    val shortName: String,
    val types: List<String>
)