package com.example.pressurecalcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "Main activity")

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainFragmentHost) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfig = AppBarConfiguration(navController.graph)
        NavigationUI.setupWithNavController(findViewById(R.id.toolbar), navController, appBarConfig)

    }
}
