package com.laquysoft.cleanchucknorrisator.features.changename

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import com.laquysoft.cleanchucknorrisator.BaseFragment
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.features.chooser.RandomJokePresenter
import com.laquysoft.cleanchucknorrisator.features.chooser.RandomJokeView
import com.laquysoft.cleanchucknorrisator.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_changed_name.*
import kotlinx.android.synthetic.main.fragment_chooser.*
import kotlinx.android.synthetic.main.random_joke_dialog.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class ChangedNameFragment : BaseFragment(), RandomJokeView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var changedNamePresenter: ChangedNamePresenter

    override fun layoutId() = R.layout.fragment_changed_name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    override fun onDestroy() {
        super.onDestroy()
        changedNamePresenter.destroy()
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
        changedNamePresenter.randomJokeView = this

        button_submit.setOnClickListener {
            loadChangedNameJoke(name_edit.text.toString()) }

    }

    override fun renderJoke(joke: Joke) {
        Log.d("ChangedNameFragment", joke.joke)
        showJokeDialog(joke.joke)
    }

    private fun showJokeDialog(joke: String) {
        val dialog = Dialog(this.activity)
        dialog.setContentView(R.layout.random_joke_dialog)
        dialog.setTitle("Random joke")
        dialog.dismiss_button.setOnClickListener { dialog.dismiss() }
        dialog.joke.setText(joke)
        dialog.show()
    }


    private fun loadChangedNameJoke(textInput: String) = changedNamePresenter.loadRandomJokeChangedName(textInput)
}