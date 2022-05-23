package com.hydroponicglass.dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.view.marginLeft

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText = EditText(this)
        val builder = AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        builder
            .setTitle("Title")
            .setMessage("MessageMessageMessageMessageMessageMessage")
            .setView(editText)
            .setPositiveButton("Start",
                DialogInterface.OnClickListener { dialog, id ->
                    Log.d("test", editText.text.toString())
                })
            .setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        // Create the AlertDialog object and return it
        builder.create()
        builder.show()
    }
}