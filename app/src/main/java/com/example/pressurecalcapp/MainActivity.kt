package com.example.pressurecalcapp

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.pressurecalcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val rubyView = RubyFragment()
    private val diamondView = DiamondFragment()

    val TAG = "MyDebug"

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.mainNavHostFragment, rubyView).commit()

        val rubyTab = binding.rubyTab

        val diamondTab = binding.diamondTab

        rubyTab.setOnClickListener {
            // State doesn't change onClick - backgroundTint is not changing
            rubyTab.isSelected != rubyTab.isSelected
            Log.i(TAG, "rubyTab clicked")
            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, rubyView).commit()


            //TODO: save local var Tab-state
        }

        diamondTab.setOnClickListener {
            diamondTab.isSelected != diamondTab.isSelected
            Log.i(TAG, "diamondTab clicked")

            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, diamondView).commit()

            //TODO: save local var Tab-state
        }
    }
}