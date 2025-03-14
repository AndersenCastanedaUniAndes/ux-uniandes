package com.example.stepout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.stepout.ui.theme.StepoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var padding = innerPadding
                    // HomeView()
                    ActivePauseView()
                }
            }
        }
    }
}