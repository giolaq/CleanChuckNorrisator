package com.laquysoft.cleanchucknorrisator.di

import dagger.Subcomponent

@ForActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivitySubcomponent {

    @Subcomponent.Builder
    interface Builder : SubcomponentBuilder<ActivitySubcomponent> {
        fun activityModule(activityModule: ActivityModule): Builder
    }
}
