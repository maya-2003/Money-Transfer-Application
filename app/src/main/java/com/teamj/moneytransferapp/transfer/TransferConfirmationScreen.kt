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
import androidx.compose.material3.AlertDialog
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.teamj.moneytransferapp.api.viewmodels.UserDetailsViewModel
import com.teamj.moneytransferapp.api.viewmodels.UserLoginViewModel
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teamj.moneytransferapp.api.model.Transfer
import com.teamj.moneytransferapp.api.model.UserData
import com.teamj.moneytransferapp.api.viewmodels.TransferViewModel
import com.teamj.moneytransferapp.ui.theme.cardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferConfirmationScreen(amount:String, recpName:String, recpNumber:String,navController: NavController, modifier: Modifier = Modifier) {
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
                TransferConfirmation(amount, recpName, recpNumber,navController)
            }

        }
    }

}


@Composable
fun TransferConfirmation(amount:String, recpName:String, recpNumber:String,navController: NavController,modifier: Modifier = Modifier, viewModel: UserDetailsViewModel= viewModel(), transferViewModel: TransferViewModel = viewModel()) {
    val userDetails by viewModel.userDetails.collectAsState()
    val transferSuccess by transferViewModel.transferSuccess.collectAsState()
    var accountName by rememberSaveable { mutableStateOf("name") }
    var accountNumber by rememberSaveable { mutableStateOf("xxx 123") }
    val hasError by transferViewModel.hasError.collectAsState()
    val context = LocalContext.current
    var returnToScreen by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.getUserDetails(context)
    }
    if (userDetails != null){
        val userData = userDetails!!
        accountName = userData.name
        accountNumber = userData.accounts[0].accountNumber
    }
    LaunchedEffect(transferSuccess) {
        if (transferSuccess) {
            navController.navigate("${Route.TRANSFER_PAYMENT}/$amount/$recpName/$recpNumber/$accountName/$accountNumber")
        }
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
                text = "$amount EGP",
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
                text = amount,
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
                                text = accountName,
                                color = G900,
                                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                                fontSize = 18.sp
                            )
                            Spacer(modifier = modifier.height(12.dp))
                            Text(
                                text = "Account $accountNumber",
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
                    painter = painterResource(id = R.drawable.ic_transfer_arrow),
                    tint = G0,
                    contentDescription = "Bank icon"
                )

            }

        }
        LaunchedEffect(hasError) {
            showError = hasError
        }
        if (showError) {
            AlertDialog(
                icon = {
                    Icon(painterResource(id = R.drawable.ic_error), contentDescription = "error Icon")
                },
                title = {
                    Text(text = "Transaction not successful")
                },
                text = {
                    Text(text = "Sorry, your transaction was not successful")
                },
                onDismissRequest = {
                    showError = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showError = false
                            returnToScreen = true
                        }
                    ) {
                        Text("Dismiss")
                    }
                },
            )
        }
        LaunchedEffect(returnToScreen) {
            if (returnToScreen) {
                navController.navigate(Route.TRANSFER_PH1)
                returnToScreen = false
            }
        }
        Spacer(modifier = modifier.height(50.dp))
        Button(
            onClick = {
                transferViewModel.transferMoney(Transfer(recpNumber,amount.toInt(),recpName) )
            },
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
    TransferConfirmationScreen("100","FN","xxx123",rememberNavController())
}