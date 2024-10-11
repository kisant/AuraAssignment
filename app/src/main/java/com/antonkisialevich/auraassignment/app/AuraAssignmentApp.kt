package com.antonkisialevich.auraassignment.app

import android.app.Application
import com.antonkisialevich.auraassignment.di.ViewModelFactory

class AuraAssignmentApp : Application() {

    val viewModelFactory: ViewModelFactory by lazy { ViewModelFactory() }

    override fun onCreate() {
        super.onCreate()

    }
}