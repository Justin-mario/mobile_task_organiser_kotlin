package com.example.android.taskorganiser.data


import com.example.android.taskorganiser.ui.theme.LightRed
import com.example.android.taskorganiser.ui.theme.OrangeYellow2
import com.example.android.taskorganiser.ui.theme.PurpleGrey80
import com.example.android.taskorganiser.ui.theme.md_theme_dark_onSurface


object Progress {
    val progress = listOf(
        ProgressCard(
            "Working Hours",
            " Working hours exceeded by 3 hours",
            LightRed,
            md_theme_dark_onSurface,
            0.45f,
            "19/40"
        ),
        ProgressCard(
            "Your Efficiency",
            "Excellent Result",
            OrangeYellow2,
            PurpleGrey80,
            0.82f,
            "82%"
        ),
        ProgressCard(
            "Your Efficiency",
            "Excellent Result",
            OrangeYellow2,
            PurpleGrey80,
            0.75f,
            "12/40"
        )
    )

}