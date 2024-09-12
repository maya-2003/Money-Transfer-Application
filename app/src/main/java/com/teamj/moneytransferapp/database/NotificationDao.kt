package com.maya.signupapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface NotificationDao {
    @Insert
    suspend fun insertNotification(notif: Notification)

    @Query("SELECT * FROM notification ORDER BY id DESC")
    fun getNotifications(): Flow<List<Notification>>
}