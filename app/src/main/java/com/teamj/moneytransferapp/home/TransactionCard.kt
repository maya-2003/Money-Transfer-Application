package com.maya.moneytransferapp

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.teamj.moneytransferapp.ui.theme.P300

@Composable
fun TransactionCard(transaction: Transaction) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .background(color = Color.White),

        ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(color = Color.White),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.master_card_logo),
                contentDescription = "Card Icon",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(15.dp)
            ) {
                Text(
                    text = transaction.name,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontWeight = FontWeight(500))
                )

                Text(
                    text = "${transaction.cardType} • ${transaction.cardNumber}",
//                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
                Text(
                    text = transaction.time,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                )            }

            Text(
                text = transaction.amount,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight(500),
                    color = P300,

                    )
            )
        }
    }
}

@Preview
@Composable
fun PreviewTransactionCard() {
    TransactionCard(
        transaction = Transaction(
            name = "Ahmed Mohamed",
            cardType = "Visa",
            cardNumber = "1234",
            time = "Today 11:00",
            amount = "500 EGP"
        )
    )
}
