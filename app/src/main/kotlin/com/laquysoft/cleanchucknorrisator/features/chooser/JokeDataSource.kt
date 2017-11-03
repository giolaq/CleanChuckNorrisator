package com.laquysoft.cleanchucknorrisator.features.chooser

import com.laquysoft.cleanchucknorrisator.framework.network.RestApi
import dagger.Lazy
import io.reactivex.Single
import javax.inject.Inject

interface JokeDataSource : JokeRepository {

    class Factory
    @Inject constructor(val network: Lazy<Network>, val disk: Lazy<Disk>) {
        fun network(): Network = network.get()
        fun disk(): Disk = disk.get()
    }

    class Network
    @Inject constructor(private val restApi: RestApi) : JokeDataSource {
        override fun joke(): Single<Joke> =
                restApi.randomJoke().map { jokeEntity -> jokeEntity.toJoke()  }
    }

    class Disk
    @Inject constructor() : JokeDataSource {
        override fun joke(): Single<Joke> = TODO()
    }
}