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

        var binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.mainNavHostFragment, rubyView).commit()

        binding.rubyTab.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, rubyView).commit()

            //TODO: save local var Tab-state
        }

        binding.diamondTab.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, diamondView).commit()

            //TODO: save local var Tab-state
        }
    }
}