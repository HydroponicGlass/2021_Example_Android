package com.hydroponicglass.bottomsheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<TextView>(R.id.button)

        button.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(
                this@MainActivity, R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.layout_bottom_sheet,
                findViewById(R.id.bottomSheet) as LinearLayout?
            )

            bottomSheetView.findViewById<View>(R.id.button).setOnClickListener {
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }
    }
}