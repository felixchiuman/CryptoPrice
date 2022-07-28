package com.felix.cryptoprice.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.felix.cryptoprice.ui.home.cap.MarketCapFragment
import com.felix.cryptoprice.ui.home.trending.TrendingFragment

class FragmentAdapter(fragment: Fragment)
    : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position) {
            0 -> fragment = TrendingFragment()
            1 -> fragment = MarketCapFragment()
        }
        return fragment
    }

}