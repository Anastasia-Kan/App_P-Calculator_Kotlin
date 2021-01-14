package com.example.pressurecalctest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatRadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val shen = findViewById<AppCompatRadioButton>(R.id.shen_segment)
        val mao_hydro = findViewById<AppCompatRadioButton>(R.id.mao_hydro_segment)
        val mao_nHydro = findViewById<AppCompatRadioButton>(R.id.mao_nHydro_segment)

    }

    fun onSegmentClicked(view: View) {
        var isSelected = false;
        switch (view.getId()) {
            case shen
        }
    }

    private fun AppCompatRadioButton(): Any {

    }
/*
    public void onSegmentClicked(View view) {
        var isSelected = ((androidx.appcompat.widget.AppCompatRadioButton())view).isChecked();
        switch (view.getId()) { case R . layout . id . shen_segment : }
    }*/
}