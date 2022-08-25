package com.felix.cryptoprice.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.felix.cryptoprice.ui.home.convert.ConvertFragment
import com.felix.cryptoprice.ui.home.trending.TrendingFragment

class FragmentAdapter(fragment: Fragment)
    : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position) {
            0 -> fragment = TrendingFragment()
            1 -> fragment = ConvertFragment()
        }
        return fragment
    }

}