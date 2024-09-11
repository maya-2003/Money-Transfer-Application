package com.maya.moneytransferapp

import androidx.lifecycle.viewmodel.compose.viewModel
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.teamj.moneytransferapp.api.viewmodels.FavoritesViewModel
import com.teamj.moneytransferapp.model.FavReq
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteContactsScreen(
    navController: NavController,
    viewModel: FavoritesViewModel = viewModel()
) {
    val favList by viewModel.favoritesList.collectAsState()
    val contacts = remember { mutableStateListOf<Contacts>() }
    var showAddDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedContactIndex by remember { mutableStateOf(-1) }
    var contactName by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    val scaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()

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

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {
                        Text(
                            text = "Favourite",
                            modifier = Modifier
                                .padding(start = 88.dp),
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF24221E),

                                textAlign = TextAlign.Center,
                            )
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.DarkGray
                    ),

                    navigationIcon = {
                        IconButton(
                            onClick = { /* Handle back navigation */ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            },

            content = { innerPadding ->
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
                        .padding(innerPadding)
                ) {

                    var showEditDialog by remember { mutableStateOf(false) }
                    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .background(color = Color.Transparent),

                        ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Transparent),

                            ) {
                            Text(
                                text = "Your favourite list",
//                                Make Bold ,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 10.dp),
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF24221E),

                                    textAlign = TextAlign.Center,
                                )
                            )
                        }

                        favList.forEachIndexed { index, favos ->

                            ContactCard(

                                favos = favos,
                                onEditClick = {
                                    selectedContactIndex = index
                                    contactName = favos.recipientName
                                    accountNumber = favos.recipientAccountNumber
                                    showEditDialog = true
                                    coroutineScope.launch {
                                        scaffoldState.bottomSheetState.expand()
                                    }
                                },

                                onDeleteClick = {
                                    contacts.removeAt(index)
                                },

                                theDel = favos.recipientAccountNumber

                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp, bottom = 4.dp)
                                .height(54.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = P300
                            ),
                            onClick = {
                                selectedContactIndex = -1
                                contactName = ""
                                accountNumber = ""
                                showEditDialog = true
                                coroutineScope.launch {
                                    scaffoldState.bottomSheetState.expand()
                                }
                            })
                        {
                            Text(
                                "Add New Contact",
                            )
                        }

                        if (showEditDialog || showAddDialog) {
                            ModalBottomSheet(
                                modifier = Modifier.fillMaxHeight(),
                                sheetState = sheetState,
                                onDismissRequest = {
                                    showEditDialog = false
                                    showAddDialog = false
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .background(color = Color.Transparent),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier
                                            .background(color = Color.Transparent),
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.edit),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp),
                                        )
                                        if (showEditDialog) {
                                            Text(
                                                text = " Edit",
                                                fontSize = 18.sp,
                                                color = P300
                                            )
                                        } else {
                                            Text(
                                                text = " Add",
                                                fontSize = 18.sp,
                                                color = P300
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = contactName,
                                onValueChange = { contactName = it },
                                label = { Text("Recipient Name") },

                                )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = accountNumber,
                                onValueChange = { accountNumber = it },
                                label = { Text("Recipient Account") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 24.dp, bottom = 4.dp)
                                    .height(54.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = P300
                                ),

                                onClick = {
                                    if (selectedContactIndex >= 0) {

                                        contacts[selectedContactIndex] =
                                            Contacts(contactName, accountNumber)

                                    } else {
                                        contacts.add(
                                            Contacts(
                                                contactName,
                                                accountNumber
                                            )
                                        )
                                    }
                                    showEditDialog = false
                                    coroutineScope.launch {}
                                    viewModel.addFavorite(
                                        FavReq(
                                            contactName,
                                            accountNumber
                                        )
                                    )
                                },
                            )
                            {
                                Text("Save")
                            }
                        }
                    }
                }
            }
        )
    }
}


@Preview(showSystemUi = false, showBackground = false)
@Composable
private fun FavScreenPreview() {
    FavoriteContactsScreen(rememberNavController())
}