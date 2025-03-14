package com.example.stepout

import NotificacionPushUI
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stepout.ui.theme.StepoutTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepoutTheme {
                Scaffold { innerPadding ->
                    var padding = innerPadding
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "StartView") {
        composable("StartView") { StartView(navController) }
        composable("HomeView") { HomeView(navController) }
        composable("ActivePauseView") { ActivePauseView(navController) }
    }
}

@Preview(widthDp = 320, heightDp = 640)
@Preview(widthDp = 420, heightDp = 840)
@Preview(widthDp = 480, heightDp = 920)
@Composable
fun AppNavigationPreview() {
    StepoutTheme {
        AppNavigation()
    }
}

@Composable
fun StartView(navController: NavHostController) {
    Column (
        modifier = Modifier
            .background(Color.White)
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(35.dp)
    ) {
        Button(onClick = { navController.navigate("HomeView") }) {
            Text(text = "Pantalla Home")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("ActivePauseView") }) {
            Text(text = "Pantalla Pausa Activa")
        }

        Spacer(modifier = Modifier.height(20.dp))
        NotificacionPushUI()
    }
}