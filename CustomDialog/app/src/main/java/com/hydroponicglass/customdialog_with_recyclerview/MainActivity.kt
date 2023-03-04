package com.hydroponicglass.customdialog_with_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hydroponicglass.customdialog_with_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val dialog = CustomDialog(this)
            dialog.ShowDialog("titletitle")
        }
    }
}