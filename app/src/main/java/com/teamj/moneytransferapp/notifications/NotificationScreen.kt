package com.teamj.moneytransferapp.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maya.signupapplication.viewmodels.NotificationViewModel
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.P75
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad
import com.teamj.moneytransferapp.ui.theme.cardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(onSendNotification: () -> Unit, navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Route.HOME)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back arrow icon"
                        )
                    }
                },
                title = {
                    Text(
                        "Notifications",
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = Color.DarkGray
                ),
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                .size(70.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_home),
                                    contentDescription = "home icon",
                                    tint = G200
                                )
                                Text(
                                    text = "home",
                                    color = G200
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                .size(70.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_transfer),
                                    contentDescription = "Settings icon",
                                    tint = G200
                                )
                                Text(
                                    text = "Transfer",
                                    color = G200
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                .size(110.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_history),
                                    contentDescription = "Settings icon",
                                    tint = G200
                                )
                                Text(
                                    text = "Transactions",
                                    color = G200
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                .size(80.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_cards),
                                    contentDescription = "Settings icon",
                                    tint = G200
                                )
                                Text(
                                    text = "My Cards",
                                    color = G200
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                .size(70.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_more),
                                    contentDescription = "Settings icon",
                                    tint = P300
                                )
                                Text(
                                    text = "More",
                                    color = P300
                                )
                            }
                        }
                    }
                },
                containerColor = Color.White,
                modifier = modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))

            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(YellowGrad, RedGrad)
                    )
                )
                .padding(innerPadding)
        ) {
            NotificationsList(onSendNotification)
        }
    }

}

@Composable
fun NotificationsList(onSendNotification: () -> Unit,modifier: Modifier = Modifier, viewModel :NotificationViewModel=viewModel()) {
    val notifications by viewModel.notifications.collectAsState(initial = emptyList())
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(notifications.size) { position ->
                NotificationItem(
                    amount = notifications[position].amount,
                    name = notifications[position].toAccountName,
                    account = notifications[position].toAccountNumber,
                    date = notifications[position].transactionDate.substring(0, 10),  // Extract the date
                    time = notifications[position].transactionDate.substring(11, 16)  // Extract the time
                )
                Spacer(modifier = modifier.height(12.dp))
            }
        }
        Button(onClick = {
            onSendNotification()
        }) {
            Text(text = "send notif")

        }
    }
    
}

@Composable
fun NotificationItem(amount: Int,  name:String,  account:String,  date: String,  time:String ,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        )
    ) {
        Spacer(modifier = modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp)
        ) {
            Card(
                modifier = modifier
                    .size(60.dp)
                    .background(color = P50, shape = RoundedCornerShape(10.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            ) {
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxSize()) {
                    Box(
                        modifier = modifier
                            .size(40.dp)
                            .background(color = P75, shape = RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_received),
                            contentDescription = "Bank icon",
                            tint = P300
                        )

                    }
                }
            }
            Spacer(modifier = modifier.width(20.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Sent Transaction",
                    color = G900,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    fontSize = 14.sp
                )
                Spacer(modifier = modifier.height(2.dp))
                Text(
                    text = "You have sent $amount EGP to $name $account",
                    color = G700,
                    fontFamily = FontFamily(Font(R.font.inter_variable)),
                    fontSize = 12.sp
                )
                Spacer(modifier = modifier.height(2.dp))
                Text(
                    text = "$date $time",
                    color = G100,
                    fontFamily = FontFamily(Font(R.font.inter_variable)),
                    fontSize = 12.sp
                )
                Spacer(modifier = modifier.height(8.dp))

            }
        }
        Spacer(modifier = modifier.height(8.dp))

    }
    
}

//@Preview(showSystemUi = false)
//@Composable
//fun NotificationsScreenPreview(modifier: Modifier = Modifier) {
//    NotificationsScreen(rememberNavController())
//
//}