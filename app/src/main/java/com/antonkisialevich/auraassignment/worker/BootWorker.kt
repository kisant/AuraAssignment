package com.antonkisialevich.auraassignment.worker

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.antonkisialevich.auraassignment.R
import com.antonkisialevich.auraassignment.utils.Constants.BOOT_NOTIFICATION_CHANNEL_ID
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BootWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val sharedPreferences = applicationContext.getSharedPreferences("boot_events", Context.MODE_PRIVATE)
        val lastBootTime = sharedPreferences.getLong("last_boot_time", 0)
        val secondLastBootTime = sharedPreferences.getLong("second_last_boot_time", 0)

        val notificationBody = when {
            lastBootTime == 0L -> "No boots detected"
            secondLastBootTime == 0L -> {
                val date = Date(lastBootTime)
                val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                "The boot was detected = ${format.format(date)}"
            }
            else -> {
                val delta = lastBootTime - secondLastBootTime
                "Last boots time delta = ${delta / 1000} seconds"
            }
        }

        showNotification(notificationBody)
        return Result.success()
    }

    private fun showNotification(body: String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(applicationContext, BOOT_NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Boot Event")
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        notificationManager.notify(1, notification)
    }
}