package com.teamj.moneytransferapp.signup

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.data.DataSource
import com.teamj.moneytransferapp.more.Country
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.FieldStyle
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G10
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.LabelStyle
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teamj.moneytransferapp.api.model.User
import com.teamj.moneytransferapp.api.viewmodels.UserRegisterViewModel
import java.util.Locale
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompleteProfileScreen(name: String, email: String, password: String,navController: NavController, modifier: Modifier=Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(Route.SIGNUP)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back arrow icon"
                        )
                    }
                },
                title = {
                    Text(
                        "",
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =  Color.Transparent,
                    titleContentColor = Color.DarkGray
                ),
            )
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
            CountryPicker(name, email, password,navController)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPicker(name: String, email: String, password: String,navController: NavController, modifier: Modifier = Modifier, viewModel: UserRegisterViewModel =viewModel()) {
    val context = LocalContext.current
    var countryName by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(0.9f)


        ) {
            Text(
                text = "Speedo Transfer",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontWeight = FontWeight.Bold,
                color = G900,
                modifier = modifier.padding(vertical = 40.dp)
            )


            Text(
                text = "Welcome to Banque Misr!",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                color = G900,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(bottom = 20.dp)
            )


            Text(
                text = "Let's Complete your Profile",
                fontSize = 16.sp,
                color = G700,
                fontFamily = FontFamily(Font(R.font.inter_variable)),
                modifier = modifier.padding(bottom = 28.dp)
            )


            Text(
                text = "Country",
                style = LabelStyle,
                modifier = modifier.align(Alignment.Start),
            )


            CountriesBottomSheet(countrySelected = { country ->
                countryName= context.getString(country)


            }, DataSource().getCountryList())
            Text(
                text = "Date of Birth",
                style = LabelStyle,
                modifier = modifier.align(Alignment.Start),
            )
            DateOfBirthPicker(dateSelected = {date ->
                dob = date
            })
            Button(
                onClick = {
                    viewModel.registerUser(
                        User(name = name,
                        country = countryName,
                        email = email,
                        password = password,
                        dateOfBirth = dob))
                    navController.navigate(Route.LOGIN)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 4.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = P300
                ),
            ) {
                Text(text = "Continue",
                    color = G0,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)))
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Already have an account? ",
                    color = G100,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    modifier = modifier
                        .padding(top = 15.dp)
                )

                TextButton(onClick = {navController.navigate(Route.LOGIN)}) {
                    Text(
                        text = "Sign In",
                        color = P300,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 16.sp
                    )
                }
            }




        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateOfBirthPicker(dateSelected: (String) -> Unit, modifier: Modifier = Modifier) {
    var showDatePicker by remember { mutableStateOf(false) }
    var dateMillis by remember { mutableStateOf(0L) }
    var selectedDate by remember { mutableStateOf("") }


    if(showDatePicker)
        DatePickerChooser(onConfirm = {
            val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN)
            dateMillis = it.selectedDateMillis!!
            selectedDate= dateFormatter.format(dateMillis)
            dateSelected(selectedDate)
            showDatePicker=false
        }) {
            showDatePicker=false
        }


    OutlinedTextField(
        value = selectedDate,
        onValueChange = { },
        readOnly = true,
        label = { Text("YYYY-MM-DD", style = FieldStyle) },
        trailingIcon = {
            IconButton(onClick = {
                showDatePicker = !showDatePicker
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_date),
                    contentDescription = "Person Icon",
                    tint = Color.Gray
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = G10,
            unfocusedContainerColor = G10,
            disabledContainerColor = G10,
            errorContainerColor = G10,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = Color.Gray,
        ),
    )


}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesBottomSheet(countrySelected:  (Int) -> Unit, countries: List<Country>, modifier: Modifier = Modifier) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    var selectedCountry by remember { mutableStateOf(R.string.egypt) }
    var countryName by remember { mutableStateOf(R.string.country_initial) }


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            OutlinedTextField(
                value = stringResource(countryName),
                onValueChange = {  },
                label = { Text("Select your country", color = Color.Gray) },
                trailingIcon = {
                    IconButton(onClick = { showBottomSheet = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Dropdown Icon",
                            tint = Color.Gray
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                readOnly = true,
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { showBottomSheet = true }
                    .padding(bottom = 12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray
                )
            )


            if (showBottomSheet) {
                ModalBottomSheet(
                    modifier = Modifier.fillMaxHeight(),
                    sheetState = sheetState,
                    onDismissRequest = {
                        showBottomSheet = false
                        countryName = selectedCountry
                        countrySelected(selectedCountry)
                    }
                ) {
                    LazyColumn(modifier = Modifier.padding(16.dp)) {
                        items(countries.size) { position ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedCountry = countries[position].country
                                    }
                                    .padding(vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = countries[position].flag),
                                    contentDescription = "country",
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = stringResource(id = countries[position].country), fontSize = 18.sp)
                                Spacer(modifier = Modifier.weight(1f))
                                if (selectedCountry == countries[position].country) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_check),
                                        contentDescription = null,
                                        tint = P300
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerChooser(onConfirm: (DatePickerState) -> Unit, onDismiss: () -> Unit) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = {  },
        confirmButton = {
            TextButton(onClick = { onConfirm(datePickerState) }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) { Text(text = "Cancel") }


        },) {
        DatePicker(state = datePickerState)


    }
}


@Preview(showSystemUi = true)
@Composable
fun CountryPickerScreenPreview() {
    CompleteProfileScreen("","","",rememberNavController())
}
