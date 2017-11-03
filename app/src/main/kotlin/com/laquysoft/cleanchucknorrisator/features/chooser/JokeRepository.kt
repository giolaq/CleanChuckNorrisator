package com.laquysoft.cleanchucknorrisator.features.chooser

import io.reactivex.Single
import javax.inject.Inject

interface JokeRepository {
    fun joke(): Single<Joke>
    fun jokeChangedName(name: String?, surname: String?): Single<Joke>

    class Source
    @Inject constructor(private val dataSourceFactory: JokeDataSource.Factory) : JokeRepository {
        override fun joke() = dataSourceFactory.network().joke()
        override fun jokeChangedName(name: String?, surname: String?) = dataSourceFactory.network().jokeChangedName(name, surname)
    }
}