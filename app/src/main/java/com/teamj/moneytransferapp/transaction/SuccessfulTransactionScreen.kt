package com.teamj.moneytransferapp.transaction

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.substring
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.common.NavBottomBar
import com.teamj.moneytransferapp.common.TopBar
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
fun SuccessfulTransactionScreen(amount : Int, recpName : String, recpNumber : String, fromName : String, fromNumber : String, date:String, type:String,navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Successful Transactions", route = Route.LAST_TRANSACTIONS, navController = navController)
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
            TransactionInformation(amount, recpName, recpNumber, fromName, fromNumber, date, type)

        }
    }

}

@Composable
fun TransactionInformation(amount : Int, recpName : String, recpNumber : String, fromName : String, fromNumber : String, date:String, type:String,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.check), contentDescription = "Check image",
            modifier = modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = G900,
                        fontSize = 28.sp,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold))
                    )
                ) {
                    append(amount.toString())
                }

                withStyle(
                    style = SpanStyle(
                        color = P300,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                        fontSize = 28.sp,
                    )
                ) {
                    append(" USD")
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Transfer amount",
            fontSize = 16.sp,
            color = G700,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            modifier = modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "$type money",
            fontSize = 14.sp,
            color = P300,
            fontFamily = FontFamily(Font(R.font.inter_medium))
        )

        Spacer(modifier = modifier.height(20.dp))
        TransactionDetails(amount, recpName, recpNumber, fromName, fromNumber, date, type)

    }

}

@Composable
fun TransactionDetails(amount : Int, recpName : String, recpNumber : String, fromName : String, fromNumber : String ,date:String, type:String, modifier: Modifier = Modifier) {
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
                            modifier = modifier.size(40.dp),
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
                            text = fromName,
                            color = G900,
                            fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                            fontSize = 18.sp
                        )
                        Spacer(modifier = modifier.height(12.dp))
                        Text(
                            text = "Account $fromNumber",
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
                            modifier = modifier.size(40.dp),
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
                            text = recpName,
                            color = G900,
                            fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                            fontSize = 18.sp
                        )
                        Spacer(modifier = modifier.height(12.dp))
                        Text(
                            text = "Account $recpNumber",
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

    Spacer(modifier = modifier.height(20.dp))
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = P50
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {

            Spacer(modifier = modifier.height(16.dp))
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
                    text = amount.toString(),
                    color = G100,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )

            }

            Spacer(modifier = modifier.height(16.dp))
            HorizontalDivider(color = G40)
            Spacer(modifier = modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Reference",
                    color = G700,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )
                Text(
                    text = "123456789876",
                    color = G100,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )


            }

            Spacer(modifier = modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Date",
                    color = G700,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )
                Text(
                    text = "${date.substring(0,10)} ${date.substring(11,16)}",
                    color = G100,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )


            }

        }
    }
    Spacer(modifier = modifier.height(16.dp))

}

@Preview(showSystemUi = true)
@Composable
fun SuccessfulTransactionScreenPreview(modifier: Modifier = Modifier) {
    SuccessfulTransactionScreen(0,"","", "", "","", "",rememberNavController())
}
