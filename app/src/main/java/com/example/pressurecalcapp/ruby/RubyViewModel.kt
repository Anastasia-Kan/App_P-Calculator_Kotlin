package com.example.pressurecalcapp.ruby

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pressurecalcapp.R

class RubyViewModel : ViewModel() {

    private val TAG = "MyDebug"

    var calibration = MutableLiveData<Int>()

    var refRubyString = MutableLiveData<String>()
    var refTempString = MutableLiveData<String>()
    var gotRubyString = MutableLiveData<String>()
    var gotTempString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()

    init {
        calibration.value = R.id.shen_segment
        Log.i(TAG, "RubyViewModel created")
    }

    fun calculatePressureRubyClicked() {

        when (calibration.value) {
            R.id.shen_segment -> Log.i(TAG, "onClick: shen_segment")
            R.id.mao_hydro_segment -> Log.i(TAG, "onClick: mao_hydro_segment")
            R.id.mao_nHydro_segment -> Log.i(TAG, "onClick: mao_nHydro_segment")
        }

        val refRuby = refRubyString.value?.toDoubleOrNull() ?: 694.22
        val refTemp = refTempString.value?.toDoubleOrNull() ?: 298
        val gotRuby = gotRubyString.value?.toDoubleOrNull() ?: 694.22
        val gotTemp = gotTempString.value?.toDoubleOrNull() ?: 298


        Log.i(TAG, "refRuby is $refRuby")




    }

    fun isLegalNumber(number : String)
    {
        Log.i(TAG, "isLegalNumber activated")
    }

}