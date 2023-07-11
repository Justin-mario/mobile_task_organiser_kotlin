package com.example.android.taskorganiser.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.taskorganiser.R
import com.example.android.taskorganiser.data.BottomMenuIcons
import com.example.android.taskorganiser.data.TaskOrganiserRepository.progress
import com.example.android.taskorganiser.data.ProgressCard
import com.example.android.taskorganiser.data.TaskCard
import com.example.android.taskorganiser.data.TaskOrganiserRepository.icons
import com.example.android.taskorganiser.data.TaskOrganiserRepository.taskList
import com.example.android.taskorganiser.ui.theme.AquaBlue
import com.example.android.taskorganiser.ui.theme.DeepBlue
import com.example.android.taskorganiser.ui.theme.PurpleGrey40
import com.example.android.taskorganiser.ui.theme.TaskOrganiserTheme
import com.example.android.taskorganiser.ui.theme.TextWhite
import com.example.android.taskorganiser.ui.theme.bottom_Menu_icon_color

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)
        .clip(MaterialTheme.shapes.small)
        .background(TextWhite)) {
        Column {
            GreetingSection()
            ProgressSection(progressList = progress )
            DateSection()
            TaskSection(taskCardList = taskList)
        }
        BottomMenuSection(icons = icons, modifier = Modifier.align(Alignment.BottomCenter))

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
                .padding(horizontal = 16.dp, vertical = 16.dp)
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

@Composable
fun ProgressSection(
    progressList: List<ProgressCard>,
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()) {
        Text(
            text = "Your Progress",
            color = DeepBlue,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(start = 16.dp, bottom = 12.dp))

        LazyRow {
            items(progressList.size) {
                ProgressCard(progressCard = progressList[it])
            }
        }
    }



}

@Composable
fun ProgressCard(progressCard: ProgressCard, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,

        modifier = modifier
            .padding(start = 16.dp, end = 4.dp, bottom = 16.dp)
            .widthIn(max = 110.dp, min = 100.dp)
            .heightIn(max = 190.dp, min = 170.dp)
            .clip(MaterialTheme.shapes.small)
            .background(progressCard.backgroundColor)
            .padding(8.dp),
       ) {
            CircularProgressBar(
                percentage = progressCard.percentage,
                number = progressCard.numberToDisplay,
                color = progressCard.textColor)
            Text(
                text = progressCard.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = progressCard.textColor,
                modifier = Modifier
                )

            Text(
                text = progressCard.note,
                fontSize = 10.sp,
                color = progressCard.textColor,
                )
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: String,
    fontSize: TextUnit = 10.sp,
    radius: Dp = 50.dp,
    color: Color,
    strokeWidth: Dp = 4.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )

    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(radius * 2f)
            .padding(top = 8.dp, bottom = 16.dp)
    ) {
        Canvas(modifier = Modifier.size(radius * 1f)) {
            drawArc(
                color = color,
                -90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (number),
            color = TextWhite,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun DateSection(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)) {
        Text(
            text = "Wednesday, March 7",
            color = DeepBlue,
            style = MaterialTheme.typography.titleSmall)

        Box(modifier = Modifier
            .size(40.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(AquaBlue),
            contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_event_24),
                contentDescription = "Calender",
                modifier = Modifier
                    .size(30.dp)
                    .padding(8.dp)
                    )
        }

    }
}

@Composable
fun TaskSection(taskCardList: List<TaskCard>) {
    LazyColumn(){
        items(taskCardList.size) {
            TaskCard(taskCard = taskCardList[it])
        }
    }
}

@Composable
fun TaskCard(taskCard: TaskCard,modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
        .padding(start = 16.dp, end = 12.dp, top = 12.dp, bottom = 8.dp)) {
        Text(
            text = taskCard.time,
            color = DeepBlue,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(end = 10.dp)
                .align(Alignment.Top)
        )
        Column(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .background(taskCard.backgroundColor)
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = taskCard.heading,
                color = taskCard.textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding()
            )
            Text(
                text = taskCard.sub_heading,
                color = taskCard.textColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfilePicturesCard()

                Text(
                    text = taskCard.taskTime,
                    color = taskCard.textColor,
                    fontSize = 10.sp
                )

                }


            }
        }
    }


@Composable
fun ProfilePicturesCard( modifier: Modifier = Modifier) {
    Row() {


            Image(
                painter = painterResource(id = R.drawable.usman_yousaf_yiovigqmjj4_unsplash),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(15.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )


            Image(
                painter = painterResource(id = R.drawable.gift_habeshaw_kbv5den3qty_unsplash),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(15.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )



            Image(
                painter = painterResource(id = R.drawable.sigmund_a19ovaa2rza_unsplash),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(15.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )



            Image(
                painter = painterResource(id = R.drawable.vicky_hladynets_uyatt9u6avi_unsplash),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(15.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
        }
    }

@Composable
fun BottomMenuSection(
    icons: List<BottomMenuIcons>,
    modifier: Modifier = Modifier) {

  var selectedIconIndex by remember {
      mutableStateOf(0)
  }
   Row(horizontalArrangement = Arrangement.SpaceAround,
       verticalAlignment = Alignment.CenterVertically,
       modifier= modifier
           .fillMaxWidth()
           .clip(MaterialTheme.shapes.extraLarge)
           .background(PurpleGrey40)
           .padding(vertical = 24.dp)) {
            icons.forEachIndexed { index, icon ->
                BottomMenu(
                    icon = icon,
                    isSelected = index == selectedIconIndex) {
                    selectedIconIndex = index
                }
            }
   }
}

@Composable
fun BottomMenu(  modifier: Modifier = Modifier,
                 isSelected: Boolean = false,
                icon: BottomMenuIcons,
               onIconClicked: () -> Unit,
) {

    Icon(
        painter = painterResource(id = icon.bottomMenuIcons),
        contentDescription = null,
        tint = if (isSelected) TextWhite else bottom_Menu_icon_color,
        modifier = modifier
            .size(20.dp)
            .clickable { onIconClicked() },
        )


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TaskOrganiserTheme {
        HomeScreen()
    }
}

