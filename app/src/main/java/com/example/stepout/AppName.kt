package com.example.stepout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

data class AppNameStyle(
    var nameStyle: TextStyle
)

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