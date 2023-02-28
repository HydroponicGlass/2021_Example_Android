package com.hydroponicglass.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hydroponicglass.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val customViewModel = CustomViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetObserver()
        SetClickListener()
    }

    fun SetObserver(){
        customViewModel.data.observe(this, {
            binding.textView1.text = it.text1
            binding.textView2.text = it.text2
        })
    }

    fun SetClickListener(){
        binding.button.setOnClickListener{
            customViewModel.getData()
        }
    }
}