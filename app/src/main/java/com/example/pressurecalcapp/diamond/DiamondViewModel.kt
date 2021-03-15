package com.example.pressurecalcapp.diamond

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pressurecalcapp.R

class DiamondViewModel : ViewModel() {

    private val TAG = "MyDebug"

    var method = MutableLiveData<Int>()
    var refPeakString = MutableLiveData<String>()
    var gotPeakString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()

    init {
        method.value = R.id.dia_raman_segment
        Log.i(TAG, "DiamondViewModel created")
    }

    fun calculatePressureDiamondClicked() {

        when (method.value) {
            R.id.dia_raman_segment ->
            {   val refPeak = refPeakString.value?.toDoubleOrNull() ?: 1333
                val gotPeak = gotPeakString.value?.toDoubleOrNull() ?: 1333
                Log.i(TAG, "onClick: dia_raman_segment, refPeak=$refPeak")}
            R.id.dia_anvil_raman_segment ->
            {   val refPeak = refPeakString.value?.toDoubleOrNull() ?: 1334
                val gotPeak = gotPeakString.value?.toDoubleOrNull() ?: 1334
                Log.i(TAG, "onClick: dia_anvil_raman_segment, refPeak=$refPeak")}
        }

    }
}