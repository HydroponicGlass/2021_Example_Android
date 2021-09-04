package com.hydroponicglass.example_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 : Button = findViewById(R.id.btn1)
        var btn2 : Button = findViewById(R.id.btn2)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment1())
            .commit()

        btn1.setOnClickListener()
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment1())
                .commit()
        }

        btn2.setOnClickListener()
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment2())
                .commit()
        }
    }
}