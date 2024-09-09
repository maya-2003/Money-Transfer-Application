package com.teamj.moneytransferapp

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.teamj.moneytransferapp.navigation.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AlertDialog(navController: NavController) {


    val timeout = LocalLifecycleOwner.current
    val inactivityTimeout = 2 * 60 * 1000L
    var isDialogVisible by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    val resetTimer: () -> Unit = {

        isDialogVisible = false
        coroutineScope.launch {

            delay(inactivityTimeout)
            isDialogVisible = true

        }
    }


    DisposableEffect(timeout) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                resetTimer()
            }
        }

        timeout.lifecycle.addObserver(observer)
        onDispose {
            timeout.lifecycle.removeObserver(observer)
        }
    }

    // Change SignUp to SignIN , popUpTo(Route.SPLASH_SCREEN)

    val logoutUser: () -> Unit = {
        navController.navigate(Route.SIGNUP) {
            popUpTo(Route.SIGNUP) { inclusive = true }
        }
    }

    if (isDialogVisible) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Inactive Dialog") },
            text = { Text(text = "You have been inactive for 2 minutes, you will be logged out") },
            confirmButton = {

                Button(
                    onClick = {
                        isDialogVisible = false
                        logoutUser()
                    })
                {
                    Text(text = "ok")
                }
            }
        )
    }
}

