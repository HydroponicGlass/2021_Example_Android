package com.hydroponicglass.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavi : BottomNavigationView = findViewById(R.id.bottomNavi)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, fragment1())
            .commit()

        bottomNavi.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_1 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, fragment1())
                        .commit()
                }
                R.id.menu_2 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, fragment2())
                        .commit()
                }
                R.id.menu_3 -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment, fragment3())
                        .commit()
                }
            }
            true
        }


    }
}