package com.hydroponicglass.bottomsheetdialog_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ListView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_select = findViewById<Button>(R.id.button_select)

        button_select.setOnClickListener {
            val list = ArrayList<String>()
            list.add("1")
            list.add("2")
            list.add("3")
            list.add("4")

            val bottomSheetDialog = BottomSheetDialog(
                this, R.style.BottomSheetDialogTheme)

            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.layout_bottom_sheet, null)

            val listViewAdapter = ListViewAdapter(this, list, bottomSheetDialog)
            bottomSheetView.findViewById<ListView>(R.id.listView).adapter = listViewAdapter
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }
    }
}