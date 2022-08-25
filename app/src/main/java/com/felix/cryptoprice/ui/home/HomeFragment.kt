package com.felix.cryptoprice.ui.home

import android.os.Bundle
import android.view.View
import com.felix.cryptoprice.databinding.FragmentHomeBinding
import com.felix.cryptoprice.ui.base.BaseFragment
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
                    tab.text = "Price Convertion"
                }
            }
        }.attach()
    }
}