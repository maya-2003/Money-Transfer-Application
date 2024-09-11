package com.teamj.moneytransferapp.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.data.UserPrefs
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.P900
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Onboarding(navController: NavController) {
    val context = LocalContext.current

    val pagerState = rememberPagerState(pageCount = { 3 })

    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color.White,
                        P900
                    )
                )
            )
    ) {

    }
    Box(modifier = Modifier.fillMaxSize()) {
        TextButton(
            onClick = {
                navController.navigate(Route.SIGNUP)
                UserPrefs.setUserOnboarding(context)
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Text(
                text = "Skip",
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> OnboardingScreen(
                    imageRes = R.drawable.boarding_amount,
                    title = "Amount",
                    description = "Send money fast with simple steps. Create account, Confirmation, Payment. Simple.",
                    page = 0
                )

                1 -> OnboardingScreen(
                    imageRes = R.drawable.boarding_confirmation,
                    title = "Confirmation",
                    description = "Transfer funds instantly to friends and family worldwide, strong shield protecting money.",
                    page = 1

                )

                2 -> OnboardingScreen(

                    imageRes = R.drawable.boarding_payment,
                    title = "Payment",
                    description = "Enjoy peace of mind with our secure platform. Transfer funds instantly to friends.",
                    page = 2
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 4.dp)
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.P300)),
            shape = RoundedCornerShape(6.dp),
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage < pagerState.pageCount - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        //pagerState.animateScrollToPage(pagerState.currentPage + 0)
                        navController.navigate(Route.SIGNUP)
                        UserPrefs.setUserOnboarding(context)
                    }
                }
            },
        ) {
            Text(
                text = "Next",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.8.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center

                )
            )
        }
    }
}


@Composable
fun OnboardingScreen(imageRes: Int, title: String, description: String, page: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier =
            Modifier
                .size(400.dp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 36.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontWeight = FontWeight(400),
                color = Color(0xFF3C3A37),

                textAlign = TextAlign.Center
            )
        )


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(3) { index ->
                val color =
                    if (page == index) colorResource(id = R.color.P200) else colorResource(id = R.color.P100)
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .padding(2.dp)
                        .background(color, shape = CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = description,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter_variable)),
                fontWeight = FontWeight(400),
                color = Color(0xFF3C3A37),

                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewTryBoarding() {
    Onboarding(rememberNavController())
}
