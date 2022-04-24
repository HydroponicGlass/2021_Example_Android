package com.hydroponicglass.circularprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar : ProgressBar = findViewById(R.id.progress)
        val button_plus : Button = findViewById(R.id.button_plus)
        val button_minus : Button = findViewById(R.id.button_minus)

        progressBar.progress = 0
        button_plus.setOnClickListener{
            progressBar.incrementProgressBy(10)
        }
        button_minus.setOnClickListener{
            progressBar.incrementProgressBy(-10)
        }
    }
}