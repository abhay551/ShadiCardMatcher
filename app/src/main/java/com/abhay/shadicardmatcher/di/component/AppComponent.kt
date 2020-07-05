package com.abhay.shadicardmatcher.di.component


import android.content.Context
import com.abhay.shadicardmatcher.BaseApplication
import com.abhay.shadicardmatcher.base.BaseActivity
import com.abhay.shadicardmatcher.di.module.AppModule
import com.abhay.shadicardmatcher.di.module.ShadiMatcherFragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ShadiMatcherFragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(baseActivity: BaseActivity)
}