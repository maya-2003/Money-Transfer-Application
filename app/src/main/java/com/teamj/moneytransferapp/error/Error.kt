package com.teamj.moneytransferapp.error

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamj.moneytransferapp.R


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                listOf(
                    colorResource(id = R.color.lightgold),
                    colorResource(id = R.color.lightpink)
                )))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
     ){
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = "error",
            modifier = Modifier.size(273.dp,195.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Server error...",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "It seems like we're having some difficulties, please don’t leave your aspirations, we are sending for help",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp),
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        val context = LocalContext.current
        val number = 19888

        Button(

            onClick = {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                context.startActivity(intent)
             },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.P300)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
         ){
            Text(
                text = "Call Us",
                fontSize =16.sp,
                color = Color.White,
                modifier = modifier
                )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.5.dp, colorResource(id = R.color.P400)) ,
            modifier = Modifier
                .fillMaxWidth()
                .size(50.dp)
         ){
            Text(
                text = "Message Us",
                fontSize =16.sp,
                color = colorResource(R.color.P400)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewErrorScreen() {
    ErrorScreen()
}
