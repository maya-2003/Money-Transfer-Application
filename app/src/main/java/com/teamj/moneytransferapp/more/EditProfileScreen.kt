package com.teamj.moneytransferapp.more

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.data.DataSource
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.FieldStyle
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G10
import com.teamj.moneytransferapp.ui.theme.G70
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.LabelStyle
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Route.SETTINGS)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back arrow icon"
                        )
                    }
                },
                title = {
                    Text(
                        "Edit Profile",
                        color = G900,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
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
                        colors = listOf(YellowGrad, RedGrad)
                    )
                )
                .padding(innerPadding)
        ) {
            EditProfileFields(navController = navController)

        }

    }


}
@Composable
fun EditProfileFields(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var countryName by rememberSaveable { mutableStateOf("") }
    var dob by rememberSaveable { mutableStateOf("") }


    Box(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxHeight()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState())


        ) {
            Text(
                text = "Full Name",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )


            OutlinedTextField(
                value = fullName,
                onValueChange = {
                    fullName = it
                },
                label = { Text("Enter your Full Name", style = FieldStyle) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor =  G70,
                    unfocusedBorderColor = G70,
                    focusedLabelColor = G70,
                ),
            )


            Spacer(modifier = modifier.height(8.dp))


            Text(
                text = "Email",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("Enter your email address", style = FieldStyle) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor =  G70,
                    unfocusedBorderColor =  G70,
                    focusedLabelColor = G70,
                )


            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = "Country",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )

            CountriesSheet(countrySelected = { country ->
                countryName= context.getString(country)

            }, DataSource().getCountryList())
            Text(
                text = "Date of Birth",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )
            DatePicker(dateSelected = {date ->
                dob = date
            })


            Spacer(modifier = modifier.height(38.dp))


            Button(
                onClick = {
                    navController.navigate(Route.SETTINGS)
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
                    text = "Save",
                    color = G0,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )
            }

        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(dateSelected: (String) -> Unit, modifier: Modifier = Modifier) {
    var showDatePicker by remember { mutableStateOf(false) }
    var dateMillis by remember { mutableStateOf(0L) }
    var selectedDate by remember { mutableStateOf("") }

    if(showDatePicker)
        DateChooser(onConfirm = {
            val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.JAPAN)
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
        label = { Text("DD/MM/YYY", style = FieldStyle) },
        trailingIcon = {
            IconButton(onClick = {
                showDatePicker = !showDatePicker
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_date),
                    contentDescription = "Person Icon",
                    tint = G70
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
            focusedBorderColor = G70,
            unfocusedBorderColor = G70,
            focusedLabelColor = G70,
        ),
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesSheet(countrySelected:  (Int) -> Unit, countries: List<Country>, modifier: Modifier = Modifier) {
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
                            tint = G70
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
                    focusedBorderColor = G70,
                    unfocusedBorderColor = G70,
                    focusedLabelColor = G70
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
fun DateChooser(onConfirm: (DatePickerState) -> Unit, onDismiss: () -> Unit) {
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


@Preview(showSystemUi = false)
@Composable
fun EditProfileScreenPreview(modifier: Modifier = Modifier) {
    EditProfileScreen(rememberNavController())

}