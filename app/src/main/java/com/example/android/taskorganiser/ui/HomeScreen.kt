package com.example.android.taskorganiser.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.taskorganiser.R
import com.example.android.taskorganiser.ui.theme.AquaBlue
import com.example.android.taskorganiser.ui.theme.BlueViolet1
import com.example.android.taskorganiser.ui.theme.DeepBlue
import com.example.android.taskorganiser.ui.theme.TaskOrganiserTheme
import com.example.android.taskorganiser.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .clip(MaterialTheme.shapes.small)
        .background(TextWhite)) {
        GreetingSection()
    }
}

@Composable
fun GreetingSection(
    modifier: Modifier = Modifier,
    name: String = "Gozie"
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Hello, $name!",
                color = DeepBlue,
                style = MaterialTheme.typography.headlineMedium)

            Box(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(AquaBlue),
                contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.edited),
                        contentDescription = "profile image",
                        contentScale = ContentScale.FillBounds)
            }
        }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TaskOrganiserTheme {
        HomeScreen()
    }
}