package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import javax.inject.Inject

/**
 * Created by joaobiriba on 06/11/2017.
 */
class NeverEndingPresenter
@Inject constructor(private val getRandomJokes: GetRandomJokes) {

    internal lateinit var neverEndingView: NeverEndingView

    fun destroy() {
        getRandomJokes.dispose()
        neverEndingView.dispose()
    }

    fun loadJokes() {
        neverEndingView.showLoading()
        getRandomJokes.execute(
                { jokes -> neverEndingView.renderList(jokes)
                    neverEndingView.hideLoading() },
                { TODO() })
    }

}