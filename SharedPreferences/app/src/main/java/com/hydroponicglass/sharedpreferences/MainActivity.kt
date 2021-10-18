package com.hydroponicglass.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    companion object
    {
        lateinit var prefs: PreferenceUtil
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView : TextView = findViewById(R.id.textView)

        prefs.setString("key", "content")
        Log.d("debug", "msg : " + prefs.getString("key", "content is nothing"))

        textView.setText(prefs.getString("key", "content is nothing"))
    }
}