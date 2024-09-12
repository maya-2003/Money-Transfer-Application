package com.teamj.moneytransferapp.signin

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.ui.theme.D300
import com.teamj.moneytransferapp.ui.theme.FieldStyle
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.G10
import com.teamj.moneytransferapp.ui.theme.G70
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P900
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.MainActivity
import com.teamj.moneytransferapp.api.viewmodels.UserLoginViewModel
import com.teamj.moneytransferapp.navigation.Route


@Composable
fun SignInScreen(navController: NavController,modifier: Modifier = Modifier, viewModel: UserLoginViewModel = viewModel()) {
    val context= LocalContext.current
    val activity = context as? MainActivity
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(G0, P900)
                )
            ),
    )
         {

        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
            ) {
                Row (
                 modifier = modifier
                    .padding(top = 32.dp)
                ){
                Text(
                    text = "Sign In",
                    fontSize = 24.sp,
                    modifier = modifier
                        .padding(top = 24.dp)
                )

            }

            Spacer(modifier = Modifier.height(64.dp))


            Text(
                text = "Speedo Transfer",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(36.dp))

            val email = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }
            val passwordVisibility = remember { mutableStateOf(false) }

                Text(
                    text = "Email",
                    fontSize = 18.sp,
                    modifier = modifier
                        .align(Alignment.Start)
                )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = {
                    Text(
                    text = "Enter your email address",
                    fontSize = 16.sp,
                    style = FieldStyle
                    ) },

                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
                    .background(Color.White),
                trailingIcon = { Icon(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = "email",
                    modifier = modifier
                        .size(24.dp)
                    ) },

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = D300,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Password",
                fontSize = 18.sp,
                modifier = modifier
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text(
                    text = "Enter your password",
                    fontSize = 16.sp,
                    style = FieldStyle
                ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),

                trailingIcon = {
                    IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                        Icon(
                            painter = painterResource(id = if (passwordVisibility.value) R.drawable.visibility else R.drawable.non_visibility),
                            contentDescription = null,
                            modifier = modifier
                                .size(24.dp)
                       )
                    } },
                shape = RoundedCornerShape(8.dp),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),

                singleLine = true,

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = G10,
                    unfocusedContainerColor = G10,
                    disabledContainerColor = G10,
                    errorContainerColor = D300,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray,

                    )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    val code =validateData(
                        password = password.toString(),
                        email = email.toString(),
                    )
                    when(code){
                        1->{
                            viewModel.loginUser(context, email.value, password.value) { token, id ->
                                activity?.storePrefs(token, id)
                            }
                            navController.navigate(Route.HOME)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 4.dp)
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(P300),
                shape = RoundedCornerShape(8.dp)
            ){
                Text(
                    text = "Sign in",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Don’t have an account?",
                    fontSize = 16.sp,
                    color = G70,
                    modifier = modifier
                        .padding(top = 15.dp)
                )

                TextButton(onClick = {navController.navigate(Route.SIGNUP)}) {
                    Text(
                        text = "Sign Up",
                        fontSize = 16.sp,
                        textDecoration = TextDecoration.Underline,
                        color =  P300
                    )
                }
            }
        }
    }
}




fun validateData(password:String,email:String): Int {
    val state = if(email.isBlank()||password.isBlank()) 0
    else 1
    return state
}


@Composable
@Preview(showBackground = true)
fun SignInfun(){
    SignInScreen(rememberNavController())
}
