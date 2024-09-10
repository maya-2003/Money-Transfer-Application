package com.teamj.moneytransferapp.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileInformationScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Profile information", route = Route.PROFILE, navController = navController)
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
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
            ProfileInfo(DataSource().getProfileInfoItem())
        }
    }
}

@Composable
fun ProfileInfo(profileInfoItems:List<ProfileInfoItem>, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ){
        Column(modifier = modifier.padding(top=20.dp)){
            LazyColumn {
                items(profileInfoItems.size) { position ->
                    ProfileInfoItem(profileInfoItems[position])
                    HorizontalDivider(thickness = 1.dp,
                        modifier = modifier.padding(horizontal = 10.dp),
                        color = G40
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileInfoItem(profileInfoItem:ProfileInfoItem, modifier: Modifier=Modifier){
    Card(onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Row (modifier = modifier
            .fillMaxWidth()){

            Column( horizontalAlignment = Alignment.Start,
                modifier = modifier.padding(start = 20.dp)) {
                Text(text = stringResource(profileInfoItem.title),
                    modifier = modifier.padding(top = 8.dp),
                    fontSize = 16.sp,
                    color = G900,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight= FontWeight.SemiBold
                )
                Text(text = stringResource(profileInfoItem.info),
                    modifier = modifier.padding(vertical = 8.dp),
                    fontSize = 16.sp,
                    color = G100,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )
            }

        }



    }

}

@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun ProfileInfoPreview() {
    ProfileInformationScreen(rememberNavController())
}