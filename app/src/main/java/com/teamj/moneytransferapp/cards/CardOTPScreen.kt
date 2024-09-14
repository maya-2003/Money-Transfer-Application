package com.teamj.moneytransferapp.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPScreenBar(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Banck Card OTP", route = Route.HOME, navController =navController )
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
            OTPScreen(navController)
        }
    }

}

@Composable
fun OTPScreen(navController: NavController, modifier: Modifier = Modifier) {
    val email = "Email@gmail.com"
    var OTP by remember { mutableStateOf("      ") }


    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(16.dp))
        Text(text = "Enter the digits verification code sent to $email",
            color = G700,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            lineHeight = 24.sp)

        Spacer(modifier = Modifier.height(38.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0..5) {
                OTPInputField{ number ->
                    //Check later
                    OTP = OTP.replaceRange(i, i + 1, if (number.isBlank()) " " else number)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        TextButton(onClick = { }) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = G100, fontSize = 16.sp, fontFamily = FontFamily(
                        Font(R.font.inter_medium)))
                    ) {
                        append("Don't receive OTP? ")
                    }

                    withStyle(style = SpanStyle(color = P300, fontFamily = FontFamily(
                        Font(R.font.inter_medium)
                    ), fontSize = 16.sp)
                    ) {
                        append("Resend OTP")
                    }
                }
            )
        }

        Button(
            enabled = if(OTP.filter { it.isDigit() }.length == 6) true else false,
            onClick = { navController.navigate(Route.CARD_ADDED)},
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .offset(y = 200.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = P300,
                disabledContainerColor = G100,
                contentColor = G0,
                disabledContentColor = G40
            ),
        ) {
            Text(text = "Sign on",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
            )
        }
    }
}

@Composable
fun OTPInputField(modifier: Modifier = Modifier, onInput: (String) -> Unit) {
    var digit by remember { mutableStateOf("") }

    OutlinedTextField(
        value = digit,
        onValueChange = { if (it.length <= 1) {
            digit = it
            onInput(it)
        }},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = modifier
            .width(54.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            focusedBorderColor = P300 ,
            unfocusedBorderColor = if(digit.isBlank()) Color.Gray else P300,
        ),
        textStyle = TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = P300,
            fontFamily = FontFamily(Font(R.font.inter_bold))
        )
    )
}


@Preview(showSystemUi = true)
@Composable
private fun OTPScreenBarPreview() {
    OTPScreenBar(rememberNavController())

}