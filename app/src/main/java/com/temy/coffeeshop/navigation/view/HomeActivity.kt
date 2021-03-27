package com.temy.coffeeshop.navigation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.temy.coffeeshop.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigationMenu()
    }

    private fun setupBottomNavigationMenu() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        val navHostFragment: NavHostFragment? =
            supportFragmentManager.findFragmentById(R.id.navigation_host_fragment) as NavHostFragment?

        navHostFragment?.let {
            val navController = it.navController
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}