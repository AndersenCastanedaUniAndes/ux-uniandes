import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.stepout.MainActivity
import com.example.stepout.R

@Composable
fun NotificacionPushUI() {
    val context = LocalContext.current
    val permission = Manifest.permission.POST_NOTIFICATIONS

    var hasPermissions by remember {
        mutableStateOf(
            Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
                    ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        )
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        hasPermissions = isGranted
    }

    if (!hasPermissions && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Button(onClick = { requestPermissionLauncher.launch(permission) }) {
            Text(text = "Solicitar Permiso")
        }
    } else {
        Button(onClick = { mostrarNotificacionPush(context) }) {
            Text(text = "Mostrar Notificación Push")
        }
    }
}

fun mostrarNotificacionPush(context: Context) {
    val channelId = "canal_push"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            "Canal Push",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Canal para notificaciones push"
        }
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context, 0, intent, PendingIntent.FLAG_IMMUTABLE
    )

    val responderIntent = Intent(context, ResponderReceiver::class.java)
    val responderPendingIntent: PendingIntent = PendingIntent.getBroadcast(
        context, 1, responderIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    val actionResponder = NotificationCompat.Action.Builder(
        android.R.drawable.ic_menu_send, "Aplazar por 5 minutos", responderPendingIntent
    ).build()

    val marcarLeidoIntent = Intent(context, MarcarLeidoReceiver::class.java)
    val marcarLeidoPendingIntent: PendingIntent = PendingIntent.getBroadcast(
        context, 2, marcarLeidoIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    val actionMarcarLeido = NotificationCompat.Action.Builder(
        android.R.drawable.ic_menu_info_details, "Descartar", marcarLeidoPendingIntent
    ).build()

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.icon)
        .setContentTitle("Pausa activa - StepOut")
        .setContentText("Prepárate para tu próxima pausa")
        .setPriority(NotificationCompat.PRIORITY_HIGH) // Push Notification
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .setStyle(NotificationCompat.BigTextStyle().bigText("Pausa activa - StepOut \n Prepárate para tu próxima pausa"))
        .addAction(actionResponder)
        .addAction(actionMarcarLeido)

    // Mostrar la notificación
    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        notify(1, builder.build())
    }
}

// Receptor para "Responder"
class ResponderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val notificationManager = NotificationManagerCompat.from(it)
            notificationManager.cancel(1) // Quita la notificación después de responder
        }
    }
}

// Receptor para "Marcar como leído"
class MarcarLeidoReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val notificationManager = NotificationManagerCompat.from(it)
            notificationManager.cancel(1) // Quita la notificación
        }
    }
}
