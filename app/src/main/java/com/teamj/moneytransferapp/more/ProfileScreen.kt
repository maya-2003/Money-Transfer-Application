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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teamj.moneytransferapp.api.viewmodels.UserDetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
            Scaffold(
                topBar = {
                    TopBar(title = "Profile", route = Route.MORE, navController = navController)
                },
                bottomBar = {
                    NavBottomBar(state = 5, navController = navController)
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
                    ProfileItems(navController, DataSource().getProfileItemsList())
                }
            }
}

@Composable
fun ProfileItems(navController: NavController,profileItems:List<ProfileItem>,modifier: Modifier = Modifier,userViewModel : UserDetailsViewModel = viewModel() ){

    val context = LocalContext.current
    val userDetails by userViewModel.userDetails.collectAsState()
    var accountName by rememberSaveable { mutableStateOf("name") }
    var accountInitials by rememberSaveable { mutableStateOf("AB") }
    LaunchedEffect(Unit) {
        userViewModel.getUserDetails(context)
    }
    if (userDetails != null){
        val userData = userDetails!!
        accountName = userData.name
    }
    accountInitials=Regex("\\b\\w").findAll(accountName)
        .joinToString("") { it.value.uppercase() }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ){
        Column{
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
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
                Text(
                    text = accountName,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                    fontWeight = FontWeight.Black,
                    color= G900
                )

            }
            LazyColumn {
                items(profileItems.size) { position ->
                    ProfileListItem(navController,profileItems[position])
                    HorizontalDivider(thickness = 1.dp,
                        modifier = modifier.padding(horizontal = 16.dp),
                        color = G40)
                }
            }

        }
    }

}

@Composable
fun ProfileListItem(navController: NavController,profileItem:ProfileItem, modifier: Modifier=Modifier){
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
                    painter = painterResource(id = profileItem.icon),
                    contentDescription = "Back arrow icon",
                    tint = P300
                )
            }

            Column( horizontalAlignment = Alignment.Start,
                modifier = modifier.padding(start = 30.dp)) {
                Text(text = stringResource(profileItem.title),
                    fontSize = 16.sp,
                    color = G900,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight=FontWeight.SemiBold
                )
                Text(text = stringResource(profileItem.description),
                    fontSize = 16.sp,
                    color = G100,
                    fontFamily = FontFamily(Font(R.font.inter_variable))
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navController.navigate(profileItem.destination) },) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "Right arrow icon",
                    tint = G200
                )

            }

        }



    }

}


@Preview(showBackground = true)
@Composable
private  fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}