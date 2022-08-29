package com.felix.cryptoprice.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.felix.cryptoprice.ui.detail.DetailFragment
import com.felix.cryptoprice.ui.home.convert.ConvertFragment
import com.felix.cryptoprice.ui.home.trending.TrendingFragment

class FragmentFactory : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String)=
        when(className){
            TrendingFragment::class.java.name -> {
                TrendingFragment()
            }
            ConvertFragment::class.java.name -> {
                ConvertFragment()
            }
            DetailFragment::class.java.name -> {
                DetailFragment()
            }
            else -> super.instantiate(classLoader, className)
        }
}