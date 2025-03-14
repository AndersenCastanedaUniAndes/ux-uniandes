package com.example.stepout

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stepout.ui.theme.StepoutTheme
import java.util.Calendar

@Composable
fun getViewPadding(configuration: Configuration) : PaddingValues {
    val screenWidth = configuration.screenWidthDp.dp

    val dynamicTopPadding = when {
        screenWidth <= 320.dp -> 10.dp
        screenWidth <= 420.dp -> 24.dp
        else -> 56.dp
    }

    val dynamicWithPadding = when {
        screenWidth <= 320.dp -> 15.dp
        else -> 30.dp
    }

    val paddingValues = PaddingValues(
        top = dynamicTopPadding,
        start = dynamicWithPadding,
        end = dynamicWithPadding,
    )

    return paddingValues
}

@Composable
fun getViewTitleTextStyle(configuration: Configuration): TextStyle {
    val screenWidth = configuration.screenWidthDp.dp

    val textStyle = when {
        screenWidth <= 320.dp -> MaterialTheme.typography.displaySmall
        else -> MaterialTheme.typography.displayMedium
    }

    return textStyle
}

data class HomeStyle (
    var cardGroupTextStyle: TextStyle
)

@Composable
fun getHomeStyle(configuration: Configuration): HomeStyle {
    val screenWidth = configuration.screenWidthDp.dp

    val cardGroupTextStyle = when {
        screenWidth <= 320.dp -> MaterialTheme.typography.headlineSmall
        else -> MaterialTheme.typography.displaySmall
    }

    val homeStyle = HomeStyle(
        cardGroupTextStyle = cardGroupTextStyle,
    )

    return homeStyle
}

@Composable
fun HomeView(navController: NavHostController) {
    val configuration      = LocalConfiguration.current
    val viewPadding        = getViewPadding(configuration)
    val homeStyle          = getHomeStyle(configuration)
    val viewTitleTextStyle = getViewTitleTextStyle(configuration)

    val calendar = Calendar.getInstance()
    calendar.set(2025, Calendar.MARCH, 14)

    val breaks = arrayOf(
        ActivePause(
            date = calendar.time,
            startHour = "09:30",
            endHour = "09:45",
            durationMinutes = 15
        ),
        ActivePause(
            date = calendar.time,
            startHour = "14:30",
            endHour = "14:45",
            durationMinutes = 15
        ),
        ActivePause(
            date = calendar.time,
            startHour = "18:30",
            endHour = "18:45",
            durationMinutes = 15
        )
    )

    Surface (
        color = Color.White
    ) {
        val screenWidth = configuration.screenWidthDp.dp
        val spacerSize = when {
            screenWidth <= 320.dp -> 20.dp
            screenWidth <= 420.dp -> 26.dp
            else -> 42.dp
        }

        Box (
            modifier = Modifier.padding(PaddingValues(
                top = 25.dp
            ))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(viewPadding)
                    .verticalScroll(rememberScrollState()),
            ) {
                Spacer(modifier = Modifier.height(35.dp))

                val appNameStyle = getAppNameStyle()
                AppName(appNameStyle)

                val userInfoStyle = getUserInfoStyle(configuration)
                Spacer(modifier = Modifier.height(20.dp))
                UserInfo("Diana", userInfoStyle)

                Spacer(modifier = Modifier.height(spacerSize))
                TextDisplayMedium(viewTitleTextStyle, "Pausas activas para hoy")

                Spacer(modifier = Modifier.height(24.dp))
                Column {
                    ActivePauses(
                        textStyle = homeStyle.cardGroupTextStyle,
                        title = "Completadas",
                        activePauses = breaks
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    ActivePauses(
                        textStyle = homeStyle.cardGroupTextStyle,
                        title = "Por completar",
                        activePauses = breaks
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

            Row (
                modifier = Modifier
                    .background(color = Color(red = 255, green = 0, blue = 0, alpha = 180))
                    .fillMaxWidth()
            ) {
                IconButton(
                    modifier = Modifier.size(40.dp),
                    onClick = { navController.navigate("StartView") }
                ) {
                    Icon(
                        contentDescription = "",
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 320, heightDp = 640)
@Preview(widthDp = 420, heightDp = 840)
@Preview(widthDp = 480, heightDp = 920)
@Composable
fun HomeViewPreview() {
    val navController = rememberNavController()

    StepoutTheme {
        HomeView(navController)
    }
}