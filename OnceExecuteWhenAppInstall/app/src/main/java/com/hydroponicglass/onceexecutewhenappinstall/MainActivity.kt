package com.hydroponicglass.onceexecutewhenappinstall

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref : SharedPreferences = getSharedPreferences("CheckFirst", Context.MODE_PRIVATE)
        var checkFirst = pref.getBoolean("CheckFirst", false)
        if(checkFirst == false){
            var editer : SharedPreferences.Editor = pref.edit()
            editer.putBoolean("CheckFirst", true)
            editer.commit()
            Log.d("test", "First Execute")
        }
    }
}