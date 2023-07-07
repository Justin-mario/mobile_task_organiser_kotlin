package com.example.android.taskorganiser.data


import androidx.compose.ui.graphics.Color
import com.example.android.taskorganiser.R
import com.example.android.taskorganiser.ui.theme.AquaBlue
import com.example.android.taskorganiser.ui.theme.Beige1
import com.example.android.taskorganiser.ui.theme.DeepBlue
import com.example.android.taskorganiser.ui.theme.LightRed
import com.example.android.taskorganiser.ui.theme.OrangeYellow2
import com.example.android.taskorganiser.ui.theme.PurpleGrey80
import com.example.android.taskorganiser.ui.theme.md_theme_dark_onSurface


object TaskOrganiserRepository {
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

    val taskList = listOf(
        TaskCard(
            "10:00 AM",
            "Meeting with front-end developers",
            "Flose Real Estate Project",
            "9:50 AM - 10:50 AM",
            Beige1,
            Color.Red,
                listOf(
                    R.drawable.usman_yousaf_yiovigqmjj4_unsplash,
                    R.drawable.gift_habeshaw_kbv5den3qty_unsplash,
                    R.drawable.omid_armin_65jdpsttl_0_unsplash,
                    R.drawable.rita_malcok_oohtxx5mjqi_unsplash
                )
        ),
        TaskCard(
            "11:00 AM",
            "Internal marketing session",
            "Marketing Department",
            "11:00 AM - 12:00 PM",
            AquaBlue,
            DeepBlue,
                listOf(
                    R.drawable.sigmund_a19ovaa2rza_unsplash,
                    R.drawable.stefan_stefancik_qxevdflbl8a_unsplash,
                    R.drawable.vicky_hladynets_uyatt9u6avi_unsplash,
                )

    ),

        TaskCard(
            "12:00 AM",
            "Meeting with Management",
            "Board Meeting",
            "12:10 PM - 1:50 PM",
            Beige1,
            Color.Red,
                listOf(
                    R.drawable.usman_yousaf_yiovigqmjj4_unsplash,
                    R.drawable.gift_habeshaw_kbv5den3qty_unsplash,
                    R.drawable.omid_armin_65jdpsttl_0_unsplash,
                    R.drawable.rita_malcok_oohtxx5mjqi_unsplash
                )
        ),
    )

}