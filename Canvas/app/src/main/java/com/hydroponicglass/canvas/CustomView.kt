package com.hydroponicglass.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class CustomView(text : String, context : Context) : View(context) {
    val drawValue : String
    init {
        this.drawValue = text
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        val rect = RectF()
        rect.set(0f, 0f, 200f, 200f)
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        canvas?.drawRoundRect(rect, 20f, 20f, paint)

        paint.color = Color.RED
        paint.textSize = 50f
        canvas?.drawText(drawValue, 50f, 50f, paint)
    }
}