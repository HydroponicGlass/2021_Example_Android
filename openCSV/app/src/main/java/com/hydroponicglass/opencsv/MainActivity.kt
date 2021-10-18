package com.hydroponicglass.opencsv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.textView)

        val csvFile = InputStreamReader(assets.open("data.csv"))
        val reader = BufferedReader(csvFile)

        var tmpLine : String
        var output : String = ""

        try
        {
            while(reader.readLine().also { tmpLine = it } != null)
            {
                val row = tmpLine.split(',')
                output = output + row[0] + " " + row[1] + '\n'
                Log.d("debug", "output : " + output)
            }
        } catch (e:Exception)
        {
            e.printStackTrace()
        }

        textView.setText(output)
    }
}