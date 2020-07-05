package com.abhay.shadicardmatcher.di.module

import androidx.lifecycle.ViewModel
import com.abhay.shadicardmatcher.di.utils.ViewModelBuilder
import com.abhay.shadicardmatcher.di.utils.ViewModelKey
import com.abhay.shadicardmatcher.ui.ShadiCardMatcherFragment
import com.abhay.shadicardmatcher.ui.ShadiCardMatcherViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class ShadiMatcherFragmentModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun shadiCardMatcherFragment(): ShadiCardMatcherFragment

    @Binds
    @IntoMap
    @ViewModelKey(ShadiCardMatcherViewModel::class)
    abstract fun bindViewModel(viewmodel: ShadiCardMatcherViewModel): ViewModel

}