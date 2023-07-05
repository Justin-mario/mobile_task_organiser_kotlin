package com.example.android.taskorganiser.data

import androidx.compose.ui.graphics.Color

data class ProgressCard(
    val title: String,
    val note: String,
    val backgroundColor: Color,
    val textColor: Color,
    val percentage: Float,
    val numberToDisplay: Int
)
