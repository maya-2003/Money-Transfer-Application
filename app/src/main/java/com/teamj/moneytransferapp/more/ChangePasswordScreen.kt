package com.teamj.moneytransferapp.more

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.api.viewmodels.PasswordViewModel
import com.teamj.moneytransferapp.common.TopBar
import com.teamj.moneytransferapp.navigation.Route
import com.teamj.moneytransferapp.ui.theme.FieldStyle
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G10
import com.teamj.moneytransferapp.ui.theme.G70
import com.teamj.moneytransferapp.ui.theme.LabelStyle
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.RedGrad
import com.teamj.moneytransferapp.ui.theme.YellowGrad
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teamj.moneytransferapp.api.model.Password

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopBar(title = "Change Password", route = Route.SETTINGS, navController = navController)
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
            ChangePasswordFields(navController = navController)



        }

    }


}

@Composable
fun ChangePasswordFields(navController: NavController, modifier: Modifier = Modifier, viewModel: PasswordViewModel =viewModel()) {
    val context = LocalContext.current
    var oldPassword by rememberSaveable { mutableStateOf("") }
    var newPassword by rememberSaveable { mutableStateOf("") }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    var isNewPasswordVisible by rememberSaveable { mutableStateOf(false) }
    val icon1 = if (isPasswordVisible)
        R.drawable.ic_visible
    else
        R.drawable.ic_invisible
    val icon2 = if (isNewPasswordVisible)
        R.drawable.ic_visible
    else
        R.drawable.ic_invisible


    var passwordError by rememberSaveable { mutableStateOf(false) }
    var newPasswordError by rememberSaveable { mutableStateOf(false) }
    var passwordPatternError by rememberSaveable { mutableStateOf(false) }




    Box(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxHeight()
                .padding(top = 12.dp, start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState())


        ) {

            Text(
                text = "Current Password",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )


            OutlinedTextField(
                value = oldPassword,
                onValueChange = {
                    oldPassword = it
                    passwordError = false
                },
                label = { Text("Enter your password", style = FieldStyle) },
                trailingIcon = {
                    IconButton(onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }) {
                        Icon(
                            painter = painterResource(id = icon1),
                            contentDescription = "Person Icon",
                            tint = if (passwordError || passwordPatternError) P300 else G70,
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor = if (passwordError || passwordPatternError) P300 else G70,
                    unfocusedBorderColor = if (passwordError || passwordPatternError) P300 else G70,
                    focusedLabelColor = G70,
                )
            )
            if (passwordError) {
                Text(
                    text = "Required field",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    modifier = modifier
                        .align(Alignment.Start),
                    color = P300


                )
            }




            Spacer(modifier = modifier.height(8.dp))


            Text(
                text = "New Password",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )
            OutlinedTextField(
                value = newPassword,
                onValueChange = {
                    newPassword = it
                    newPasswordError = false
                    passwordPatternError = false
                },
                label = { Text("Enter your password", style = FieldStyle) },
                trailingIcon = {
                    IconButton(onClick = {
                        isNewPasswordVisible = !isNewPasswordVisible
                    }) {
                        Icon(
                            painter = painterResource(id = icon2),
                            contentDescription = "Person Icon",
                            tint = if (newPasswordError) P300 else G70,
                        )
                    }
                },
                visualTransformation = if (isNewPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor = if (newPasswordError || passwordPatternError) P300 else G70,
                    unfocusedBorderColor = if (newPasswordError || passwordPatternError) P300 else G70,
                    focusedLabelColor = G70,
                )
            )
            if (newPasswordError) {
                Text(
                    text = "Required field",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    modifier = modifier
                        .align(Alignment.Start),
                    color = P300


                )
            }

            if (passwordPatternError) {
                Text(
                    text = """Password should be 6 characters long with at least one lower case, one uppercase and one special character""",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    modifier = modifier
                        .align(Alignment.Start),
                    color = P300


                )
            }



            Spacer(modifier = modifier.height(38.dp))


            Button(
                onClick = {
                    val validation = validatePasswords(oldPassword, newPassword)
                    when (validation) {
                        0 -> {
                            passwordError = oldPassword.isBlank()
                            newPasswordError = newPassword.isBlank()
                            Toast.makeText(context, "Please fill all fields", Toast.LENGTH_LONG)
                                .show()
                        }


                        1 -> {
                            passwordPatternError = true
                            Toast.makeText(
                                context,
                                "Password pattern is not correct",
                                Toast.LENGTH_LONG
                            ).show()
                        }


                        else -> {
                            viewModel.changePassword(context, Password(oldPassword = oldPassword, newPassword = newPassword))
                            navController.navigate(Route.SETTINGS)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = P300
                ),
            ) {
                Text(
                    text = "Save",
                    color = G0,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )
            }


        }
    }


}


fun validatePasswords(
    password: String,
    passwordConfirm: String,
    modifier: Modifier = Modifier
): Int {
    val pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*(),.?\":{}|<>]).{6,}\$"
    val state =
        if (password.isBlank() || passwordConfirm.isBlank()) 0
        else if (!Regex(pattern).matches(passwordConfirm)) 1
        else 2
    return state
}

@Preview(showSystemUi = false)
@Composable
fun ChangePasswordScreenPreview(modifier: Modifier = Modifier) {
    ChangePasswordScreen(rememberNavController())

}