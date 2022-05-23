package com.hydroponicglass.dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dialog_editText = layoutInflater.inflate(R.layout.dialog_edittext, null)
        val builder = AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        builder
            .setTitle("Title")
            .setMessage("MessageMessageMessageMessageMessageMessage")
            .setView(dialog_editText)
            .setPositiveButton("Start",
                DialogInterface.OnClickListener { dialog, id ->
                    var editText = dialog_editText.findViewById<EditText>(R.id.editText)
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