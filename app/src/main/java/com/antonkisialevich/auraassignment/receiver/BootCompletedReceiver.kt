package com.antonkisialevich.auraassignment.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Persist the boot event information
            persistBootEvent(context)
        }
    }

    private fun persistBootEvent(context: Context) {
        // Implement the logic to persist the boot event information
        val sharedPreferences = context.getSharedPreferences("boot_events", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("last_boot_time", System.currentTimeMillis())
        editor.apply()
        Log.d("BootCompletedReceiver", "Boot event received and persisted")
    }
}