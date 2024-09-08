package com.teamj.moneytransferapp.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.FieldStyle
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G10
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.LabelStyle
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardScreen(navController: NavController,modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(Route.SIGNUP)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back arrow icon"
                        )
                    }
                },
                title = {
                    Text(
                        "Add Card",
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
            CardInfo(navController)
        }
    }

}

@Composable
fun CardInfo(navController: NavController, modifier: Modifier = Modifier) {
    var cardholder by remember { mutableStateOf("") }
    var cardNo by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)

    ) {
        Text(text = """Sign on your Speedo Transfer 
            |Account""".trimMargin(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = G900)

        Spacer(modifier = modifier.height(40.dp))

        Text(text = "Cardholder Name",
            style = LabelStyle,
            modifier= modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp, top = 8.dp),
        )

        OutlinedTextField(
            value = cardholder,
            onValueChange = { cardholder = it },
            label = { Text("Enter Cardholder Name", style = FieldStyle) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = G10,
                unfocusedContainerColor = G10,
                disabledContainerColor = G10,
                errorContainerColor = G10,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Gray,
            ),
        )

        Spacer(modifier = modifier.height(4.dp))
        Text(text = "Card No",
            style = LabelStyle,
            modifier= modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp, top = 8.dp),
        )

        OutlinedTextField(
            value = cardNo,
            onValueChange = { cardNo = it },
            label = { Text("Card NO", style = FieldStyle) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = G10,
                unfocusedContainerColor = G10,
                disabledContainerColor = G10,
                errorContainerColor = G10,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Gray,
            ),
        )

        Spacer(modifier = modifier.height(4.dp))

        Row{
            Column (modifier=modifier.weight(0.5f)){
                Text(text = "MM/YY",
                    style = LabelStyle,
                    modifier= modifier
                        .align(Alignment.Start)
                        .padding(bottom = 8.dp, top = 8.dp),
                )

                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    label = { Text("MM/YY", style = FieldStyle) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = G10,
                        unfocusedContainerColor = G10,
                        disabledContainerColor = G10,
                        errorContainerColor = G10,
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                    ),
                )
            }
            Spacer(modifier = modifier.width(12.dp))

            Column (modifier=modifier.weight(0.5f)){
                Text(text = "CVV",
                    style = LabelStyle,
                    modifier= modifier
                        .align(Alignment.Start)
                        .padding(bottom = 8.dp, top = 8.dp),
                )

                OutlinedTextField(
                    value = cvv,
                    onValueChange = { cvv = it },
                    label = { Text("CVV", style = FieldStyle) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = G10,
                        unfocusedContainerColor = G10,
                        disabledContainerColor = G10,
                        errorContainerColor = G10,
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                    ),
                )
            }

        }
        Spacer(modifier = modifier.height(12.dp))
        Button(
            onClick = { navController.navigate(Route.CARD_SPLASH) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 4.dp)
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = P300
            ),
        ) {
            Text(text = "Sign on",
                color = G0,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)))
        }

    }



}
@Preview
@Composable
fun AddCardScreenPreview() {
    AddCardScreen(rememberNavController())
}
