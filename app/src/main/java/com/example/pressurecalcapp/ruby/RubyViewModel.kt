package com.example.pressurecalcapp.ruby

import android.util.Log
import androidx.lifecycle.ViewModel

class RubyViewModel : ViewModel() {

    private val TAG = "MyDebug"

    var refRuby : String = ""

    init {
        Log.i(TAG, "RubyViewModel created")
    }

    fun calcPClicked() {
        Log.i(TAG, "refRuby = $refRuby")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "RubyViewModel destroyed")
    }
}