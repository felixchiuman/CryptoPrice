package com.felix.cryptoprice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.felix.cryptoprice.factory.FragmentFactory
import com.felix.cryptoprice.ui.splash.SplashFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
//            val id = 1
//            val bundle = Bundle()
//            bundle.putInt("id", id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_host, SplashFragment())
                .commit()
        }
    }
}