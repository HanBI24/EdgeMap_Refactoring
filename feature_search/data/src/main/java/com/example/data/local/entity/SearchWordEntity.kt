package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchWordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val searchWord: String
)
