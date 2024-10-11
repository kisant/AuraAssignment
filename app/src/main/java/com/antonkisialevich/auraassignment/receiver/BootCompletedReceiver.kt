package com.antonkisialevich.auraassignment.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.antonkisialevich.auraassignment.data.local.entity.BootEntity
import com.antonkisialevich.auraassignment.utils.database

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            persistBootEvent(context)
        }
    }

    private fun persistBootEvent(context: Context) {
        val sharedPreferences = context.getSharedPreferences("boot_events", Context.MODE_PRIVATE)
        val lastBootTime = sharedPreferences.getLong("last_boot_time", 0)
        val editor = sharedPreferences.edit()
        editor.putLong("second_last_boot_time", lastBootTime)
        editor.putLong("last_boot_time", System.currentTimeMillis())
        editor.commit()

        val bootTime = System.currentTimeMillis()
        context.applicationContext.database.bootsDao.insertBoot(BootEntity(bootTime = bootTime))
    }
}