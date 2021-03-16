package com.example.pressurecalcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val rubyView = RubyFragment()
    private val diamondView = DiamondFragment()

    val TAG = "MyDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rubyTab = findViewById<Button>(R.id.rubyTab)
        val diamondTab = findViewById<Button>(R.id.diamondTab)


        //TODO: move all navigation to Fragments; create to different disigns for Activ and Nonactiv buttons
        rubyTab.setOnClickListener {
            rubyTab.isSelected != rubyTab.isSelected // Done to change BTN's bckgr, but doesn't work
            Log.i(TAG, "rubyTab clicked")
            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, rubyView).commit()
            //TODO: save local var Tab-state

            //TODO: replace FragmentManager with Navigation:
        // "replace" fragment leads to lose of navigation actions
        }


        diamondTab.setOnClickListener {
            diamondTab.isSelected != diamondTab.isSelected // Done to change BTN's bckgr, but doesn't work
            Log.i(TAG, "diamondTab clicked")
            supportFragmentManager.beginTransaction().replace(R.id.mainNavHostFragment, diamondView).commit()
            //TODO: save local var Tab-state
        }
    }
}