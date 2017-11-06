package com.laquysoft.cleanchucknorrisator.features.changename

import android.util.Log
import com.laquysoft.cleanchucknorrisator.features.chooser.RandomJokeView
import javax.inject.Inject

/**
 * Created by joaobiriba on 03/11/2017.
 */
class ChangedNamePresenter
@Inject constructor(private val getChangedNameRandomJoke: GetChangedNameRandomJoke) {

    internal lateinit var randomJokeView: RandomJokeView

    val delimiter: String = "\\ +"

    fun destroy() {
        getChangedNameRandomJoke.dispose()
        randomJokeView.dispose()
    }

    fun loadRandomJokeChangedName(textInput: String) {
        val inputList = textInput.trim().split(delimiter.toRegex())
        if(inputList.isEmpty()) {
            //TODO: dialog to user
        } else {
            val name = inputList.get(0)
            var surname: String?= null
            if (inputList.size>1) surname = inputList.get(1)
            Log.d("ChangedNamePresenter", inputList.toString())
            randomJokeView.showLoading()
            getChangedNameRandomJoke.execute(
                    { joke -> randomJokeView.renderJoke(joke)
                        randomJokeView.hideLoading() },
                    { TODO() }, GetChangedNameRandomJoke.Params(name, surname))

        }
    }
}