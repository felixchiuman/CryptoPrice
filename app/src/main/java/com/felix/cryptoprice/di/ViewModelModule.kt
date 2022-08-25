package com.felix.cryptoprice.di

import com.felix.cryptoprice.ui.detail.DetailViewModel
import com.felix.cryptoprice.ui.home.trending.TrendingViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    singleOf(::TrendingViewModel)
    singleOf(::DetailViewModel)
}