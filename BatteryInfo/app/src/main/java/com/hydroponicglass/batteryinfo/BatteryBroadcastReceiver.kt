package com.hydroponicglass.batteryinfo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.util.Log

class BatteryBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("test", "intent.action : ${intent.action}")
        if (intent.action == "android.intent.action.BATTERY_CHANGED") {
            val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL
            val chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            val usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level * 100 / scale.toFloat()
            val voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0) // mv
            val temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)/10F // celsius

            Log.d("test", "status : ${status}")
            Log.d("test", "isCharging : ${isCharging}")
            Log.d("test", "chargePlug : ${chargePlug}")
            Log.d("test", "usbCharge : ${usbCharge}")
            Log.d("test", "acCharge : ${acCharge}")
            Log.d("test", "voltage : ${voltage}")
            Log.d("test", "batteryPct : ${batteryPct}")
            Log.d("test", "temp : ${temp}")


        }
    }
}