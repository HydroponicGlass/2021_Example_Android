package com.hydroponicglass.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personDb = PersonDatabase.GetInstance(this)
        val input = PersonTable(1, "mark", 20)
        CoroutineScope(Dispatchers.IO).launch {
            personDb?.personDao()?.Insert(input)
            Log.d("test", "${personDb?.personDao()?.GetAll()}")
        }
    }
}