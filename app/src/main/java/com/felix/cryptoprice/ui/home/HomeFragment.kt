package com.felix.cryptoprice.ui.home

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.felix.cryptoprice.databinding.FragmentHomeBinding
import com.felix.cryptoprice.ui.base.BaseFragment
import com.felix.cryptoprice.ui.home.cap.MarketCapFragment
import com.felix.cryptoprice.ui.home.trending.TrendingFragment
import com.google.android.material.tabs.TabLayout

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewPager = binding.viewPager as ViewPager
        var tabLayout = binding.tabLayout as TabLayout

        val fragmentAdapter = FragmentAdapter(parentFragmentManager)
        fragmentAdapter.addFragment(TrendingFragment(), "Trending")
        fragmentAdapter.addFragment(MarketCapFragment(), "Market Cap")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}