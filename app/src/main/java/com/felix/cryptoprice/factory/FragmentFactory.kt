package com.felix.cryptoprice.factory

import androidx.fragment.app.FragmentFactory
import com.felix.cryptoprice.ui.detail.DetailFragment
import com.felix.cryptoprice.ui.home.HomeFragment
import com.felix.cryptoprice.ui.home.trending.TrendingFragment
import com.felix.cryptoprice.ui.splash.SplashFragment

class FragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            SplashFragment::class.java.name -> {
                SplashFragment()
            }

            HomeFragment::class.java.name -> {
                HomeFragment()
            }

            TrendingFragment::class.java.name -> {
                TrendingFragment()
            }
            DetailFragment::class.java.name -> {
                DetailFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}