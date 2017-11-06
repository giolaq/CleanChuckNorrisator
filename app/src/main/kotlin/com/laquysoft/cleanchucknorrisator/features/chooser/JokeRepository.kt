package com.laquysoft.cleanchucknorrisator.features.chooser

import io.reactivex.Single
import javax.inject.Inject

interface JokeRepository {
    fun joke(noExplicit: Boolean?): Single<Joke>
    fun jokes(number: Int, noExplicit: Boolean? ): Single<List<Joke>>
    fun jokeChangedName(name: String?, surname: String?, noExplicit: Boolean?): Single<Joke>

    class Source
    @Inject constructor(private val dataSourceFactory: JokeDataSource.Factory) : JokeRepository {
        override fun joke(noExplicit: Boolean?) = dataSourceFactory.network().joke(noExplicit)
        override fun jokes(number: Int, noExplicit: Boolean?) = dataSourceFactory.network().jokes(number, noExplicit)
        override fun jokeChangedName(name: String?, surname: String?, noExplicit: Boolean?) = dataSourceFactory.network().jokeChangedName(name, surname, noExplicit)
    }
}