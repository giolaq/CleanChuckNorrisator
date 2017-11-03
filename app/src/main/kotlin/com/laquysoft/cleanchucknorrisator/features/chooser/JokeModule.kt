package com.laquysoft.cleanchucknorrisator.features.chooser

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class JokeModule {
    @Provides
    @Singleton
    fun provideJokeRepository(repository: JokeRepository.Source): JokeRepository = repository
}