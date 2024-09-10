package com.teamj.moneytransferapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.ui.theme.G0
import com.teamj.moneytransferapp.ui.theme.GrayProgress
import com.teamj.moneytransferapp.ui.theme.P300

@Composable
fun TransferProgress(state: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .border(width = 2.dp, color = P300, shape = RoundedCornerShape(20.dp))
                    .background(color = G0, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "01",
                    color = P300,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            HorizontalDivider(thickness = 2.dp, modifier = modifier.width(100.dp), color = P300)
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .size(40.dp)
                    .border(
                        width = 2.dp,
                        color = if (state == 2 || state == 3) P300 else GrayProgress,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(color = G0, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "02",
                    color = if (state == 2 || state == 3) P300 else GrayProgress,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            HorizontalDivider(
                thickness = 2.dp,
                modifier = modifier.width(100.dp),
                color = if (state == 3) P300 else GrayProgress,
            )
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .size(40.dp)
                    .border(width = 2.dp, color = if (state == 3) P300 else GrayProgress, shape = RoundedCornerShape(20.dp))
                    .background(color = G0, shape = RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "03",
                    color = if (state == 3) P300 else GrayProgress,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold))
                )
            }
        }
        Spacer(modifier = modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "Amount", fontFamily = FontFamily(Font(R.font.inter_medium)))
            Text(text = "Confirmation", fontFamily = FontFamily(Font(R.font.inter_medium)))
            Text(text = "Payment", fontFamily = FontFamily(Font(R.font.inter_medium)))

        }
    }

}