package com.teamj.moneytransferapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.api.model.Transaction
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.G700
import com.teamj.moneytransferapp.ui.theme.G900
import com.teamj.moneytransferapp.ui.theme.P300
import com.teamj.moneytransferapp.ui.theme.P50

@Composable
fun TransactionCard(transaction: Transaction, type : String) {
    var name by rememberSaveable { mutableStateOf("name") }
    var amount by rememberSaveable { mutableStateOf(0) }
    var date by rememberSaveable { mutableStateOf("Toaday 11 PM") }

    name =if(type == "Sent") transaction.toAccountName else transaction.fromAccountName
    amount= transaction.amount
    date ="${transaction.transactionDate.substring(0,10)} ${transaction.transactionDate.substring(11,16)}"
    Box(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(color = Color.White),

        ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(color = Color.White),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(color = P50, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mastercard),
                    contentDescription = "mastercard logo",
                    modifier = Modifier.size(32.dp)
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = name,
                        modifier = Modifier.padding(bottom = 4.dp),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            color = G900
                        )
                    )

                    Text(
                        text = "Visa . Mater Card . 1234",
                        modifier = Modifier.padding(bottom = 4.dp),
                        color = G700,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_variable))
                    )


                    Text(
                        text = date,
                        color = G100,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.inter_variable))
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$${amount}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        color = P300,

                        )
                )
            }
        }
    }
}
