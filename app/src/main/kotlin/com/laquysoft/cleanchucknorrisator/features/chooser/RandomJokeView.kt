package com.laquysoft.cleanchucknorrisator.features.chooser

import com.laquysoft.cleanchucknorrisator.framework.view.LoadingView

interface RandomJokeView : LoadingView {
    fun renderJoke(joke: Joke)
    fun dispose()
}