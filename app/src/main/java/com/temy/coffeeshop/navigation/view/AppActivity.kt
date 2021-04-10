package com.temy.coffeeshop.navigation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temy.coffeeshop.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }
}