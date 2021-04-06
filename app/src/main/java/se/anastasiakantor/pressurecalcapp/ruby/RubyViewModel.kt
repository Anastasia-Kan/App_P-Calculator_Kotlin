package se.anastasiakantor.pressurecalcapp.ruby

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import se.anastasiakantor.pressurecalcapp.helpers.CalculationMethods
import se.anastasiakantor.pressurecalcapp.R
import se.anastasiakantor.pressurecalcapp.diamond.DiamondViewModel
import se.anastasiakantor.pressurecalcapp.helpers.Calibrations
import se.anastasiakantor.pressurecalcapp.helpers.TAG
import java.lang.Math.pow

class RubyViewModel(private val startFrom: Int) : ViewModel() {
    var calibration = MutableLiveData(Calibrations.SHEN)
    var referenceTempScale = MutableLiveData<Int>()
    var measuredTempScale = MutableLiveData<Int>()
    var refRubyString = MutableLiveData<String>()
    var refTempString = MutableLiveData<String>()
    var gotRubyString = MutableLiveData<String>()
    var gotTempString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()

    var pressure = 0.0

    init {
        calibration.value = Calibrations.values()[startFrom]
        referenceTempScale.value = R.id.ref_kelvin_segment
        measuredTempScale.value = R.id.measured_kelvin_segment
    }

    fun calculatePressureRubyClicked() {

        val refRuby = refRubyString.value?.toDoubleOrNull() ?: 694.22
        val gotRuby = gotRubyString.value?.toDoubleOrNull() ?: 694.22

        val refTemp = if (referenceTempScale.value == R.id.ref_celsius_segment) {
            refTempString.value?.toDoubleOrNull() ?: 25.0
        } else {
            refTempString.value?.toDoubleOrNull() ?: 298.0
        }

        val gotTemp = if (measuredTempScale.value == R.id.measured_celsius_segment) {
            gotTempString.value?.toDoubleOrNull() ?: 25.0
        } else {
            gotTempString.value?.toDoubleOrNull() ?: 298.0
        }

        var RT = refTemp
        var T = gotTemp

        if (referenceTempScale.value == R.id.ref_celsius_segment) {
            RT += 273.0
        }

        if (measuredTempScale.value == R.id.measured_celsius_segment) {
            T += 273.0
        }

        val deltaRT = RT - 296.0
        val deltaRTsqr = pow(deltaRT, 2.0)
        val deltaRTcub = pow(deltaRT, 3.0)
        val deltaT = T - 296.0
        val deltaTsqr = pow(deltaT, 2.0)
        val deltaTcub = pow(deltaT, 3.0)
        var corrLambda0 = -0.887
        var corrLambda = -0.887

        if (RT in 50.0..296.0)
            corrLambda0 = (0.00664 * deltaRT) + (6.76e-6 * deltaRTsqr) - (2.33e-8 * deltaRTcub)

        if (RT >= 296.0)
            corrLambda0 = (0.00746 * deltaRT) - (3.01e-6 * deltaRTsqr) + (8.76e-9 * deltaRTcub)

        val lambda0 = refRuby - corrLambda0

        if (T in 50.0..296.0)
            corrLambda = (0.00664 * deltaT) + (6.76e-6 * deltaTsqr) - (2.33e-8 * deltaTcub)

        if (T >= 296.0)
            corrLambda = (0.00746 * deltaT) - (3.01e-6 * deltaTsqr) + (8.76e-9 * deltaTcub)

        val lambda = gotRuby - corrLambda

        if (lambda0 in 690.0..800.0) {
            Log.i(TAG, "input refRuby OK")
        } else {
            Log.i(TAG, "check value input refRuby")
            resultPressureString.value = "Check your values"
            return
        }
        if (lambda in 690.0..1500.0) {
            Log.i(TAG, "input gotRuby OK")
        } else {
            Log.i(TAG, "check value input gotRuby")
            resultPressureString.value = "Check your values"
            return
        }
        if (RT in 10.0..310.0) {
            Log.i(TAG, "input refTemp OK")
        } else {
            Log.i(TAG, "check value input refTemp")
            resultPressureString.value = "Check your values"
            return
        }


        when (calibration.value) {
            Calibrations.SHEN -> {
                CalculationMethods.validateNumbersShen(lambda0, lambda)
                pressure = CalculationMethods.Shen(lambda0, lambda)
            }
            Calibrations.MAO_Hydro -> {
                pressure = CalculationMethods.Mao(7.665, lambda0, lambda)
            }
            Calibrations.MAO_Non_Hydro -> {
                pressure = CalculationMethods.Mao(5.0, lambda0, lambda)
            }
        }

        refRubyString.value = refRuby.toString()
        refTempString.value = refTemp.toString()
        gotRubyString.value = gotRuby.toString()
        gotTempString.value = gotTemp.toString()

        resultPressureString.value = pressure.toString()
    }

    class Factory(private val startFrom: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RubyViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RubyViewModel(startFrom) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}

