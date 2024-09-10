package com.teamj.moneytransferapp.common

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String, route:String, navController:NavController,modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(route)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Back arrow icon"
                )
            }
        },
        title = {
            Text(
                title,
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

}