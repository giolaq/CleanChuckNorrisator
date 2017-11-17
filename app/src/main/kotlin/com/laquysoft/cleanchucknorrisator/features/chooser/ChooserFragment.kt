package com.laquysoft.cleanchucknorrisator.features.chooser

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import com.laquysoft.cleanchucknorrisator.BaseFragment
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_chooser.*
import kotlinx.android.synthetic.main.random_joke_dialog.*
import javax.inject.Inject

class ChooserFragment : BaseFragment(), RandomJokeView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var randomJokePresenter: RandomJokePresenter

    private lateinit var dialog: Dialog
    private var isShowingDialog = false
    private var jokeToShow: String = ""

    override fun layoutId() = R.layout.fragment_chooser

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
        randomJokePresenter.destroy()
    }


    override fun showLoading() {
        network_progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        network_progressBar.visibility = View.GONE
    }

    private fun initializeView() {
        randomJokePresenter.randomJokeView = this

        button_random.setOnClickListener { loadRandomJoke() }

        button_change_name.setOnClickListener { navigator.showChangeName(activity) }

        button_ne_list.setOnClickListener { navigator.showNEList(activity) }

        explicit_checkBox.setOnClickListener { checkBox ->
            checkBox as CheckBox
            val check = checkBox.isChecked
            randomJokePresenter.setNoExplicitFilter(check)
        }

        if (isShowingDialog) {
            showJokeDialog(jokeToShow);
        }
    }

    override fun renderJoke(joke: Joke) {
        Log.d("ChooserFragment", joke.joke)
        showJokeDialog(joke.joke)
    }


    private fun showJokeDialog(joke: String) {
        dialog = Dialog(activity)
        dialog.setContentView(R.layout.random_joke_dialog)
        dialog.setTitle("Random joke")
        dialog.dismiss_button.setOnClickListener {
            dialog.dismiss()
            isShowingDialog = false
        }
        dialog.joke.setText(joke)
        dialog.show()
        isShowingDialog = true
        jokeToShow = joke
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dialog = Dialog(activity)

        if (savedInstanceState != null) {
            isShowingDialog = savedInstanceState.getBoolean("IS_SHOWING_DIALOG", false);
            jokeToShow = savedInstanceState.getString("JOKE", "No Joke");
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean("IS_SHOWING_DIALOG", isShowingDialog);
        outState?.putString("JOKE", jokeToShow);
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    private fun loadRandomJoke() = randomJokePresenter.loadRandomJoke()
}