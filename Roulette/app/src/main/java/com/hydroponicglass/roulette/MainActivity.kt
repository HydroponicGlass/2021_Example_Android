package com.hydroponicglass.roulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val button = findViewById<Button>(R.id.button)

        var toDegrees = (720).toFloat() // when true, animation stay stop state
        var duration = (1000).toLong() // animation duration time(ms)

        val animListener = object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationStart(animation: Animation?) {
                Log.d("test", "Start")
            }
            override fun onAnimationEnd(animation: Animation?) {
                Log.d("test", "End")
            }
        }

        // params : start degree, rotate degree, x axis type, x axis value, y axis type, y axis value
        var rotateAnim = RotateAnimation(
            0f, toDegrees,
            Animation.RELATIVE_TO_SELF, 0.5f, // 0 : left, 1 : right, 0.5 : center
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnim.duration = duration
        rotateAnim.fillAfter = true
        rotateAnim.setAnimationListener(animListener)

        button.setOnClickListener{
            imageView.startAnimation(rotateAnim)
            Log.d("test", "button selected")
        }

    }
}