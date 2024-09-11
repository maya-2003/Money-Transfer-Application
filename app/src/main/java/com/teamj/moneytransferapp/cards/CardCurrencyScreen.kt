package com.teamj.moneytransferapp.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.data.DataSource
import com.teamj.moneytransferapp.more.Country
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G40
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCountriesScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(Route.HOME)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back arrow icon"
                        )
                    }
                },
                title = {
                    Text(
                        "Select Currency",
                        color = G900,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))

                    )
                },
                actions = {
                    Text(text = "Cancel",
                        modifier = modifier.padding(end = 16.dp))
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

            CardCountryList(navController)

        }
    }

}

@Composable
fun CardCountryList(navController: NavController,modifier: Modifier= Modifier) {
    val countries = DataSource().getCountryList()
    var selectedCountry by remember { mutableStateOf<Country>(countries[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Top
        ) {
            items(countries.size) { position ->
                Spacer(modifier = modifier.height(12.dp))
                CardCountryItem(
                    country = countries[position],
                    countrySelected = countries[position] == selectedCountry,
                    countrySelect = { selectedCountry = countries[position] }
                )
                Spacer(modifier = modifier.height(12.dp))
                HorizontalDivider(thickness = 2.dp, color = G40)
            }
        }

        Button(
            onClick = {
                navController.navigate(Route.ADD_CARD)
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
                text = "Get Started",
                color = G0,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
            )
        }
    }
}

@Composable
fun CardCountryItem(country: Country, countrySelected: Boolean, countrySelect: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { countrySelect() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = country.flag),
            contentDescription = "${country.country} Flag",
            modifier = Modifier.size(30.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(country.country),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter_variable)),
            color = G100
        )

        Spacer(modifier = Modifier.weight(1f))

        if (countrySelected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Selection check",
                tint = P300,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountrySelectionPreview() {
    CardCountriesScreen(rememberNavController())
}