package com.antonkisialevich.auraassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.antonkisialevich.auraassignment.data.local.BootsRoomDatabase.Companion.DATABASE_NAME
import com.antonkisialevich.auraassignment.data.local.BootsRoomDatabase.Companion.DATABASE_VERSION
import com.antonkisialevich.auraassignment.data.local.dao.BootsDao
import com.antonkisialevich.auraassignment.data.local.entity.BootEntity

class BootsDatabase internal constructor(private val database: BootsRoomDatabase) {
    val bootsDao: BootsDao
        get() = database.bootsDao()
}

@Database(entities = [BootEntity::class], version = DATABASE_VERSION, exportSchema = false)
internal abstract class BootsRoomDatabase : RoomDatabase() {
    abstract fun bootsDao(): BootsDao

    companion object {
        const val DATABASE_NAME = "boots"
        const val BOOT_TABLE_NAME = "boots_table"
        const val DATABASE_VERSION = 1
    }
}

fun getBootsDatabase(applicationContext: Context): BootsDatabase {
    val bootsRoomDatabase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        BootsRoomDatabase::class.java,
        DATABASE_NAME
    ).build()
    return BootsDatabase(bootsRoomDatabase)
}