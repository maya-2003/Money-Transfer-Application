package com.teamj.moneytransferapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P75
import com.teamj.moneytransferapp.ui.theme.P900
import com.teamj.moneytransferapp.ui.viewmodels.CardViewModel

@Composable
fun CardSplashScreen(navController: NavController,modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(G0, P900)
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            ProgressIndicator(navController)

        }
    }

}

@Composable
fun ProgressIndicator(navController: NavController, modifier: Modifier=Modifier, viewModel: CardViewModel = viewModel()) {
    val splashShow by viewModel.splashShow.collectAsState()

    LaunchedEffect(splashShow) {
        if (!splashShow) {
            navController.navigate(Route.CARD_OTP)
        }
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.size(200.dp)) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize(),
            color = P300,
            trackColor = P75,
            strokeWidth = 8.dp
        )

        Text(
            textAlign = TextAlign.Center,
            text = """Speedo
                |Transfer""".trimMargin(),
            style = MaterialTheme.typography.bodyLarge,
            color = G900,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold))
        )
    }
    Spacer(modifier = modifier.height(20.dp))
    Text(
        textAlign = TextAlign.Center,
        text = """Connecting to Speedo Transfer
            |Credit Card""".trimMargin(),
        style = MaterialTheme.typography.bodyLarge,
        color = G900,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.inter_bold))
    )
}

@Preview(showSystemUi = true)
@Composable
fun CreditCardConnectingScreenPreview() {
    CardSplashScreen(rememberNavController())
}