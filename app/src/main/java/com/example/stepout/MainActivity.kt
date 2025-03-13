package com.example.stepout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stepout.ui.theme.StepoutTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var padding = innerPadding
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    val configuration = LocalConfiguration.current

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
            startHour = "09:30",
            endHour = "09:45",
            durationMinutes = 15
        )
    )

    StepoutTheme {
        Surface (
            color = Color.White
        ) {
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

            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        paddingValues = PaddingValues(
                            top = dynamicTopPadding,
                            start = dynamicWithPadding,
                            end = dynamicWithPadding,
//                            bottom = dynamicTopPadding
                        )
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                val appNameStyle = getAppNameStyle()
                AppName(appNameStyle)

                Spacer(modifier = Modifier.height(20.dp))

                val userInfoStyle = getUserInfoStyle(configuration)
                UserInfo("Diana", userInfoStyle)

                val spacerSize = when {
                    screenWidth <= 320.dp -> 20.dp
                    screenWidth <= 420.dp -> 26.dp
                    else -> 42.dp
                }
                Spacer(modifier = Modifier.height(spacerSize))

                val messageTextStyle = when {
                    screenWidth <= 320.dp -> MaterialTheme.typography.displaySmall
                    else -> MaterialTheme.typography.displayMedium
                }
                TextDisplayMedium(messageTextStyle, "Pausas activas para hoy")

                Spacer(modifier = Modifier.height(24.dp))

                Column (

                ) {
                    val cardGroupTextStyle = when {
                        screenWidth <= 320.dp -> MaterialTheme.typography.headlineSmall
                        else -> MaterialTheme.typography.displaySmall
                    }
                    ActivePauses(
                        textStyle = cardGroupTextStyle,
                        title = "Completadas",
                        activePauses = breaks
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    ActivePauses(
                        textStyle = cardGroupTextStyle,
                        title = "Por completar",
                        activePauses = breaks
                    )
                }
            }
        }
    }
}

data class ActivePause(
    var date: Date,          // Date (10-02-2025)
    var startHour: String,   // Start time (9:30)
    var endHour: String,     // End time (10:30)
    var durationMinutes: Int // Duration in minutes (15)
)

data class AppNameStyle(
    var nameStyle: TextStyle
)

@Preview(widthDp = 320, heightDp = 640)
@Preview(widthDp = 420, heightDp = 840)
@Preview(widthDp = 480, heightDp = 920)
@Composable
fun HomePreview() {
    StepoutTheme {
        Home()
    }
}

@Composable
fun getAppNameStyle(): AppNameStyle {
    val appNameStyle = AppNameStyle(
        nameStyle = MaterialTheme.typography.displayMedium
    )

    return  appNameStyle
}

@Composable
fun AppName(appNameStyle: AppNameStyle) {
    Row (
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            contentDescription = "logo",
            modifier = Modifier.size(43.dp),
            painter = painterResource(id = R.drawable.icon),
        )

        Spacer(modifier = Modifier.width(12.dp))

        TextDisplayMedium(appNameStyle.nameStyle, "StepOut")
    }
}


@Composable
fun ActivePauses(title: String, textStyle: TextStyle, activePauses: Array<ActivePause>) {
    Column {
        TextDisplayMedium(textStyle, title)

        Spacer(modifier = Modifier.height(16.dp))
        for (activePause in activePauses) {
            ActivePauseCard (activePause)
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Composable
fun ActivePauseCard(activePause: ActivePause) {
    Card (
        modifier = Modifier
            .border(1.dp, Color(red = 202, green = 196, blue = 208), RoundedCornerShape(12.dp))
            .height(80.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            var date = formatDate(activePause.date)
            Column (modifier = Modifier.padding(start = 16.dp)) {
                CardTitle(date)
                CardMedium("${activePause.startHour} - ${activePause.endHour} (${activePause.durationMinutes} minutos)")
            }

            var isChecked by remember { mutableStateOf(false) }
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
        }
    }
}

@Composable
fun CardTitle(text: String) {
    Text(
        style = MaterialTheme.typography.titleMedium,
        text = text
    )
}

@Composable
fun CardMedium(text: String) {
    Text(
        style = MaterialTheme.typography.bodyMedium,
        text = text
    )
}

fun formatDate(date: Date): String {
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    return formatter.format(date)
}

@Composable
fun TextLabelSmall(text: String) {
    Text(
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.labelSmall,
        text = text
    )
}

@Composable
fun TextTitleLarge(text: String) {
    Text(
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleLarge,
        text = text,
    )
}

@Composable
fun TextDisplayMedium(style: TextStyle, text: String) {
    Text(
        color = MaterialTheme.colorScheme.primary,
        style = style,
        text = text
    )
}