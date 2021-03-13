package com.temy.coffeeshop.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.temy.coffeeshop.R
import com.temy.coffeeshop.navigation.view.HomeActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val DELAY = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY)
    }
}