package com.laquysoft.cleanchucknorrisator.features.chooser

import com.laquysoft.cleanchucknorrisator.framework.network.RestApi
import dagger.Lazy
import io.reactivex.Single
import javax.inject.Inject

interface JokeDataSource : JokeRepository {

    class Factory
    @Inject constructor(val network: Lazy<Network>) {
        fun network(): Network = network.get()
    }

    class Network
    @Inject constructor(private val restApi: RestApi) : JokeDataSource {
        val EXPLICIT = "explicit"
        override fun joke(noExplicit: Boolean?): Single<Joke> {
            if (noExplicit == false) {
                return restApi.randomJoke(null).map { jokeEntity -> jokeEntity.toJoke() }

            } else {
                return restApi.randomJoke(EXPLICIT).map { jokeEntity -> jokeEntity.toJoke() }
            }
        }

        override fun jokeChangedName(name: String?, surname: String?, noExplicit: Boolean?): Single<Joke> {
            if (noExplicit == false) {
                return restApi.randomJokeChangedName(name, surname, null).map { jokeEntity -> jokeEntity.toJoke() }

            } else {
                return restApi.randomJokeChangedName(name, surname, EXPLICIT).map { jokeEntity -> jokeEntity.toJoke() }
            }
        }

        override fun jokes(number: Int, noExplicit: Boolean?): Single<List<Joke>> {
            if (noExplicit == false) {
                return restApi.randomJokes(number, null).map { jokeEntity -> jokeEntity.toJokeList() }

            } else {
                return restApi.randomJokes(number, EXPLICIT).map { jokeEntity -> jokeEntity.toJokeList() }
            }
        }

    }

}