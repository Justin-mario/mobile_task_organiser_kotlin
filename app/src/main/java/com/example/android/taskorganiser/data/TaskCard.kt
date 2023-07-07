package com.example.android.taskorganiser.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class TaskCard(
    val time: String,
    val heading: String,
    val sub_heading: String,
    val taskTime: String,
    val backgroundColor: Color,
    val textColor: Color,
    @DrawableRes val imageList: List<Int>

)
