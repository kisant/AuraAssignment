package com.antonkisialevich.auraassignment.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.antonkisialevich.auraassignment.data.local.BootsDatabase
import com.antonkisialevich.auraassignment.data.local.getBootsDatabase
import com.antonkisialevich.auraassignment.di.ViewModelFactory
import com.antonkisialevich.auraassignment.utils.Constants.BOOT_NOTIFICATION_CHANNEL_ID
import com.antonkisialevich.auraassignment.utils.Constants.BOOT_NOTIFICATION_CHANNEL_NAME

class AuraAssignmentApp : Application() {

    val viewModelFactory: ViewModelFactory by lazy { ViewModelFactory() }
    val database: BootsDatabase by lazy { getBootsDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        createBootNotificationChannel()
    }

    private fun createBootNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                BOOT_NOTIFICATION_CHANNEL_ID,
                BOOT_NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}