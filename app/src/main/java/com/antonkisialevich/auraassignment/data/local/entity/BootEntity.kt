package com.antonkisialevich.auraassignment.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.antonkisialevich.auraassignment.data.local.BootsRoomDatabase.Companion.BOOT_TABLE_NAME

@Entity(tableName = BOOT_TABLE_NAME)
data class BootEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Long = 1,
    @ColumnInfo("boot_time") val bootTime: Long
)
