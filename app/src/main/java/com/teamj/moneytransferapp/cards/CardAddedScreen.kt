package com.teamj.moneytransferapp.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardAddedScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Banck Card OTP", route = Route.HOME, navController = navController)
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(G0, P900)
                    )
                )
                .padding(innerPadding)
        ) {
            CardConnectionInfo(navController)
        }
    }

}

@Composable
fun CardConnectionInfo(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        Spacer(modifier = modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.check),
            contentDescription = "Succesful connection image",
            modifier = modifier.size(124.dp)
        )

        Spacer(modifier = modifier.height(28.dp))

        Text(
            textAlign = TextAlign.Center,
            text = """Account Connected 
                |Successfully!""".trimMargin(),
            color = G900,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold))
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(text = """Feel free to connect another account
            |at the same time.""".trimMargin(),
            color = G700,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp)

        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .offset(y = 200.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = P300,
                    disabledContainerColor = G100,
                    contentColor = G0,
                    disabledContentColor = G40
                ),
            ) {
                Text(text = "Connect another account",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )
            }
            Spacer(modifier = modifier.height(12.dp))
            Button(
                onClick = { navController.navigate(Route.HOME)},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .offset(y = 200.dp)
                    .border(
                        BorderStroke(2.dp, P300),
                        RoundedCornerShape(8.dp)
                    ),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = P300,
                ),
            ) {
                Text(text = "Back to home",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )
            }

        }
    }


}

@Preview(showSystemUi = true)
@Composable
private fun CardConnectionScreenPreview(modifier: Modifier = Modifier) {
    CardAddedScreen(rememberNavController())
}