package com.teamj.moneytransferapp.nowifi

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900


@Composable
fun InternetErrorScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(G0, P900))),


        )


    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = com.teamj.moneytransferapp.R.drawable.no_wifi),
                contentDescription = "No Internet Image",
                modifier = Modifier
                    .size(109.dp)
            )

            Spacer(modifier = Modifier.height(53.87.dp))

            Text(
                text = "Internet connection disabled...",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            val context = LocalContext.current

            Button(

                onClick = {
                    refreshWifi(context)
                },
                colors = ButtonDefaults.buttonColors(containerColor = P300),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 4.dp)
                    .height(54.dp)
            ) {
                Text(
                    text = "Update",
                    fontSize =16.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun WifiRefreshButton() {
    val context = LocalContext.current

    Button(onClick = { refreshWifi(context) }) {
        Text("Refresh Wi-Fi")
    }
}

fun refreshWifi(context: Context) {

    val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

    wifiManager.isWifiEnabled = false
    wifiManager.isWifiEnabled = true
}

@Preview(showBackground = true)
@Composable
fun PreviewInternetErrorScreen() {
    InternetErrorScreen()
}
