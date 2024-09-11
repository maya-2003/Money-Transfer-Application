package com.teamj.moneytransferapp.corefun

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.ui.theme.G40
import com.teamj.moneytransferapp.ui.theme.G900



@Composable
fun ErrorAlertDialog(emessage: String, isDialogVisible: Boolean) {

    var isDialogVisible by remember { mutableStateOf(true) }
    var errorMessage = remember {mutableStateOf( emessage)}


        androidx.compose.material3.AlertDialog(
            onDismissRequest = {
                isDialogVisible = false
            },
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.alert),
                            contentDescription = null
                        )

                        Text(
                            text = "$errorMessage",
                            style = TextStyle(
                                color = G900,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Unspecified
                            ),
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                    }
                }
            },
            confirmButton = {},

            containerColor = G40,

            shape = RoundedCornerShape(8.dp),
        )
    }

