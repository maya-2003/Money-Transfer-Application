//package com.teamj.moneytransferapp.corefun
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.DisposableEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalLifecycleOwner
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.Lifecycle
//import androidx.lifecycle.LifecycleEventObserver
//import androidx.navigation.NavController
//import com.teamj.moneytransferapp.R
//import com.teamj.moneytransferapp.navigation.Route
//import com.teamj.moneytransferapp.ui.theme.G40
//import com.teamj.moneytransferapp.ui.theme.G900
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//@Composable
//fun TouchAlertDialog(navController: NavController) {
//
//
//    val timeout = LocalLifecycleOwner.current
//    val inactivityTimeout = 2 *60 * 1000L
//    var isDialogVisible by remember { mutableStateOf(false) }
//    val coroutineScope = rememberCoroutineScope()
//
//    val resetTimer: () -> Unit = {
//
//        isDialogVisible = false
//        coroutineScope.launch {
//
//            delay(inactivityTimeout)
//            isDialogVisible = true
//
//        }
//    }
//
//    DisposableEffect(timeout) {
//        val observer = LifecycleEventObserver { _, event ->
//            if (event == Lifecycle.Event.ON_RESUME) {
//                resetTimer()
//            }
//        }
//
//        timeout.lifecycle.addObserver(observer)
//        onDispose {
//            timeout.lifecycle.removeObserver(observer)
//        }
//    }
//
//    // Change SignUp to SignIN , popUpTo(Route.SPLASH_SCREEN)
//
//    val logoutUser: () -> Unit = {
//        navController.navigate(Route.LOGIN) {
//            popUpTo(Route.SPLASH) { inclusive = true }
//        }
//    }
//
//    if (isDialogVisible) {
//        AlertDialog(
//            onDismissRequest = {
//                isDialogVisible = false
//                logoutUser()
//            },
//            title = {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Row (
//                        modifier = Modifier
//                        .fillMaxWidth()
//                    ){
//                        Image(
//                            painter = painterResource(id = R.drawable.alert),
//                            contentDescription = null
//                        )
//
//                        Text(
//                            text = "We Logged you out because you were inactive for 2 minutes - it's to help your account secure",
//                            style = TextStyle(
//                                color = G900,
//                                fontSize = 14.sp,
//                                textAlign = TextAlign.Unspecified
//                            ),
//                            modifier = Modifier.padding(horizontal = 16.dp)
//                        )
//
//                    }
//                }
//            },
//            confirmButton = {},
//
//            containerColor = G40,
//
//            shape = RoundedCornerShape(8.dp),
//        )
//    }
//}
//
//
//@Preview
//@Composable
//fun AlertDialogPreview() {
//    TouchAlertDialog(navController = NavController(LocalContext.current))
//}
