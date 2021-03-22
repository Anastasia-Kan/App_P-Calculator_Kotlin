package se.anastasiakantor.pressurecalcapp

import android.widget.RadioGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import se.anastasiakantor.pressurecalcapp.helpers.Calibrations
import se.anastasiakantor.pressurecalcapp.helpers.Variations

@BindingAdapter("methodDetails")
fun TextView.bindMethodDetails(value: Variations?) {
    value?.let {
        val stringId = when (value) {
            Variations.DIAMOND_RAMAN -> R.string.diamond_raman_details
            Variations.DIAMOND_ANVIL_RAMAN -> R.string.diamond_anvil_details
            else -> R.string.diamond_raman_details
        }
        setText(stringId)
    }
}

@BindingAdapter("app:checkedButtonCalibration")
fun RadioGroup.fromCalibrationToView(newValue: Calibrations?) {
    newValue?.let {
        val radioButtonId = when (it) {
            Calibrations.SHEN -> R.id.shen_segment
            Calibrations.MAO_Hydro -> R.id.mao_hydro_segment
            Calibrations.MAO_Non_Hydro -> R.id.mao_nHydro_segment
        }
        val oldValue = checkedRadioButtonId
        if (oldValue == radioButtonId) return
        check(radioButtonId)
    }
}

@InverseBindingAdapter(attribute = "checkedButtonCalibration", event = "android:checkedButtonAttrChanged")
fun RadioGroup.fromViewToCalibration(): Calibrations {
    return when (checkedRadioButtonId) {
        R.id.shen_segment -> Calibrations.SHEN
        R.id.mao_hydro_segment -> Calibrations.MAO_Hydro
        R.id.mao_nHydro_segment -> Calibrations.MAO_Non_Hydro
        else -> Calibrations.SHEN
    }
}

@BindingAdapter("app:checkedButtonVariation")
fun RadioGroup.fromVariationToView(newValue: Variations?) {
    newValue?.let {
        val radioButtonId = when (it) {
            Variations.DIAMOND_RAMAN -> R.id.dia_raman_segment
            Variations.DIAMOND_ANVIL_RAMAN -> R.id.dia_anvil_raman_segment
        }
        val oldValue = checkedRadioButtonId
        if (oldValue == radioButtonId) return
        check(radioButtonId)
    }
}

@InverseBindingAdapter(attribute = "checkedButtonVariation", event = "android:checkedButtonAttrChanged")
fun RadioGroup.fromViewToVariation(): Variations {
    return when (checkedRadioButtonId) {
        R.id.dia_raman_segment -> Variations.DIAMOND_RAMAN
        R.id.dia_anvil_raman_segment -> Variations.DIAMOND_ANVIL_RAMAN
        else -> Variations.DIAMOND_RAMAN
    }
}