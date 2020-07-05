package com.abhay.shadicardmatcher

import com.abhay.shadicardmatcher.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val daggerAppComponent = DaggerAppComponent.factory().create(applicationContext)
        daggerAppComponent.inject(this);
        return daggerAppComponent
    }

}