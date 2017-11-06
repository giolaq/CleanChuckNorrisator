package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.framework.view.LoadingView

/**
 * Created by joaobiriba on 06/11/2017.
 */
interface NeverEndingView : LoadingView {
    fun renderList(jokes: List<Joke>)
    fun dispose()
}