package com.hydroponicglass.frameanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 : Button = findViewById(R.id.btn1)
        val btn2 : Button = findViewById(R.id.btn2)
        val imageView : ImageView = findViewById(R.id.imageView)
        
        btn1.setOnClickListener {
            val frameAni = imageView.background as AnimationDrawable
            frameAni.start()
        }

        btn2.setOnClickListener {
            val frameAni = imageView.background as AnimationDrawable
            frameAni.stop()
        }
    }
}