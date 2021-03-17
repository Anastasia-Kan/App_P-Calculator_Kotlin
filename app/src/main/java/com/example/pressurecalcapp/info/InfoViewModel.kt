package com.example.pressurecalcapp.info

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pressurecalcapp.TAG

class InfoViewModel : ViewModel() {

    /*val infoTextString = MutableLiveData<String>()
    var infoText : String = ""*/

    init {
        //infoTextString.value = infoText

        Log.i(TAG, "InfoViewModel created")
    }
}