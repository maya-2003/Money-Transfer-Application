package com.teamj.moneytransferapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.navigation.AppNavHost
import com.teamj.moneytransferapp.ui.theme.MoneyTransferAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController()
            MoneyTransferAppTheme {
                AppNavHost(navController,onSendNotification = { sendNotification(this) })
            }
            UserAPIService.initialize(this){
                lifecycleScope.launch {
                    delay(500L)

                    runOnUiThread {
                        navController.navigate("login") {
                            popUpTo(0)
                        }
                    }
                }
            }

        }
        createNotificationChannel()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 101)
        }
    }

    fun storePrefs(token: String, userId: Int) {
        val editor = getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
        editor.putString("auth_token", token)
        editor.putInt("user_id", userId)
        editor.apply()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Transaction Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("1", name, importance)
            channel.description="Transaction notification"

            val manager=this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(context: Context) {
        val builder = NotificationCompat.Builder(context, "1")
            .setSmallIcon(R.drawable.ic_received)
            .setContentTitle("Receive Transaction")
            .setContentText("You have received a transaction")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)


    }


}
