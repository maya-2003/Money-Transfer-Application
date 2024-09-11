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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.data.UserPrefs


@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier, viewModel: SplashViewModel = viewModel()) {

    val context= LocalContext.current
    val splashShow by viewModel.splashShow.collectAsState()
    val showOnboarding = rememberSaveable { UserPrefs.finishOnboarding(context) }

    LaunchedEffect(splashShow) {
        if (!splashShow) {
            if (showOnboarding) {
                navController.navigate(Route.LOGIN)
            } else {
                navController.navigate(Route.ONBOARDING)
            }
        }
    }
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
    SplashScreen(rememberNavController())
}
