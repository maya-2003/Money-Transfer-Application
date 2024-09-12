package com.maya.moneytransferapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.favorites.FavReq
import com.teamj.moneytransferapp.ui.theme.G100
import com.teamj.moneytransferapp.ui.theme.P50

@Composable
fun ContactCard(favos: FavReq, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(color = P50),
        shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(16.dp),

        ) {

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .background(Color.Transparent)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = favos.recipientName,
                    fontSize = 16.sp,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Account xxxx${favos.recipientAccountNumber.takeLast(4)}",
                    fontSize = 16.sp,
                    color = G100
                )
            }
            Row {
                IconButton(onClick = onEditClick) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        modifier = Modifier
                             .size(20.dp)
                    )
                }

                IconButton(onClick = onDeleteClick) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier
                                .size(20.dp)
                    )
                }
            }
        }
    }
}


