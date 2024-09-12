package com.maya.signupapplication.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maya.signupapplication.database.Notification
import com.maya.signupapplication.database.RoomDBHelper
import com.teamj.moneytransferapp.R
import com.teamj.moneytransferapp.api.SessionController
import com.teamj.moneytransferapp.api.UserAPIService
import com.teamj.moneytransferapp.api.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    private val notificationDao = RoomDBHelper.getInstance(application).noteDao
    val notifications: Flow<List<Notification>> = notificationDao.getNotifications()

    fun getTransactions(context: Context) {
        viewModelScope.launch {
            try {
                val userId = SessionController.getId(context)
                val response = UserAPIService.callable.getTransactioHistory(userId)

                addLastTransaction(context, response)
            } catch (e: Exception) {
                Log.e("TransactionError", e.toString())
            }
        }
    }

    private fun addLastTransaction(
        context: Context,
        transactions: List<Transaction>
    ) {
            val lastTransaction = transactions.lastOrNull()

            if (lastTransaction != null) {
                sendNotification(context, lastTransaction)

                viewModelScope.launch {
                    val notification = mapNotif(lastTransaction)
                    notificationDao.insertNotification(notification)
                }
            }
        }

    private fun mapNotif(transaction: Transaction): Notification {
        return Notification(
            fromAccountNumber = transaction.fromAccountNumber,
            toAccountNumber = transaction.toAccountNumber,
            fromAccountName = transaction.fromAccountName,
            toAccountName = transaction.toAccountName,
            amount = transaction.amount,
            transactionDate = transaction.transactionDate
        )
    }
    private fun sendNotification(context: Context, transaction: Transaction) {

        val builder = NotificationCompat.Builder(context, "1")
            .setSmallIcon(R.drawable.ic_received)
            .setContentTitle("Transaction Notification")
            .setContentText("Transaction details: ${transaction.amount} from ${transaction.fromAccountName} to ${transaction.toAccountName}")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        NotificationManagerCompat.from(context).notify(transaction.hashCode(), builder.build())
    }
}


