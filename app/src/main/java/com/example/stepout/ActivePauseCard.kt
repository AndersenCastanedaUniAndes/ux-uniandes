package com.example.stepout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ActivePause(
    var date: Date,          // Date (10-02-2025)
    var startHour: String,   // Start time (9:30)
    var endHour: String,     // End time (10:30)
    var durationMinutes: Int // Duration in minutes (15)
)

fun formatDate(date: Date): String {
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    return formatter.format(date)
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
                CardContent("${activePause.startHour} - ${activePause.endHour} (${activePause.durationMinutes} minutos)")
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
fun CardContent(text: String) {
    Text(
        style = MaterialTheme.typography.bodyMedium,
        text = text
    )
}