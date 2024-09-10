package com.teamj.moneytransferapp.more

import android.content.Intent
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.common.NavBottomBar
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.data.DataSource
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G200
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController, modifier: Modifier = Modifier) {
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopBar(title = "More", route = Route.HOME, navController = navController)
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
                        colors = listOf(YellowGrad, RedGrad)
                    )
                )
                .padding(innerPadding)
        ) {
            Column {
                MoreOptions(
                    navController,
                    DataSource().getMoreOptions(),
                    onHelpClick = { showBottomSheet = true })
            }
            if (showBottomSheet) {
                HelpBottomSheet(onDismiss = { showBottomSheet = false })
            }


        }
    }

}

@Composable
fun MoreOptions(
    navController: NavController,
    moreItems: List<MoreItem>,
    onHelpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
        ) {
            items(moreItems.size) { position ->
                val item = moreItems[position]
                val onItemClick = if (item.text == R.string.help) {
                    { onHelpClick() }
                } else {
                    { navController.navigate(item.route) }
                }
                MoreListItem(navController, onItemClick, item)
                HorizontalDivider(
                    thickness = 1.dp,
                    modifier = modifier.padding(vertical = 8.dp),
                    color = G40
                )
            }
        }

    }

}


@Composable
fun MoreListItem(
    navController: NavController,
    onItemClick: () -> Unit,
    moreItem: MoreItem,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(moreItem.icon),
            contentDescription = "Back arrow icon",
            tint = G200,
            modifier = modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(id = moreItem.text),
            color = G200,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { onItemClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "Right arrow icon",
                tint = G200
            )

        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpBottomSheet(onDismiss: () -> Unit, modifier: Modifier = Modifier) {
    val context= LocalContext.current
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    ModalBottomSheet(
        modifier = Modifier.height(300.dp),
        containerColor = G0,
        sheetState = sheetState,
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Row(modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Card(
                modifier = modifier
                    .width(120.dp)
                    .height(140.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = G0,
                ),
                onClick = {
                    val i = Intent(Intent.ACTION_SENDTO, "mailto:".toUri())
                    context.startActivity(i)
                }

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Box(
                        modifier = modifier
                            .size(55.dp)
                            .background(color = P50, shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "Bank icon",
                            tint = P300,
                            modifier = modifier.size(25.dp)
                        )

                    }
                    Spacer(modifier = modifier.height(8.dp))
                    Text(
                        text = "Send Email",
                        color = G900,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold))
                    )
                }

            }

            Spacer(modifier = modifier.width(40.dp))
            Card(
                modifier = modifier
                    .width(120.dp)
                    .height(140.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = G0
                ),
                onClick = {
                    val i = Intent(Intent.ACTION_DIAL, "tel:000000".toUri())
                    context.startActivity(i)
                }

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Box(
                        modifier = modifier
                            .size(55.dp)
                            .background(color = P50, shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_call),
                            contentDescription = "Bank icon",
                            tint = P300,
                            modifier = modifier.size(25.dp)
                        )

                    }
                    Spacer(modifier = modifier.height(8.dp))
                    Text(
                        text = "Call Us",
                        color = G900,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_semi_bold))
                    )
                    Text(
                        text = "000000",
                        color = P300,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))
                    )
                }

            }

        }
    }

}

@Preview(showSystemUi = false)
@Composable
fun MoreScreenPreview(modifier: Modifier = Modifier) {
    MoreScreen(rememberNavController())

}