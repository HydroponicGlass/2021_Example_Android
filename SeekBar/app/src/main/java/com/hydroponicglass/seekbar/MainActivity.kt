package com.hydroponicglass.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekBar : SeekBar = findViewById(R.id.seekBar)
        var textView : TextView = findViewById(R.id.textView)

        /*
        var max = 150
        seekBar.max = max
        */

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textView.text = p1.toString()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
                textView.text = p0?.progress.toString()
                //TODO("Not yet implemented")
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                textView.text = p0?.progress.toString()
                //TODO("Not yet implemented")
            }
        })

    }
}