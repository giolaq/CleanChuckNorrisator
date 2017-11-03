package com.laquysoft.cleanchucknorrisator.navigation

import android.content.Context

import com.laquysoft.cleanchucknorrisator.features.chooser.ChooserActivity

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator
@Inject constructor() {


    fun showChooser(context: Context) = context.startActivity(ChooserActivity.callingIntent(context))
    //private fun showChangeName(context: Context) = context.startActivity(ChangeNameJokeActivity.callingIntent(context))
    //private fun showNEList(context: Context) = context.startActivity(NEListActivity.callingIntent(context))
}


