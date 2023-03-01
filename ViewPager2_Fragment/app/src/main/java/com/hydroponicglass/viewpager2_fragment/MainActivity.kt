package com.hydroponicglass.viewpager2_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.hydroponicglass.viewpager2_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentPagerAdapter = PagerFragmentStateAdapter(this)
        fragmentPagerAdapter.addFragment(Fragment1())
        fragmentPagerAdapter.addFragment(Fragment2())


        binding.viewPager.adapter = fragmentPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = "Tab ${position+1}"
        }.attach()

//        binding.viewPager.setUserInputEnabled(false)
    }
}