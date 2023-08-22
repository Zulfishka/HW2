package com.example.dz2_m6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dz2_m6.ui.first.FirstFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container,FirstFragment())
    }
}