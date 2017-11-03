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
        override fun joke(): Single<Joke> =
                restApi.randomJoke().map { jokeEntity -> jokeEntity.toJoke()  }

        override fun jokeChangedName(name: String?, surname: String?): Single<Joke> =
                restApi.randomJokeChangedName(name, surname).map { jokeEntity -> jokeEntity.toJoke()  }

        override fun jokes(number: Int): Single<List<Joke>> =
                restApi.randomJokes(number).map { jokeEntity -> jokeEntity.toJokeList() }

    }

}