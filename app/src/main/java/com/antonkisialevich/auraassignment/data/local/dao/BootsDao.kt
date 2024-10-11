package com.antonkisialevich.auraassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.antonkisialevich.auraassignment.data.local.entity.BootEntity

@Dao
interface BootsDao {
    @Insert
    fun insertBoot(boot: BootEntity)

    @Query("SELECT * FROM boots_table ORDER BY boot_time DESC LIMIT 2")
    suspend fun getLastTwoBootEvents(): List<BootEntity>
}