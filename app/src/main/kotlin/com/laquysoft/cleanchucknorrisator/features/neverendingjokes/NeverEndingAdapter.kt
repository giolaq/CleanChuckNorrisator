package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.laquysoft.cleanchucknorrisator.R
import com.laquysoft.cleanchucknorrisator.features.chooser.Joke
import com.laquysoft.cleanchucknorrisator.framework.extension.inflate
import kotlinx.android.synthetic.main.item_joke.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by joaobiriba on 06/11/2017.
 */
class NeverEndingAdapter
@Inject constructor() : RecyclerView.Adapter<NeverEndingAdapter.ViewHolder>() {

    internal var collection: List<Joke> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_joke))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(joke: Joke) {
            itemView.jokeText.text = joke.joke
        }
    }
}