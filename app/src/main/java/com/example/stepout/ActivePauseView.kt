package com.example.stepout

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stepout.ui.theme.StepoutTheme

@Composable
fun ActivePauseView(navController: NavHostController) {
    val configuration      = LocalConfiguration.current
    val viewPadding        = getViewPadding(configuration)
    val viewTitleTextStyle = getViewTitleTextStyle(configuration)

    Surface (
        color = Color.White
    ) {
        val screenWidth = configuration.screenWidthDp.dp

        val exerciseImage = when {
            screenWidth <= 320.dp -> 140.dp
            screenWidth <= 420.dp -> 160.dp
            else -> 180.dp
        }

        val wireSize = when {
            screenWidth <= 320.dp -> 90.dp
            screenWidth <= 420.dp -> 120.dp
            else -> 150.dp
        }

        val instructionTextSize = when {
            screenWidth <= 320.dp -> 14.5.sp
            else -> 16.sp
        }

        val loadingBarPadding = when {
            else -> 20.dp
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
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                val appNameStyle = getAppNameStyle()
                AppName(appNameStyle)

                TextDisplayMedium(viewTitleTextStyle, "Pausa activa en curso")

                Image(
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(exerciseImage),
                    painter = painterResource(id = R.drawable.pa_icon),
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        contentDescription = "",
                        modifier = Modifier.size(wireSize),
                        painter = painterResource(id = R.drawable.radio),
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        text = "Estamos monitoreando tu actividad",
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            PaddingValues(
                                start = 10.dp,
                                end = 10.dp
                            )
                        )
                ) {
                    Text(
                        fontSize = instructionTextSize,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        text = "Sostén el celular en tu mano o bolsillo mientras realizas la pausa activa hasta que la barra de progreso sea completada."
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            PaddingValues(
                                start = loadingBarPadding,
                                end = loadingBarPadding
                            )
                        )
                ) {
                    LinearProgressIndicator(
                        progress = 0.3f,
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        fontSize = 14.sp,
                        text = "6:15"
                    )
                }
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
fun ActivePauseViewPreview() {
    val navController = rememberNavController()

    StepoutTheme {
        ActivePauseView(navController)
    }
}