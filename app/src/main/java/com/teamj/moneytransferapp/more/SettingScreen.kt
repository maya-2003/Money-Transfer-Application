package com.teamj.moneytransferapp.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.data.DataSource
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Settings", route = Route.PROFILE, navController =navController )
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
            SettingsList(settingsList = DataSource().getSettings(), navController = navController)



        }

    }


}

@Composable
fun SettingsList(settingsList:List<SettingsItem>,navController: NavController,modifier: Modifier = Modifier) {
    LazyColumn {
        items(settingsList.size) { position ->
            SettingsListItem(navController,settingsList[position])
            HorizontalDivider(thickness = 1.dp,
                modifier = modifier.padding(horizontal = 16.dp),
                color = G40
            )
        }
    }

    
}

@Composable
fun SettingsListItem(navController: NavController, settingsItem: SettingsItem, modifier: Modifier=Modifier){
    Card(onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Row (modifier = modifier
            .fillMaxWidth()){
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(P50)
            ) {
                Icon(
                    painter = painterResource(id = settingsItem.icon),
                    contentDescription = "Back arrow icon",
                    tint = P300
                )
            }

            Column( horizontalAlignment = Alignment.Start,
                modifier = modifier.padding(start = 30.dp)) {
                Text(text = stringResource(settingsItem.heading),
                    fontSize = 16.sp,
                    color = G900,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight= FontWeight.SemiBold
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(text = stringResource(settingsItem.subHeading),
                    fontSize = 16.sp,
                    color = G100,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navController.navigate(settingsItem.route) },) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "Right arrow icon",
                    tint = G200
                )

            }

        }



    }

}

@Preview(showSystemUi = false)
@Composable
fun SettingsScreenPreview(modifier: Modifier = Modifier) {
    SettingsScreen(rememberNavController())

}