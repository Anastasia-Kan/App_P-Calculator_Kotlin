package se.anastasiakantor.pressurecalcapp.ruby

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import se.anastasiakantor.pressurecalcapp.helpers.CalculationMethods
import se.anastasiakantor.pressurecalcapp.R
import se.anastasiakantor.pressurecalcapp.helpers.Calibrations

class RubyViewModel(private val startFrom: Int) : ViewModel() {
    var calibration = MutableLiveData(Calibrations.SHEN)
    var referenceTempScale = MutableLiveData<Int>()
    var measuredTempScale = MutableLiveData<Int>()
    var refRubyString = MutableLiveData<String>()
    var refTempString = MutableLiveData<String>()
    var gotRubyString = MutableLiveData<String>()
    var gotTempString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()
    var warningMessage = MutableLiveData<Boolean>()

    var pressure = 0.0

    init {
        calibration.value = Calibrations.values()[startFrom]
        referenceTempScale.value = R.id.ref_kelvin_segment
        measuredTempScale.value = R.id.measured_kelvin_segment
        warningMessage.value = false
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

        val lambda0 = refRuby - CalculationMethods.tempCorrectionLambda0(RT)
        val lambda = gotRuby - CalculationMethods.tempCorrectionLambda(T)

        if (CalculationMethods.areNumbersCorrectRuby(lambda0, lambda, RT)) {
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
        } else {
            warningMessage.value = true
            /*val message = "Check your values"
            Snackbar.make(RubyFragment, message, Snackbar.LENGTH_LONG).show()*/
            /*
            TossViewModel.Event.ShowSnackBar -> {
                        val message = getString(event.stringId)
                        Snackbar.make(binding.buttonAdd, message, Snackbar.LENGTH_SHORT).show()
                    }
             */
            //TODO: Snackbar instead of message inside a TextView
            /*val snack = Snackbar.make(it,"This is a simple Snackbar", Snackbar.LENGTH_LONG)
            snack.show()*/
            resultPressureString.value = "Check your values"
        }
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

