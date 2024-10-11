package com.antonkisialevich.auraassignment.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val data: MutableStateFlow<String> = MutableStateFlow("")

}