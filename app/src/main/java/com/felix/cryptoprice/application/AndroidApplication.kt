package com.felix.cryptoprice.application

import android.app.Application
import com.felix.cryptoprice.di.networkModule
import com.felix.cryptoprice.di.repositoryModule
import com.felix.cryptoprice.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(
                listOf(
                    networkModule, repositoryModule, viewModelModule
                )
            )
        }
    }
}