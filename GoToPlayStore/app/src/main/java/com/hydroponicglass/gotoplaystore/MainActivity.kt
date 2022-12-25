package com.hydroponicglass.gotoplaystore

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val PACKAGE_NAME = "com.hydroponicglass.interestcalculator"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)

        button.setOnClickListener{
            OpenAppOrGoToPlayStore()
        }
    }

    fun IsInstalledApp(packageName: String): Boolean {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if(intent != null){
            return true
        }
        return false
    }

    fun OpenApp(packageName: String) {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        startActivity(intent)
    }

    fun GoToPlayStore(packageName: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun OpenAppOrGoToPlayStore() {
        if (IsInstalledApp(PACKAGE_NAME)) {
            Log.d(TAG, "[OpenAppOrGoToPlayStore] Run OpenApp")
            OpenApp(PACKAGE_NAME)
        }
        else{
            Log.d(TAG, "[OpenAppOrGoToPlayStore] Run GoToPlayStore")
            GoToPlayStore(PACKAGE_NAME)
        }
    }
}