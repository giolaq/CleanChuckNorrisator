package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import com.laquysoft.cleanchucknorrisator.features.chooser.Joke

/**
 * Created by joaobiriba on 03/11/2017.
 */
data class JokesResponse(private val type: String, private val value: List<JokeEntity>) {

    fun toJokeList(): List<Joke> {
        this@JokesResponse.let {
            return it.value.map {
                Joke.create {
                    id = it.id
                    joke = it.joke
                    categories = it.categories
                }
            }
        }

    }


    data class JokeEntity(val id: Int, val joke: String, val categories: List<String>)
}