package com.teamj.moneytransferapp.home

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.common.NavBottomBar
import com.teamj.moneytransferapp.data.DataSource
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teamj.moneytransferapp.api.model.Transaction
import com.teamj.moneytransferapp.api.viewmodels.TransactionsViewModel
import com.teamj.moneytransferapp.api.viewmodels.UserDetailsViewModel
import com.teamj.moneytransferapp.transaction.TransactionItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            NavBottomBar(state = 1, navController = navController)
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
            HomeItems()



        }
    }
}

@Composable
fun HomeItems(modifier: Modifier = Modifier, userViewModel : UserDetailsViewModel= viewModel(), transViewModel: TransactionsViewModel = viewModel()) {

    val context = LocalContext.current
    val transactions by transViewModel.transactions.collectAsState(initial = emptyList())
    val userDetails by userViewModel.userDetails.collectAsState()
    var accountName by rememberSaveable { mutableStateOf("name") }
    var accountBalance by rememberSaveable { mutableStateOf(0) }
    var accountInitials by rememberSaveable { mutableStateOf("AB") }
    LaunchedEffect(Unit) {
        transViewModel.getTransactions(context)
        userViewModel.getUserDetails(context)
    }
    if (userDetails != null){
        val userData = userDetails!!
        accountName = userData.name
        accountBalance = userData.accounts[0].balance
    }
    accountInitials=Regex("\\b\\w").findAll(accountName)
        .joinToString("") { it.value.uppercase() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(YellowGrad, RedGrad)))
    ) {
        Spacer(modifier = modifier.height(16.dp))

        Column(modifier = modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {

                Row {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(G40)
                    ) {
                        Text(
                            text = accountInitials,
                            color = G100,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))

                    Column(verticalArrangement = Arrangement.SpaceAround,
                        modifier = modifier.fillMaxHeight()) {
                        Text(
                            text = "Welcome back, ",
                            color = P300,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.inter_variable))
                        )
                        Text(
                            text = accountName,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            color = G900
                        )
                    }

                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ },
                    modifier=modifier.size(25.dp)) {
                    Icon(painter = painterResource(id = R.drawable.ic_notifications), contentDescription = "notifications icon")
                    
                }


            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = P300)
                    .height(124.dp)
                    .padding(16.dp)

            ) {
                Column(verticalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxHeight()) {
                    Text(text = "Current Balance",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        color = G0)
                    Spacer(modifier = modifier.height(12.dp))
                    Text(text = accountBalance.toString(),
                        fontSize = 28.sp,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                        color = G0)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Recent transactions",
                    color = G900,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
                Text(
                    text = "View all",
                    color = G200,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )

            }

            Spacer(modifier = Modifier.height(16.dp))
            
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .padding(1.dp)
            ) {
                items(transactions.size) { position ->
                    val transactionType = if (userDetails!!.accounts[0].accountNumber == transactions[position].toAccountNumber) "Received"
                    else "Sent"
                    TransactionCard(transactions[position], transactionType)
                    HorizontalDivider(thickness = 1.dp, color = G40)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}
