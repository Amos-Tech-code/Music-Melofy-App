package com.amos_tech_code.musicmelofy

import android.app.Application
import com.amos_tech_code.musicmelofy.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule
import org.koin.ksp.generated.module

class MelofyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MelofyApp)
            modules(defaultModule, NetworkModule().module)
        }
    }
}