package com.teamj.moneytransferapp.signup


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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
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
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.LabelStyle
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900


@Composable
fun SignupScreen(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    var isConfirmPasswordVisible by rememberSaveable { mutableStateOf(false) }
    val icon1 = if (isPasswordVisible)
        R.drawable.ic_visible
    else
        R.drawable.ic_invisible
    val icon2 = if (isConfirmPasswordVisible)
        R.drawable.ic_visible
    else
        R.drawable.ic_invisible


    var fullNameError by rememberSaveable { mutableStateOf(false) }
    var emailError by rememberSaveable { mutableStateOf(false) }
    var passwordError by rememberSaveable { mutableStateOf(false) }
    var confirmPasswordError by rememberSaveable { mutableStateOf(false) }
    var passwordPatternError by rememberSaveable { mutableStateOf(false) }
    var passwordmatchError by rememberSaveable { mutableStateOf(false) }




    Box(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(brush = Brush.verticalGradient(colors = listOf(G0, P900))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxHeight()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState())


        ) {
            Spacer(modifier = modifier.height(28.dp))
            Text(
                text = "Sign Up",
                fontSize = 20.sp,
                color = G900,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
            )


            Spacer(modifier = modifier.height(28.dp))


            Text(
                text = "Speedo Transfer",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = G900,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
            )


            Spacer(modifier = modifier.height(40.dp))




            Text(
                text = "Full Name",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )


            OutlinedTextField(
                value = fullName,
                onValueChange = {
                    fullName = it
                    fullNameError = false
                },
                label = { Text("Enter your Full Name", style = FieldStyle) },
                trailingIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "Person Icon",
                            tint = if (fullNameError) P300 else Color.Gray,
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor = if (fullNameError) P300 else Color.Gray,
                    unfocusedBorderColor = if (fullNameError) P300 else Color.Gray,
                    focusedLabelColor = Color.Gray,
                ),
            )
            if (fullNameError) {
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
                text = "Email",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = false
                },
                label = { Text("Enter your email address", style = FieldStyle) },
                trailingIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "Person Icon",
                            tint = if (emailError) P300 else Color.Gray,
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor = if (emailError) P300 else Color.Gray,
                    unfocusedBorderColor = if (emailError) P300 else Color.Gray,
                    focusedLabelColor = Color.Gray,
                )


            )


            if (emailError) {
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
                text = "Password",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )


            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = false
                    passwordPatternError = false
                },
                label = { Text("Enter your password", style = FieldStyle) },
                trailingIcon = {
                    IconButton(onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }) {
                        Icon(
                            painter = painterResource(id = icon1),
                            contentDescription = "Person Icon",
                            tint = if (passwordError || passwordPatternError) P300 else Color.Gray,
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
                    focusedBorderColor = if (passwordError || passwordPatternError) P300 else Color.Gray,
                    unfocusedBorderColor = if (passwordError || passwordPatternError) P300 else Color.Gray,
                    focusedLabelColor = Color.Gray,
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




            Spacer(modifier = modifier.height(8.dp))


            Text(
                text = "Confirm password",
                style = LabelStyle,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, top = 8.dp),
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    confirmPasswordError = false
                    passwordmatchError = false
                },
                label = { Text("Enter your password", style = FieldStyle) },
                trailingIcon = {
                    IconButton(onClick = {
                        isConfirmPasswordVisible = !isConfirmPasswordVisible
                    }) {
                        Icon(
                            painter = painterResource(id = icon2),
                            contentDescription = "Person Icon",
                            tint = if (confirmPasswordError || passwordmatchError) P300 else Color.Gray,
                        )
                    }
                },
                visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = modifier
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = G10,
                    focusedBorderColor = if (confirmPasswordError || passwordmatchError) P300 else Color.Gray,
                    unfocusedBorderColor = if (confirmPasswordError || passwordmatchError) P300 else Color.Gray,
                    focusedLabelColor = Color.Gray,
                )
            )
            if (confirmPasswordError) {
                Text(
                    text = "Required field",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    modifier = modifier
                        .align(Alignment.Start),
                    color = P300


                )
            }


            if (passwordmatchError) {
                Text(
                    text = "Passwords don't match",
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
                    val validationCode = validateData(fullName, email, password, confirmPassword)
                    when (validationCode) {
                        0 -> {
                            fullNameError = fullName.isBlank()
                            emailError = email.isBlank()
                            passwordError = password.isBlank()
                            confirmPasswordError = confirmPassword.isBlank()
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


                        2 -> {
                            passwordmatchError = true
                            Toast.makeText(context, "Passwords don't match", Toast.LENGTH_LONG)
                                .show()
                        }


                        else -> {
                            navController.navigate("${Route.CONTINUE_SIGNUP}/$fullName/$email/$password")
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
                    text = "Sign up",
                    color = G0,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )
            }


            TextButton(onClick = { }) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = G100,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.inter_medium))
                            )
                        ) {
                            append("Already have an account? ")
                        }


                        withStyle(
                            style = SpanStyle(
                                color = P300,
                                textDecoration = TextDecoration.Underline,
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 16.sp
                            )
                        ) {
                            append("Sign In")
                        }
                    }
                )
            }


        }
    }


}


fun validateData(
    fullName: String,
    email: String,
    password: String,
    passwordConfirm: String,
    modifier: Modifier = Modifier
): Int {
    val pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*(),.?\":{}|<>]).{6,}\$"
    val state =
        if (fullName.isBlank() || email.isBlank() || password.isBlank() || passwordConfirm.isBlank()) 0
        else if (!Regex(pattern).matches(password)) 1
        else if (password != passwordConfirm) 2
        else 3
    return state
}




@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}
