package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import com.laquysoft.cleanchucknorrisator.BaseFragment
import com.laquysoft.cleanchucknorrisator.InfiniteScrollListener
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.navigation.Navigator
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_jokes.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by joaobiriba on 06/11/2017.
 */

class NeverEndingFragment : BaseFragment(), NeverEndingView {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var neverEndingPresenter: NeverEndingPresenter
    @Inject lateinit var neverEndingAdapter: NeverEndingAdapter

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

    override fun dispose() {
        //TODO: dispose view resources
    }

    private fun initializeView() {
        val linearLayoutManager = LinearLayoutManager(activity, StaggeredGridLayoutManager.VERTICAL, false)
        jokesList.layoutManager = linearLayoutManager
        jokesList.adapter = neverEndingAdapter
        neverEndingPresenter.neverEndingView = this

        jokesList.addOnScrollListener(InfiniteScrollListener({ loadJokes() }, linearLayoutManager, neverEndingAdapter))
    }

    private fun loadJokes() = neverEndingPresenter.loadJokes()
}