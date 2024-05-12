package com.legalist.dinamicbroadcastreciervers

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
private lateinit var broadcastingclass: Broadcastingclass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        broadcastingclass = Broadcastingclass()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }
    override fun onResume() {
        super.onResume()
        val intenfilter = IntentFilter()
        intenfilter.addAction(Intent.ACTION_BATTERY_LOW)
        registerReceiver(broadcastingclass,intenfilter)

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastingclass)
    }
}