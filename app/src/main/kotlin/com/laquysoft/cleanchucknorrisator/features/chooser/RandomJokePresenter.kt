package com.laquysoft.cleanchucknorrisator.features.chooser


import com.laquysoft.cleanchucknorrisator.AndroidApplication
import com.laquysoft.cleanchucknorrisator.Prefs
import com.laquysoft.cleanchucknorrisator.prefs
import javax.inject.Inject

/**
 * Created by joaobiriba on 03/11/2017.
 */

class RandomJokePresenter
@Inject constructor(private val getRadomJoke: GetRandomJoke) {

    internal lateinit var randomJokeView: RandomJokeView

    fun destroy() {
        getRadomJoke.dispose()
        randomJokeView.dispose()
    }

    fun loadRandomJoke() {
        randomJokeView.showLoading()
        getRadomJoke.execute(
                { joke ->
                    randomJokeView.renderJoke(joke)
                    randomJokeView.hideLoading()
                },
                { TODO() })
    }

    fun setNoExplicitFilter(check: Boolean) {
        prefs.noExplicit = check
    }
}