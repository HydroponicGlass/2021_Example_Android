package com.hydroponicglass.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        val list = arrayListOf(
            ListItem("abc", "cba"),
            ListItem("abc2", "cba2"),
            ListItem("abc3", "cba3"),
            ListItem("abc4", "cba4"),
            ListItem("abc5", "cba5"),
            ListItem("abc6", "cba6"),
            ListItem("abc7", "cba7"),
            ListItem("abc8", "cba8"),
            ListItem("abc9", "cba9"),
        )

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = RecyclerViewAdapter(list)
    }
}