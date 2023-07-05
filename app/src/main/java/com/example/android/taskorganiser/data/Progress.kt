package com.example.android.taskorganiser.data


import com.example.android.taskorganiser.ui.theme.LightRed
import com.example.android.taskorganiser.ui.theme.OrangeYellow2
import com.example.android.taskorganiser.ui.theme.PurpleGrey40
import com.example.android.taskorganiser.ui.theme.TextWhite

object Progress {
    val progress = listOf(
        ProgressCard(
            "Working Hours",
            " Working hours exceeded by 3 hours",
            LightRed,
            TextWhite,
            45f,
            19
        ),
        ProgressCard(
            "Your Efficiency",
            "Excellent Result",
            OrangeYellow2,
            PurpleGrey40,
            82f,
            82
        ),
        ProgressCard(
            "Your Efficiency",
            "Excellent Result",
            OrangeYellow2,
            PurpleGrey40,
            85f,
            12
        )
    )

}