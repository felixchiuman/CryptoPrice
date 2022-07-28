package com.felix.cryptoprice.di

import com.felix.cryptoprice.data.Repository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::Repository)
}