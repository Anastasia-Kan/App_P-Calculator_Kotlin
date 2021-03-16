package com.example.pressurecalcapp.ruby

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pressurecalcapp.CalculationMethods
import com.example.pressurecalcapp.R

class RubyViewModel : ViewModel() {

    private val TAG = "MyDebug"

    var calibration = MutableLiveData<Int>()
    var referenceTempScale = MutableLiveData<Int>()
    var measuredTempScale = MutableLiveData<Int>()

    var refRubyString = MutableLiveData<String>()
    var refTempString = MutableLiveData<String>()
    var gotRubyString = MutableLiveData<String>()
    var gotTempString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()

    init {
        calibration.value = R.id.shen_segment
        referenceTempScale.value = R.id.ref_kelvin_segment
        measuredTempScale.value = R.id.measured_kelvin_segment
        Log.i(TAG, "RubyViewModel created")
    }

    fun calculatePressureRubyClicked() {

        val refRuby = refRubyString.value?.toDoubleOrNull() ?: 694.22
        val refTemp = refTempString.value?.toDoubleOrNull() ?: 298
        val gotRuby = gotRubyString.value?.toDoubleOrNull() ?: 694.22
        val gotTemp = gotTempString.value?.toDoubleOrNull() ?: 298

        when (referenceTempScale.value) {
            R.id.ref_kelvin_segment -> {
                Log.i(TAG, "Kelvin scale chosen")
            }
            R.id.ref_celsius_segment -> {
                Log.i(TAG, "Celsius scale chosen")
            }
        }

        when (measuredTempScale.value) {
            R.id.measured_kelvin_segment -> {
                Log.i(TAG, "Kelvin scale chosen")
            }
            R.id.measured_celsius_segment -> {
                Log.i(TAG, "Celsius scale chosen")
            }
        }


        when (calibration.value) {
            R.id.shen_segment -> {
                CalculationMethods.Shen(refRuby, gotRuby)
                Log.i(TAG, "onClick: shen_segment")}
            R.id.mao_hydro_segment -> {
                CalculationMethods.Mao(7.665, refRuby, gotRuby)
                Log.i(TAG, "onClick: mao_hydro_segment")}
            R.id.mao_nHydro_segment -> {
                CalculationMethods.Mao(5.0, refRuby, gotRuby)
                Log.i(TAG, "onClick: mao_nHydro_segment")}
        }



        refRubyString.value = refRuby.toString()
        refTempString.value = refTemp.toString()
        gotRubyString.value = gotRuby.toString()
        gotTempString.value = gotTemp.toString()




        Log.i(TAG, "refRuby is $refRuby")

        val testNumber = refRuby + gotRuby

        resultPressureString.value = testNumber.toString()

    }
}