package com.laquysoft.cleanchucknorrisator.framework.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApi
@Inject constructor(retrofit: Retrofit) : JokesApi {
    private val jokesApi by lazy { retrofit.create(JokesApi::class.java) }

    override fun randomJoke() = jokesApi.randomJoke()
    override fun randomJokeChangedName(name: String?, surname: String?) = jokesApi.randomJokeChangedName(name, surname)
}
