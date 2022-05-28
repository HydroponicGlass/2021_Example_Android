package com.hydroponicglass.listenerandcallback

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Dialog(private val listener : DialogListener){
    fun ShowDialog(context : Context)
    {
        val builder = AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        builder
            .setTitle("title")
            .setPositiveButton("ok",
                DialogInterface.OnClickListener { dialog, id ->
                    val testData : Int = 100
                    listener.onOkClick(testData)
                })
        builder.create()
        builder.show()
    }

    interface DialogListener{
        fun onOkClick(data : Int)
    }
}