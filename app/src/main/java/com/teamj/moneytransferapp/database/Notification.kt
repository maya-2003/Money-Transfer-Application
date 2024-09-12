package com.maya.signupapplication.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity("notification")
class Notification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fromAccountNumber: String,
    val toAccountNumber: String,
    val fromAccountName: String,
    val toAccountName: String,
    val amount: Int,
    val transactionDate: String
) : Parcelable