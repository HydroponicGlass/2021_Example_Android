package com.hydroponicglass.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var content = arrayListOf<Contents>(
        Contents("title1", "subtitle1"),
        Contents("title2", "subtitle2"),
        Contents("title3", "subtitle3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView : ListView = findViewById(R.id.listview)
        listView.adapter = ListAdapter(this, content)
    }
}