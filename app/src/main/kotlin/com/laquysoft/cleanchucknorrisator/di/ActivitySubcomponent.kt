package com.laquysoft.cleanchucknorrisator.di

import dagger.Subcomponent

@ForActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivitySubcomponent {
    //TODO: here you inject your activities
    //fun inject(yourActivity: YourActivity)

    @Subcomponent.Builder
    interface Builder : SubcomponentBuilder<ActivitySubcomponent> {
        fun activityModule(activityModule: ActivityModule): Builder
    }
}
