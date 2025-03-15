package com.example.stepout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stepout.ui.theme.StepoutTheme
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun GoogleTonalButton(userInfoStyle: UserInfoStyle) {
    FilledTonalButton(
        onClick = { /* TODO: acción de login */ },
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .height(userInfoStyle.addCalendarButtonHeight)
            .width(userInfoStyle.addCalendarButtonWidth * 1.5f),
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Ícono de Google
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = "Logo de Google",
                modifier = Modifier.size(20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            // Texto
            Text(
                text = "Continuar con Google",
                style = userInfoStyle.addCalendarButtonTextStyle
            )
        }
    }
}

@Composable
fun EmailDialog(
    onDismiss: () -> Unit,
    onNext: () -> Unit
) {
    // Capa oscura que cubre toda la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            // Simula desenfoque u oscurecimiento del fondo
            .background(Color.Black.copy(alpha = 0.5f))
            // Al hacer clic fuera del Card, se cierra el diálogo
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Card que imita la ventana emergente de Google
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                // Evita que se cierre si hacen clic dentro del Card
                .padding(8.dp)
        ) {
            // Contenido del "popup"
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                // Encabezado: "Acceder"
                Text(
                    text = "Acceder",
                    style = MaterialTheme.typography.titleLarge
                )

                // Subtítulo: "Ir a StepOut"
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Ir a StepOut",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo de correo electrónico
                var emailValue = remember { "" }
                OutlinedTextField(
                    value = emailValue,
                    onValueChange = { emailValue = it },
                    label = { Text("Correo electrónico o teléfono") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Opción: ¿Olvidaste el correo electrónico?
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "¿Olvidaste el correo electrónico?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Disclaimers
                Text(
                    text = "Antes de usar StepOut, revisa su política de privacidad y condiciones del servicio.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(16.dp))

                // "Crear cuenta" y "Siguiente"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = { /* Lógica para crear cuenta */ }) {
                        Text("Crear cuenta")
                    }
                    Button(onClick = onNext) {
                        Text("Siguiente")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Links inferiores: Ayuda | Privacidad | Condiciones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Ayuda",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Privacidad",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Condiciones",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun PasswordDialog(
    userEmail: String,
    onDismiss: () -> Unit,
    onLogin: () -> Unit
) {
    // Capa oscura que cubre toda la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Card que imita la ventana emergente de Google
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                // Encabezado: "Te damos la bienvenida"
                Text(
                    text = "Te damos la bienvenida",
                    style = MaterialTheme.typography.titleLarge
                )

                // Subtítulo: correo del usuario
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = userEmail,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo de contraseña
                var passwordValue by remember { mutableStateOf("") }
                var showPassword by remember { mutableStateOf(false) }

                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = passwordValue },
                    label = { Text("Ingresa tu contraseña") },
                    modifier = Modifier.fillMaxWidth(),
                )

                // Checkbox "Mostrar contraseña"
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = showPassword,
                        onCheckedChange = { showPassword = it }
                    )
                    Text(
                        text = "Mostrar contraseña",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // ¿Olvidaste la contraseña?
                Text(
                    text = "¿Olvidaste la contraseña?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Disclaimers
                Text(
                    text = "Antes de usar StepOut, revisa su política de privacidad y condiciones del servicio.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(16.dp))

                // "Siguiente"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = onLogin) {
                        Text("Iniciar sesión")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Sección inferior (Ejemplo: idioma, ayuda, privacidad, condiciones)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Español (Latinoamérica)",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Ayuda",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Privacidad",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Condiciones",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

private fun ColumnScope.OutlinedTextField(value: String, onValueChange: () -> Unit, label: @Composable () -> Unit, modifier: Modifier, visualTransformation: Any) {

}


@Composable
fun LoginView(
    navController: NavHostController
) {
    // Controlar modales
    var showEmailDialog by remember { mutableStateOf(false) }
    var showPasswordDialog by remember { mutableStateOf(false) }

    // Guardar correo
    var userEmail by remember { mutableStateOf("") }

    // FONDO PRINCIPAL
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // CONTENEDOR PRINCIPAL EN COLUMNA
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // IMAGEN / ILUSTRACIÓN
            Image(
                painter = painterResource(id = R.drawable.login_illustration),
                contentDescription = "Ilustración de bienvenida",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            // NOMBRE DE LA APP
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    contentDescription = "logo",
                    modifier = Modifier.size(43.dp),
                    painter = painterResource(id = R.drawable.icon),
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "StepOut",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // TAGLINE / DESCRIPCIÓN
            Text(
                text = "Descubre el secreto para disfrutar de una rutina de estudio o trabajo",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // BOTÓN "CONTINUAR CON GOOGLE"
            val configuration = LocalConfiguration.current
            val userInfoStyle = getUserInfoStyle(configuration)
            FilledTonalButton(
                onClick = { showEmailDialog = true },
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier
                    .height(userInfoStyle.addCalendarButtonHeight)
                    .width(userInfoStyle.addCalendarButtonWidth * 1.5f),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Ícono de Google
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google_logo),
                        contentDescription = "Logo de Google",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Continuar con Google",
                        style = userInfoStyle.addCalendarButtonTextStyle
                    )
                }
            }
        }

        // MOSTRAR MODAL DE CORREO
        if (showEmailDialog) {
            EmailDialog(
                onDismiss = { showEmailDialog = false },
                onNext = {
                    // Cerrar el EmailDialog
                    showEmailDialog = false
                    // Abrir PasswordDialog
                    showPasswordDialog = true
                }
            )
        }

        // MOSTRAR MODAL DE CONTRASEÑA
        if (showPasswordDialog) {
            PasswordDialog(
                userEmail = userEmail,
                onDismiss = { showPasswordDialog = false },
                onLogin = {
                    // Aquí podrías navegar a Home o a otra vista
                    showPasswordDialog = false
                    navController.navigate("HomeView")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    StepoutTheme {
        val navController = rememberNavController()
        LoginView(navController)
    }
}
