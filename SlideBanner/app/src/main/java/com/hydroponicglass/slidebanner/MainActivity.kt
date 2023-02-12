package com.hydroponicglass.slidebanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.hydroponicglass.slidebanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<Pair<Int, String>>().let {
            it.add(Pair(android.R.color.holo_blue_dark, "page1"))
            it.add(Pair(android.R.color.holo_green_dark, "page2"))
            it.add(Pair(android.R.color.holo_orange_dark, "page3"))
            it // need return
        }

        binding.textView.text = getString(R.string.banner, 1, list.size)
        binding.viewPager.adapter = ViewPagerAdapter(list)
        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.textView.text = getString(R.string.banner, position+1, list.size)
            }
        })
    }
}