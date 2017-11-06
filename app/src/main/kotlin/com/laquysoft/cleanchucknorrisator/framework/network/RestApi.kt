package com.laquysoft.cleanchucknorrisator.framework.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApi
@Inject constructor(retrofit: Retrofit) : JokesApi {

    private val jokesApi by lazy { retrofit.create(JokesApi::class.java) }

    override fun randomJoke(noExplicit: String?) = jokesApi.randomJoke(noExplicit)
    override fun randomJokes(number: Int, noExplicit: String?) = jokesApi.randomJokes(number, noExplicit)
    override fun randomJokeChangedName(name: String?, surname: String?, noExplicit: String?) = jokesApi.randomJokeChangedName(name, surname, noExplicit)
}
