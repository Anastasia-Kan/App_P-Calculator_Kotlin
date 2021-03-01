package com.example.pressurecalcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.pressurecalcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val rubyView = RubyFragment()
    private val diamondView = DiamondFragment()

    val TAG = "MyDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.mainFragmentContainer, rubyView).commit()

        binding.rubyTab.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer, rubyView).commit()
        }

        binding.diamondTab.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer, diamondView).commit()
        }
    }

/*   public fun onSegmentClicked(view: View) {
        Log.i("myDebug", "onSegmentClicked: ")
        if (view is AppCompatRadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.shen_segment -> if (checked) { Log.i(TAG, "Shen chosen")}
                R.id.mao_hydro_segment -> if (checked) {Log.i(TAG, "Mao hydro chosen")}
                R.id.mao_nHydro_segment -> if (checked) {println("Mao non-hydro chosen")}
            }
        }
    }*/
}