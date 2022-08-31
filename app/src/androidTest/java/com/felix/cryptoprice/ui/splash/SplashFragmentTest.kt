package com.felix.cryptoprice.ui.splash

import com.felix.cryptoprice.R
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.felix.cryptoprice.factory.FragmentFactory
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class SplashFragmentTest{

    @Test
    fun test(){
        val fragmentFactory = FragmentFactory()
        val scenario = launchFragmentInContainer<SplashFragment>(
            factory = fragmentFactory
        )
        onView(withId(R.id.textView)).check(matches(withText("CoinMarketCap")))
    }
}