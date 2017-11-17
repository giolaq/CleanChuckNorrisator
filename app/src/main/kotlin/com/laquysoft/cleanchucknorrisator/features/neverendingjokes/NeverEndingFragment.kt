package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import android.app.Dialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import com.laquysoft.cleanchucknorrisator.BaseFragment
import com.laquysoft.cleanchucknorrisator.InfiniteScrollListener
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.navigation.Navigator
import kotlinx.android.synthetic.main.fragment_jokes.*
import kotlinx.android.synthetic.main.random_joke_dialog.*
import javax.inject.Inject


/**
 * Created by joaobiriba on 06/11/2017.
 */

class NeverEndingFragment : BaseFragment(), NeverEndingView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var neverEndingPresenter: NeverEndingPresenter
    @Inject lateinit var neverEndingAdapter: NeverEndingAdapter

    private lateinit var dialog: Dialog
    private var isShowingDialog = false
    private var jokeToShow: String = ""

    override fun layoutId() = R.layout.fragment_jokes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        if (firstTimeCreated(savedInstanceState)) {
            initializeView(); loadJokes()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        neverEndingPresenter.destroy()
    }

    override fun renderList(jokes: List<Joke>) {
        for (joke in jokes) {
            Log.d("NeverEndingFragment", "Joke " + joke.joke)
        }
        neverEndingAdapter.addAll(jokes)
    }


    override fun showLoading() {
        //TODO: implement method
    }

    override fun hideLoading() {
        //TODO: implement method
    }

    private fun initializeView() {
        val linearLayoutManager = LinearLayoutManager(activity, StaggeredGridLayoutManager.VERTICAL, false)
        jokesList.layoutManager = linearLayoutManager
        jokesList.adapter = neverEndingAdapter
        neverEndingPresenter.neverEndingView = this
        neverEndingAdapter.clickListener = { joke -> neverEndingPresenter.onJokeClick(joke) }

        jokesList.addOnScrollListener(InfiniteScrollListener({ loadJokes() }, linearLayoutManager, neverEndingAdapter))

        if (isShowingDialog) {
            showJokeDialog(jokeToShow);
        }
    }

    private fun loadJokes() = neverEndingPresenter.loadJokes()

    override fun displayDetails(joke: Joke) {
        showJokeDialog(joke.joke)
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


}