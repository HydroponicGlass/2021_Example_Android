package com.hydroponicglass.customradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radio_buy_sell_group : RadioGroup = findViewById(R.id.radio_buy_sell_group)

        radio_buy_sell_group.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){
                R.id.btn_buy -> Log.d("log", "buy")
                R.id.btn_sell -> Log.d("log", "sell")
            }
        }
    }
}