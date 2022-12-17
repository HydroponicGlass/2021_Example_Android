package com.hydroponicglass.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progress_bar: ProgressBar = findViewById(R.id.progress_bar)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener{
            val progress = progress_bar.progress
//            progress_bar.max = 30
            progress_bar.setProgress(progress+10)
        }


    }
}