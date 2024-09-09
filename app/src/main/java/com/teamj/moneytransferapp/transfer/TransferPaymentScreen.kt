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
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.S400
import com.teamj.moneytransferapp.ui.theme.YellowGrad

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferPaymentScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Route.SIGNUP)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back arrow icon"
                        )
                    }
                },
                title = {
                    Text(
                        "Transfer",
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
                                //.size(50.dp)
                                .weight(1f)
                                .clip(RoundedCornerShape(0.dp))
                        ) {
                            Column(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_home),
                                    contentDescription = "home icon",
                                    tint = G200,
                                    modifier = modifier.size(20.dp)
                                )
                                Text(
                                    text = "home",
                                    color = G200,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                //.size(60.dp)
                                .weight(1f)
                                .clip(RoundedCornerShape(0.dp))
                        ) {
                            Column(modifier = Modifier.padding(horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_transfer),
                                    contentDescription = "Settings icon",
                                    tint = P300,
                                    modifier = modifier.size(20.dp)
                                )
                                Text(
                                    text = "Transfer",
                                    color = P300,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                //.size(84.dp)
                                .weight(1.4f)
                                .clip(RoundedCornerShape(0.dp))
                        ) {
                            Column(modifier = Modifier.padding(horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_history),
                                    contentDescription = "Settings icon",
                                    tint = G200,
                                    modifier = modifier.size(20.dp)
                                )
                                Text(
                                    text = "Transactions",
                                    color = G200,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                //.size(60.dp)
                                .weight(1.1f)
                                .clip(RoundedCornerShape(0.dp))
                        ) {
                            Column(modifier = Modifier.padding(horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_cards),
                                    contentDescription = "Settings icon",
                                    tint = G200,
                                    modifier = modifier.size(20.dp)
                                )
                                Text(
                                    text = "My Cards",
                                    color = G200,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier
                                //.size(50.dp)
                                .weight(1f)
                                .clip(RoundedCornerShape(0.dp))
                        ) {
                            Column(modifier = Modifier.padding(horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_more),
                                    contentDescription = "Settings icon",
                                    tint = G200,
                                    modifier = modifier.size(20.dp)

                                )
                                Text(
                                    text = "More",
                                    color = G200,
                                    fontSize = 12.sp
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
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TransferPaymentProgress()
                Spacer(modifier = modifier.height(28.dp))
                TransferPayment()
            }

        }
    }

}

@Composable
fun TransferPaymentProgress(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .border(width = 2.dp, color = P300, shape = RoundedCornerShape(20.dp))
                    .background(color = G0, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "01",
                    color = P300,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            HorizontalDivider(thickness = 2.dp, modifier = modifier.width(100.dp), color = P300)
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .size(40.dp)
                    .border(width = 2.dp, color = P300, shape = RoundedCornerShape(20.dp))
                    .background(color = G0, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "02",
                    color = P300,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            HorizontalDivider(thickness = 2.dp, modifier = modifier.width(100.dp), color = P300)
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .size(40.dp)
                    .border(width = 2.dp, color = P300, shape = RoundedCornerShape(20.dp))
                    .background(color = G0, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "03",
                    color = P300,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
            }
        }
        Spacer(modifier = modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "Amount", fontFamily = FontFamily(Font(R.font.inter_medium)))
            Text(text = "Confirmation", fontFamily = FontFamily(Font(R.font.inter_medium)))
            Text(text = "Payment", fontFamily = FontFamily(Font(R.font.inter_medium)))

        }
    }
}


@Composable
fun TransferPayment(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.check_pink),
            contentDescription = "Check icon",
            modifier = modifier.size(100.dp)
        )
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = "Your transfer was successful",
            color = G900,
            fontSize = 20.sp,

            fontFamily = FontFamily(Font(R.font.inter_bold))
        )

        Spacer(modifier = modifier.height(20.dp))
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
                    painter = painterResource(id = R.drawable.ic_white_check),
                    tint = G0,
                    contentDescription = "Bank icon"
                )

            }

        }
        Spacer(modifier = modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Transfer amount",
                color = G700,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_variable))
            )
            Text(
                text = "1000 EGP",
                color = G700,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.inter_variable))
            )

        }

        Spacer(modifier = modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = modifier.height(16.dp))
        Spacer(modifier = modifier.height(16.dp))
        Button(
            onClick = { },
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
                text = "Back to Home",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
            )
        }
        Spacer(modifier = modifier.height(12.dp))
        Button(
            onClick = { },
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
                text = "Add to Favourite",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
            )
        }
    }
}

@Preview
@Composable
private fun TransferConfirmationScreenPreview() {
    TransferPaymentScreen(rememberNavController())
}