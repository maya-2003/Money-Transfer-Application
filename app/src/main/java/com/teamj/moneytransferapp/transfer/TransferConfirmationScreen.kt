package com.teamj.moneytransferapp.transfer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.teamj.moneytransferapp.common.NavBottomBar
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.common.TransferProgress
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.GrayProgress
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.S400
import com.teamj.moneytransferapp.ui.theme.YellowGrad
import com.teamj.moneytransferapp.ui.theme.cardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferConfirmationScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar("Transfer", Route.HOME,navController)
        },
        bottomBar = {
            NavBottomBar(state = 2, navController = navController)
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
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TransferProgress(2)
                Spacer(modifier = modifier.height(28.dp))
                TransferConfirmation(navController)
            }

        }
    }

}


@Composable
fun TransferConfirmation(navController: NavController,modifier: Modifier = Modifier) {
    var amount by remember { mutableStateOf(100) }
    var currency by remember {
        mutableStateOf("USD")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "$amount $currency",
                color = G900,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold))
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = "Transfer amount",
                color = G700,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.inter_variable))
            )

        }

        Spacer(modifier = modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Total amount",
                color = G900,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold))
            )
            Text(
                text = "48.555",
                color = G700,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.inter_variable))
            )

        }

        Spacer(modifier = modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = modifier.height(16.dp))

        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = P50
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
                        Box(
                            modifier = modifier
                                .size(60.dp)
                                .background(color = G40, shape = RoundedCornerShape(30.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_bank),
                                contentDescription = "Bank icon",
                                modifier=modifier.size(40.dp),
                                tint = G700
                            )

                        }
                        Spacer(modifier = modifier.width(20.dp))
                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "From",
                                color = P300,
                                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                                fontSize = 16.sp
                            )
                            Spacer(modifier = modifier.height(12.dp))
                            Text(
                                text = "Asmaa Dosouky",
                                color = G900,
                                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                                fontSize = 18.sp
                            )
                            Spacer(modifier = modifier.height(12.dp))
                            Text(
                                text = "Account xxxx7890",
                                color = G700,
                                fontFamily = FontFamily(Font(R.font.inter_variable)),
                                fontSize = 16.sp
                            )

                        }
                    }
                    Spacer(modifier = modifier.height(8.dp))

                }
                Spacer(modifier = modifier.height(12.dp))

                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = P50
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
                        Box(
                            modifier = modifier
                                .size(60.dp)
                                .background(color = G40, shape = RoundedCornerShape(30.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_bank),
                                contentDescription = "Bank icon",
                                modifier=modifier.size(40.dp),
                                tint = G700
                            )

                        }
                        Spacer(modifier = modifier.width(20.dp))
                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "To",
                                color = P300,
                                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                                fontSize = 16.sp
                            )
                            Spacer(modifier = modifier.height(12.dp))
                            Text(
                                text = "Jhon Smith",
                                color = G900,
                                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                                fontSize = 18.sp
                            )
                            Spacer(modifier = modifier.height(12.dp))
                            Text(
                                text = "Account xxxx7890",
                                color = G700,
                                fontFamily = FontFamily(Font(R.font.inter_variable)),
                                fontSize = 16.sp
                            )

                        }
                    }

                    Spacer(modifier = modifier.height(8.dp))

                }


            }
            Box(
                modifier = modifier
                    .size(50.dp)
                    .background(color = S400, shape = RoundedCornerShape(25.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_transfer_arrow),
                    tint = G0,
                    contentDescription = "Bank icon"
                )

            }

        }
        Spacer(modifier = modifier.height(50.dp))
        Button(
            onClick = {navController.navigate(Route.TRANSFER_PAYMENT)},
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = P300,
                disabledContainerColor = G100,
                contentColor = G0,
                disabledContentColor = G40
            ),
        ) {
            Text(
                text = "Confirm",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
            )
        }
        Spacer(modifier = modifier.height(12.dp))
        Button(
            onClick = { navController.navigate(Route.TRANSFER_PH1)},
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
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
            Text(
                text = "Previous",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
            )
        }
    }


}

@Preview
@Composable
private fun TransferConfirmationScreenPreview() {
    TransferConfirmationScreen(rememberNavController())
}