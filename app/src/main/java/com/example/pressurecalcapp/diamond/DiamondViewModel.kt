package com.example.pressurecalcapp.diamond

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pressurecalcapp.*

class DiamondViewModel : ViewModel() {

    var method = MutableLiveData<Int>()
    var refPeakString = MutableLiveData<String>()
    var gotPeakString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()

    var pressure = 0.0

    init
    {
        method.value = R.id.dia_raman_segment
        Log.i(TAG, "DiamondViewModel created")
    }


    fun calculatePressureDiamondClicked()
    {
        when (method.value) {
            R.id.dia_raman_segment ->
            {   val refPeak = refPeakString.value?.toDoubleOrNull() ?: 1333.0
                val gotPeak = gotPeakString.value?.toDoubleOrNull() ?: 1333.0
                refPeakString.value = refPeak.toString()
                gotPeakString.value = gotPeak.toString()



                pressure = CalculationMethods.diamondRaman(refPeak, gotPeak)
                resultPressureString.value = pressure.toString()
            }
            R.id.dia_anvil_raman_segment ->
            {   val refPeak = refPeakString.value?.toDoubleOrNull() ?: 1334.0
                val gotPeak = gotPeakString.value?.toDoubleOrNull() ?: 1334.0
                refPeakString.value = refPeak.toString()
                gotPeakString.value = gotPeak.toString()

                pressure = CalculationMethods.diamondAnvilRaman(refPeak, gotPeak)
                resultPressureString.value = pressure.toString()
            }
        }
    }
}