package com.hydroponicglass.dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("Title")
            .setMessage("Message")
            .setPositiveButton("Start",
                DialogInterface.OnClickListener { dialog, id ->
                    // START THE GAME!
                })
//            .setNegativeButton("Cancel",
//                DialogInterface.OnClickListener { dialog, id ->
//                    // User cancelled the dialog
//                })
        // Create the AlertDialog object and return it
        builder.create()
        builder.show()
    }
}