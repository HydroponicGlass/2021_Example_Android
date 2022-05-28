package com.hydroponicglass.listenerandcallback

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = Dialog(object : Dialog.DialogListener {
            override fun onOkClick(data: Int) {
                Toast.makeText(this@MainActivity, "test", Toast.LENGTH_SHORT).show()
            }
        })
        dialog.ShowDialog(this)
    }
}