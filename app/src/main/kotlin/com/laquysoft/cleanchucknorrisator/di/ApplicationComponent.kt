package com.laquysoft.cleanchucknorrisator.di

import com.laquysoft.cleanchucknorrisator.AndroidApplication
import com.laquysoft.cleanchucknorrisator.di.ApplicationModule
import com.laquysoft.cleanchucknorrisator.features.changename.ChangedNameFragment
import com.laquysoft.cleanchucknorrisator.features.chooser.ChooserFragment
import com.laquysoft.cleanchucknorrisator.features.chooser.JokeModule
import com.laquysoft.cleanchucknorrisator.features.neverendingjokes.NeverEndingFragment
import com.laquysoft.cleanchucknorrisator.navigation.RouteActivity
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApplicationBinders::class, JokeModule::class))
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)
    fun inject(chooserFragment: ChooserFragment)
    fun inject(changedNameFragment: ChangedNameFragment)
    fun inject(neverEndingFragment: NeverEndingFragment)

    fun subComponentBuilders(): Map<Class<*>, Provider<SubcomponentBuilder<*>>>
}
