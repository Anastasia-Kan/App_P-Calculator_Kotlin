package com.example.pressurecalcapp.Ruby

import android.util.Log
import androidx.lifecycle.ViewModel

class RubyViewModel : ViewModel() {

    private val TAG = "MyDebug"

    var refRuby : String = ""

    init {
        Log.i(TAG, "RubyViewModel created")
    }

    fun calcPclicked() {
        Log.i(TAG, "refRuby = $refRuby")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "RubyViewModel destroyed")
    }
}