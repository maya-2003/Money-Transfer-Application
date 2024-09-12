package com.teamj.moneytransferapp.transfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import com.teamj.moneytransferapp.model.Contacts
import com.teamj.moneytransferapp.navigation.Route
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teamj.moneytransferapp.api.viewmodels.FavoritesViewModel
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad

@Composable
fun TransferAmountScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar("Transfer", Route.HOME, navController)
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
                Spacer(modifier = modifier.height(20.dp))
                TransferProgress(1)
                Spacer(modifier = modifier.height(20.dp))
                TransferAmountInfo(navController)
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferAmountInfo(navController: NavController, modifier: Modifier=Modifier, viewModel: FavoritesViewModel= viewModel()) {
    var showEditDialog by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val contacts = remember { mutableStateListOf<Contacts>() }
    var showDialog by remember { mutableStateOf(false) }


    var money by remember { mutableStateOf("") }
    var rec_name by remember { mutableStateOf("") }
    var rec_account by remember { mutableStateOf("") }
    val favouriteList by viewModel.favoritesList.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getFavorite()
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        YellowGrad,
                        RedGrad
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)

        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "How much are you sending?",
                modifier = Modifier
                    .padding(bottom = 24.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF24221E),
                    textAlign = TextAlign.Center,
                )
            )

            Box(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 8.dp, top = 16.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth()
                    .height(133.dp),


                )

            {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .padding(start = 12.dp, end = 12.dp)
                        .height(110.dp)

                    ) {
                    Text(
                        text = "Amount",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF3C3A37),

                            )
                    )

                    OutlinedTextField(
                        value = money,
                        onValueChange = { money = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        placeholder = {
                            Text(
                                text = " Enter Amount",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                fontFamily = FontFamily(Font(R.font.inter_variable)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFB0AFAE),


                                )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .border(
                                width = 1.5.dp,
                                color = Color(0xFFB0AFAE),
                                shape = RoundedCornerShape(size = 6.dp)
                            ),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            color = G900,
                            fontFamily = FontFamily(Font(R.font.inter_semi_bold))
                        )
                    )
                }

            }
            Spacer(modifier = Modifier.height(12.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 32.dp)
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Recipient Name",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF3C3A37),
                            textAlign = TextAlign.Start,

                            )
                    )

                    Spacer(modifier = Modifier.width(132.dp))

                    Image(
                        painter = painterResource(id = R.drawable.fav_star),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(1.dp, end = 4.dp)
                            .width(20.dp)
                            .height(20.dp)

                    )
                    Text(
                        text = "Favourite",
                        color = P300,
                        modifier = Modifier
                            .clickable {
                                showEditDialog = true
                            }
                            .width(63.dp)
                            .height(21.dp)
                            .padding(top = 3.dp),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF871E35),

                            textAlign = TextAlign.Center,
                        )
                    )
                    IconButton(onClick = {showEditDialog = true}) {
                        Icon(
                            painter = painterResource(id = R.drawable.fav_arrow),
                            contentDescription = null,
                            tint=P300,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .padding(start = 4.dp)
                        )
                    }


                }

                OutlinedTextField(
                    value = rec_name,
                    onValueChange = { rec_name = it },
                    placeholder = {
                        Text(
                            text = "Enter Recipient Name",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                fontFamily = FontFamily(Font(R.font.inter_variable)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFB0AFAE),

                                )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .border(
                            width = 1.5.dp,
                            color = Color(0xFFB0AFAE),
                            shape = RoundedCornerShape(size = 6.dp)
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Recipient Account",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF3C3A37),
                            textAlign = TextAlign.Start,

                            )
                    )
                }

                OutlinedTextField(
                    value = rec_account,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { rec_account = it },
                    placeholder = {
                        Text(
                            text = "Enter Percipient Account Number",

                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                fontFamily = FontFamily(Font(R.font.inter_variable)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFB0AFAE),

                                )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 1.5.dp,
                            color = Color(0xFFB0AFAE),
                            shape = RoundedCornerShape(size = 6.dp)
                        )


                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    navController.navigate("${Route.TRANSFER_CONFIRM}/$money/$rec_name/$rec_account")
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = P300
                ),
            ) {
                Text(
                    text = "Confirm",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )
            }
Spacer(modifier = modifier.height(16.dp))
            if (showEditDialog) {

                ModalBottomSheet(
                    modifier = Modifier.fillMaxHeight(),
                    sheetState = sheetState,
                    onDismissRequest = { showEditDialog = false }
                ) {

                    favouriteList.forEachIndexed { index, favos ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            FavoritePicker(
                                name = favos.recipientName,
                                account = favos.recipientAccountNumber,
                                onFavoriteClick = {
                                    rec_name = favos.recipientName
                                    rec_account = favos.recipientAccountNumber
                                    showDialog = false
                                }
                            )

                        }
                    }
                }
            }
        }
    }

}

@Composable
fun FavoritePicker(name: String, account: String, onFavoriteClick: () -> Unit, viewModel: FavoritesViewModel = viewModel()) {

    val favouriteList by viewModel.favoritesList.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getFavorite()
    }


    Row(

        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier

            .fillMaxWidth()

            .clickable { onFavoriteClick() }

            .padding(horizontal = 8.dp, vertical = 8.dp)

            .background(

                Color(0xFFF3E9EB), shape = RoundedCornerShape(16.dp)

            )


    ) {

        Row(

            horizontalArrangement = Arrangement.SpaceBetween,

            modifier = Modifier

                .fillMaxWidth()

                .padding(16.dp),


            ) {


            Column(

                modifier = Modifier

                    .padding(5.dp)

            ) {

                Image(

                    painter = painterResource(id = R.drawable.card_logo),

                    contentDescription = null,

                    modifier = Modifier

                        .size(55.dp)

                )

            }


            Spacer(modifier = Modifier.width(8.dp))



            favouriteList.forEachIndexed { index, favos ->


                Column {

                    Text(

                        text = favos.recipientName,

                        fontSize = 16.sp,

                        color = Color.Black,

                        )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(

                        text = "Account xxxx${favos.recipientAccountNumber.takeLast(4)}",

                        fontSize = 16.sp,

                        color = G100

                    )

                }

            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewTransferScreen() {
    TransferAmountScreen(rememberNavController())
}
