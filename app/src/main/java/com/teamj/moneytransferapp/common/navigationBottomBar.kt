package com.teamj.moneytransferapp.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.P300

@Composable
fun navBottomBar(state:Int,navController: NavController, modifier: Modifier=Modifier){
    BottomAppBar(
        actions = {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                    //navController.navigate()
                         },
                    modifier = modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(0.dp))
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "Home icon",
                            tint = if(state == 1)P300 else G200,
                            modifier = modifier.size(20.dp)
                        )
                        Text(
                            text = "Home",
                            color = if(state == 1)P300 else G200,
                            fontSize = 12.sp
                        )
                    }
                }
                IconButton(
                    onClick = {
                        navController.navigate(Route.TRANSFER_PH1)
                    },
                    modifier = modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(0.dp))
                ) {
                    Column(modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_transfer),
                            contentDescription = "Transfer icon",
                            tint = if(state == 2)P300 else G200,
                            modifier = modifier.size(20.dp)
                        )
                        Text(
                            text = "Transfer",
                            color = if(state == 2)P300 else G200,
                            fontSize = 12.sp
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate(Route.LAST_TRANSACTIONS) },
                    modifier = modifier
                        .weight(1.4f)
                        .clip(RoundedCornerShape(0.dp))
                ) {
                    Column(modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_history),
                            contentDescription = "Transactions icon",
                            tint = if(state == 3)P300 else G200,
                            modifier = modifier.size(20.dp)
                        )
                        Text(
                            text = "Transactions",
                            color = if(state == 3)P300 else G200,
                            fontSize = 12.sp
                        )
                    }
                }
                IconButton(
                    onClick = { },
                    modifier = modifier
                        .weight(1.1f)
                        .clip(RoundedCornerShape(0.dp))
                ) {
                    Column(modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cards),
                            contentDescription = "Cards icon",
                            tint = if(state == 4)P300 else G200,
                            modifier = modifier.size(20.dp)
                        )
                        Text(
                            text = "My Cards",
                            color = if(state == 4)P300 else G200,
                            fontSize = 12.sp
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate(Route.MORE)  },
                    modifier = modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(0.dp))
                ) {
                    Column(modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_more),
                            contentDescription = "More icon",
                            tint = if(state == 5)P300 else G200,
                            modifier = modifier.size(20.dp)

                        )
                        Text(
                            text = "More",
                            color = if(state == 5)P300 else G200,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        },
        containerColor = Color.White,
        modifier = modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))

    )
}