package com.example.data.remote.dto.geocode

data class GeoCodeDto(
    val addresses: List<Addresse>,
    val errorMessage: String,
    val meta: Meta,
    val status: String
)