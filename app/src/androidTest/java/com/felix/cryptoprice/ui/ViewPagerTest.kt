package com.felix.cryptoprice.ui

import com.felix.cryptoprice.R
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.felix.cryptoprice.factory.FragmentFactory
import com.felix.cryptoprice.ui.home.HomeFragment
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ViewPagerTest {
    @Test
    fun viewPager(){
        val fragmentFactory = FragmentFactory()
        val scenario = launchFragmentInContainer<HomeFragment>(
            factory = fragmentFactory
        )
        Espresso.onView(allOf(withId(R.id.tab_layout)))
            .perform(click())
    }
}