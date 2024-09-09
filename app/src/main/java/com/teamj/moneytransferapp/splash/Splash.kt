package com.teamj.moneytransferapp.splash


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.teamj.moneytransferapp.R


@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.P500)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Speedo Transfer",
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
