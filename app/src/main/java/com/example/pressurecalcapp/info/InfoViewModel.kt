package com.example.pressurecalcapp.info

import android.util.Log
import androidx.lifecycle.ViewModel

class InfoViewModel : ViewModel() {

    private val TAG = "MyDebug"

    init {
        Log.i(TAG, "InfoViewModel created")
    }

}