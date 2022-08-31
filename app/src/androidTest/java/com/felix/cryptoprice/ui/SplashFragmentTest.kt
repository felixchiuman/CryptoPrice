package com.felix.cryptoprice.ui

import com.felix.cryptoprice.R
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.felix.cryptoprice.factory.FragmentFactory
import com.felix.cryptoprice.ui.splash.SplashFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SplashFragmentTest{
    @Test
    fun splash(){
        val fragmentFactory = FragmentFactory()
        val scenario = launchFragmentInContainer<SplashFragment>(
            factory = fragmentFactory
        )

        Espresso.onView(withId(R.id.textview))
            .check(ViewAssertions.matches(withText("CoinMarketCap")))
    }
}