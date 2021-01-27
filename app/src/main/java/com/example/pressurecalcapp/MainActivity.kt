package com.example.pressurecalcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRadioButton
import com.example.pressurecalcapp.R

public class MainActivity : AppCompatActivity() {

    val rubyView = RubyFragment()
    val diamondView = DiamondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.mainFragmentContainer, rubyView).commit()

        val rubyTab = findViewById<Button>(R.id.rubyTab)
        val diaTab = findViewById<Button>(R.id.diamondTab)

        rubyTab.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer, rubyView).commit()
        }
        diaTab.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFragmentContainer, diamondView).commit()
        }

    }
}