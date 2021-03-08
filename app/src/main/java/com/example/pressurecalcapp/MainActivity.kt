package com.example.pressurecalcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val rubyView = RubyFragment()
    private val diamondView = DiamondFragment()

    val TAG = "MyDebug"

    //@SuppressLint("ResourceAsColor") // WHAT is THAT???
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        /*var binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.mainNavHostFragment, rubyView).commit()

        val rubyTab = binding.rubyTab
        val diamondTab = binding.diamondTab*/

        val rubyTab = findViewById<Button>(R.id.rubyTab)

        rubyTab.setOnClickListener {
            // State doesn't change onClick - backgroundTint is not changing
            rubyTab.isSelected != rubyTab.isSelected
            Log.i(TAG, "rubyTab clicked")
            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, rubyView).commit()


            //TODO: save local var Tab-state
        }

        val diamondTab = findViewById<Button>(R.id.diamondTab)
        diamondTab.setOnClickListener {
            diamondTab.isSelected != diamondTab.isSelected
            Log.i(TAG, "diamondTab clicked")

            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, diamondView).commit()

            //TODO: save local var Tab-state
        }
    }
}