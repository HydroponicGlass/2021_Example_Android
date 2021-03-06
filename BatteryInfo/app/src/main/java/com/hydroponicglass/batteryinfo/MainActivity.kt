package com.hydroponicglass.batteryinfo

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val br : BroadcastReceiver = BatteryBroadcastReceiver()
        val filter = IntentFilter().apply{
            addAction(Intent.ACTION_BATTERY_CHANGED)
        }
        registerReceiver(br, filter)
    }
}