package com.laquysoft.cleanchucknorrisator.di

import com.laquysoft.cleanchucknorrisator.BaseActivity
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: BaseActivity) {
    @Provides @ForActivity
    fun provideActivity(): BaseActivity = activity
}
