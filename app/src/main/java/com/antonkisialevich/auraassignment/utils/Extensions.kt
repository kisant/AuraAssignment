package com.antonkisialevich.auraassignment.utils

import android.content.Context
import com.antonkisialevich.auraassignment.app.AuraAssignmentApp
import com.antonkisialevich.auraassignment.data.local.BootsDatabase

val Context.database: BootsDatabase
    get() = (this as AuraAssignmentApp).database