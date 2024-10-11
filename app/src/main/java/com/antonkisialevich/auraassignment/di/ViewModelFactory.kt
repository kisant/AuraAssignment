package com.antonkisialevich.auraassignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antonkisialevich.auraassignment.ui.main.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> MainViewModel()
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }
}