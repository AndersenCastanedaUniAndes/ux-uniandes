package com.example.stepout

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class UserInfoStyle (
    var addCalendarButtonTextStyle: TextStyle,
    var addCalendarButtonHeight: Dp,
    var addCalendarButtonWidth: Dp
)

@Composable
fun getUserInfoStyle(configuration: Configuration): UserInfoStyle {
    val screenWidth = configuration.screenWidthDp.dp

    val addCalendarButtonTextStyle = when {
        screenWidth <= 320.dp -> MaterialTheme.typography.labelMedium
        else -> MaterialTheme.typography.labelLarge
    }

    val addCalendarButtonHeight = when {
        screenWidth <= 320.dp -> 38.dp
        else -> 40.dp
    }

    val addCalendarButtonWidth = when {
        screenWidth <= 320.dp -> 140.dp
        else -> 168.dp
    }

    var infoStyle = UserInfoStyle(
        addCalendarButtonTextStyle = addCalendarButtonTextStyle,
        addCalendarButtonHeight = addCalendarButtonHeight,
        addCalendarButtonWidth = addCalendarButtonWidth,
    )

    return infoStyle
}

@Composable
fun UserInfo(userName: String, userInfoStyle: UserInfoStyle) {
    Row (
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            contentDescription = "",
            modifier = Modifier.size(55.dp),
            painter = painterResource(id = R.drawable.user_icon),
        )

        Spacer(modifier = Modifier.width(10.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                TextLabelSmall("Hola,")
                TextTitleLarge(userName)
            }

            Button(
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .height(userInfoStyle.addCalendarButtonHeight)
                    .width(userInfoStyle.addCalendarButtonWidth),
                onClick = { }
            ) {
                Text(
                    color = Color.White,
                    style = userInfoStyle.addCalendarButtonTextStyle,
                    text = "Agregar calendario",
                )
            }
        }
    }
}