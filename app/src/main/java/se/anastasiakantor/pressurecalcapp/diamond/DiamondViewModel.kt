package se.anastasiakantor.pressurecalcapp.diamond

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import se.anastasiakantor.pressurecalcapp.helpers.CalculationMethods
import se.anastasiakantor.pressurecalcapp.helpers.Variations

class DiamondViewModel(private val startFrom: Int) : ViewModel() {

    var method = MutableLiveData<Variations>()
    var refPeakString = MutableLiveData<String>()
    var gotPeakString = MutableLiveData<String>()
    var resultPressureString = MutableLiveData<String>()

    var pressure = 0.0

    var warningMessageDiamond = MutableLiveData<Boolean>()

    init {
        method.value = Variations.values()[startFrom]
        warningMessageDiamond.value = false
    }

    fun calculatePressureDiamondClicked() {
        when (method.value) {
            Variations.DIAMOND_RAMAN -> {
                //TODO: Save and store method.value
                val refPeak = refPeakString.value?.toDoubleOrNull() ?: 1333.0
                val gotPeak = gotPeakString.value?.toDoubleOrNull() ?: 1333.0
                if (CalculationMethods.areNumbersCorrectDiamond(refPeak, gotPeak)) {
                    refPeakString.value = refPeak.toString()
                    gotPeakString.value = gotPeak.toString()

                    pressure = CalculationMethods.diamondRaman(refPeak, gotPeak)
                    resultPressureString.value = pressure.toString()
                } else {
                    warningMessageDiamond.value = true
                    resultPressureString.value = ""
                }
            }
            Variations.DIAMOND_ANVIL_RAMAN -> {
                val refPeak = refPeakString.value?.toDoubleOrNull() ?: 1334.0
                val gotPeak = gotPeakString.value?.toDoubleOrNull() ?: 1334.0
                if (CalculationMethods.areNumbersCorrectDiamond(refPeak, gotPeak)) {
                    refPeakString.value = refPeak.toString()
                    gotPeakString.value = gotPeak.toString()

                    pressure = CalculationMethods.diamondAnvilRaman(refPeak, gotPeak)
                    resultPressureString.value = pressure.toString()
                } else {
                    warningMessageDiamond.value = true
                    resultPressureString.value = ""
                }
            }
        }
    }

    class Factory(private val startFrom: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DiamondViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DiamondViewModel(startFrom) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}