package com.teamj.moneytransferapp.corefun

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G900
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun startInactivityTimer(navController: NavHostController, allowedRoutes: List<String> = emptyList()) {


    var isDialogVisible by remember { mutableStateOf(false) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    var lastInteractionTime by remember { mutableStateOf(System.currentTimeMillis()) }

    LaunchedEffect(lastInteractionTime) {

        //Usually 120000 milliseconds is equivalent to 2 minutes however test wise did not prove to be so, 160000 is closer to 2 minutes

        delay(160_000L)
        val currentRoute = currentBackStackEntry?.destination?.route

        if (currentRoute != null && !allowedRoutes.contains(currentRoute)) {
            navController.navigate("login") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                    isDialogVisible = true
                }
            }
        }
    }

    if (isDialogVisible) {
        AlertDialog(
            onDismissRequest = {
                isDialogVisible = false
            },
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row (
                        modifier = Modifier
                        .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.alert),
                            contentDescription = null
                        )

                        Text(
                            text = "We Logged you out because you were inactive for 2 minutes - it's to help your account secure",
                            style = TextStyle(
                                color = G900,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Unspecified
                            ),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                    }
                }
            },
            confirmButton = {},

            containerColor = G40,

            shape = RoundedCornerShape(8.dp),
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    lastInteractionTime = System.currentTimeMillis()
                }
            }
    )
}