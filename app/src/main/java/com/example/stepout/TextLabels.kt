package com.example.stepout

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

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