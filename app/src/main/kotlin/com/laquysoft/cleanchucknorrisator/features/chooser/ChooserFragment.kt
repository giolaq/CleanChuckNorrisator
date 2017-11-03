package com.laquysoft.cleanchucknorrisator.features.chooser

import android.app.Dialog
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import com.laquysoft.cleanchucknorrisator.BaseFragment
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_chooser.*
import kotlinx.android.synthetic.main.random_joke_dialog.*
import javax.inject.Inject

class ChooserFragment : BaseFragment(), RandomJokeView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var randomJokePresenter: RandomJokePresenter

    override fun layoutId() = R.layout.fragment_chooser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        initializeView()
    }

    override fun onDestroy() {
        super.onDestroy()
        randomJokePresenter.destroy()
    }


    override fun showLoading() {
        //TODO: implement method
    }

    override fun hideLoading() {
        //TODO: implement method
    }

    override fun dispose() {
        //TODO: dispose view resources
    }

    private fun initializeView() {
        randomJokePresenter.randomJokeView = this

        button_random.setOnClickListener { loadRandomJoke() }

    }

    override fun renderJoke(joke: Joke) {
        Log.d("ChooserFragment", joke.joke)
        showJokeDialog(joke.joke)
    }

    private fun showJokeDialog(joke: String) {
        val dialog = Dialog(activity)
        dialog.setContentView(R.layout.random_joke_dialog)
        dialog.setTitle("Random joke")
        dialog.dismiss_button.setOnClickListener { dialog.dismiss() }
        dialog.joke.setText(joke)
        dialog.show()
    }


    private fun loadRandomJoke() = randomJokePresenter.loadRandomJoke()
}