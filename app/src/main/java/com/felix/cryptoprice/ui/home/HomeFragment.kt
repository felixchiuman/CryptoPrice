package com.felix.cryptoprice.ui.home

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.felix.cryptoprice.databinding.FragmentHomeBinding
import com.felix.cryptoprice.ui.base.BaseFragment
import com.felix.cryptoprice.ui.home.cap.MarketCapFragment
import com.felix.cryptoprice.ui.home.trending.TrendingFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = FragmentAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            when(position){
                0 -> {
                    tab.text = "Tending"
                }
                1 -> {
                    tab.text = "Market Cap"
                }
            }
        }.attach()
    }
}