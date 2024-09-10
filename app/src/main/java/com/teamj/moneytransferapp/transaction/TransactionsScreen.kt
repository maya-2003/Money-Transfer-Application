package com.teamj.moneytransferapp.transaction

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.common.NavBottomBar
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Transactions", route = Route.HOME, navController =navController )
        },
        bottomBar = {
            NavBottomBar(state = 3, navController = navController)
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
           TransactionsList()
        }
    }

}

@Composable
fun TransactionsList(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Your Last Transactions",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
            color = G900)
        Spacer(modifier = modifier.height(20.dp))
        TransactionItem()
        Spacer(modifier = modifier.height(12.dp))
    }

}

@Composable
fun TransactionItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp),
        colors = CardDefaults.cardColors(
            containerColor = G0
        )
    ) {
        Spacer(modifier = modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxHeight()
                .padding(horizontal = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.Top,) {
                Box(
                    modifier = modifier
                        .size(60.dp)
                        .background(color = P50, shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bank),
                        contentDescription = "Bank icon",
                        tint = P300,
                        modifier = modifier.size(40.dp)
                    )

                }
                Spacer(modifier = modifier.width(20.dp))
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Ahmed Mohamed",
                        color = G900,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = modifier.height(2.dp))
                    Text(
                        text = "Visa . Mater Card . 1234",
                        color = G700,
                        fontFamily = FontFamily(Font(R.font.inter_variable)),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = modifier.height(2.dp))
                    Text(
                        text = "Today 11:00 - Received",
                        color = G100,
                        fontFamily = FontFamily(Font(R.font.inter_variable)),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = modifier.height(12.dp))


                    Text(
                        text = "$1000",
                        color = P300,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                        fontSize = 16.sp
                    )

                }
                Spacer(modifier = Modifier.weight(0.8f))
                Icon(painter = painterResource(id = R.drawable.ic_right_arrow), contentDescription = "arrow icon",
                    modifier=modifier.size(20.dp),
                    tint = G200)
            }
        }
        Spacer(modifier = modifier.height(8.dp))

    }


}



@Preview(showSystemUi = false)
@Composable
fun NotificationsScreenPreview(modifier: Modifier = Modifier) {
   TransactionsScreen(rememberNavController())

}