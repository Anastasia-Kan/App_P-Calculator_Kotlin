package se.anastasiakantor.pressurecalcapp

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("methodDetails")
fun TextView.bindMethodDetails(value: Int?) {
    value?.let {
        val stringId = when (value) {
            R.id.dia_raman_segment -> R.string.diamond_raman_details
            R.id.dia_anvil_raman_segment -> R.string.diamond_anvil_details
            else -> R.string.diamond_raman_details
        }
        setText(stringId)
    }
}