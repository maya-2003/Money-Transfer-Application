package com.teamj.moneytransferapp.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.ui.theme.P300


@Composable
fun ChangePasswordScreen(navController: NavController, modifier: Modifier = Modifier) {


    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    var newPassword by remember { mutableStateOf("") }
    var newPasswordVisual by remember { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFEF0EA))
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Change Password",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(

            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)

        ) {
            Column {
                Text(text = "Current Password", fontSize = 16.sp)

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth().background(Color.White),
                    placeholder = { Text(text = "Enter your password") },

                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            val icon =
                                if (!passwordVisibility) Image(
                                    painter = painterResource(id = R.drawable.ic_invisible),
                                    contentDescription =null )
                                else
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_visible),
                                        contentDescription = null
                                    )

                        }
                    }
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))

            Column {
                Text(text = "New Password", fontSize = 16.sp)

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFFFFF)),
                    placeholder = { Text(text = "Enter your password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (newPasswordVisual) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { newPasswordVisual = !newPasswordVisual }) {
                            val icon =
                                if (!newPasswordVisual) Image(
                                    painter = painterResource(id = R.drawable.ic_invisible),
                                    contentDescription =null )
                                else
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_visible),
                                        contentDescription = null
                                    )

                        }
                    }
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .size(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = P300)
            )
            {
                Text(text = "Save", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    ChangePasswordScreen(navController = rememberNavController())
}

