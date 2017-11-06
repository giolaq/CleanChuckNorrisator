package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import kotlinx.android.synthetic.main.item_joke.view.*
import javax.inject.Inject
import kotlin.properties.Delegates


/**
 * Created by joaobiriba on 06/11/2017.
 */
class NeverEndingAdapter
@Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM = 1
    private val TYPE_FOOTER = 2

    var showLoader = false
        set(value) { field = value }

    internal var collection: MutableList<Joke> by Delegates.observable(mutableListOf<Joke>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {

        // If no items are present, there's no need for loader
        if (collection.size == 0) {
            return 0;
        }

        return collection.size + 1

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ITEM) {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_joke, viewGroup,
                    false)
            return ViewHolder(view)
        } else if (viewType == TYPE_FOOTER) {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.footer_layout,
                    viewGroup, false)
            return ProgressViewHolder(view)
        }

        throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")

    }


    override fun onBindViewHolder(vh: RecyclerView.ViewHolder, position: Int) {

        // Loader ViewHolder
        if (vh is ProgressViewHolder) {
            val loaderViewHolder = vh as ProgressViewHolder
            if (showLoader) {
                Log.d("NeverEndingAdapter", " load")
                loaderViewHolder.progressBar.setVisibility(View.VISIBLE)
            } else {
                loaderViewHolder.progressBar.setVisibility(View.GONE)
                Log.d("NeverEndingAdapter", " gone")
            }
            return
        }

        (vh as ViewHolder).bind(collection[position])


    }

    override fun getItemViewType(position: Int): Int {
        // loader can't be at position 0
        // loader can only be at the last position
        if (position != 0 && position == getItemCount() - 1) {

            return TYPE_FOOTER
        }
        return TYPE_ITEM
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(joke: Joke) {
            itemView.jokeText.text = joke.joke
        }
    }

    fun addAll(moreItems: List<Joke>) {
        collection.addAll(moreItems)
        notifyDataSetChanged()
    }


    class ProgressViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var progressBar: ProgressBar

        init {
            progressBar = v.findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        }
    }


}