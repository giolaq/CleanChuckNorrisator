package com.laquysoft.cleanchucknorrisator.navigation

import android.content.Context
import com.laquysoft.cleanchucknorrisator.features.changename.ChangedNameActivity

import com.laquysoft.cleanchucknorrisator.features.chooser.ChooserActivity
import com.laquysoft.cleanchucknorrisator.features.neverendingjokes.NeverEndingActivity

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator
@Inject constructor() {


    fun showChooser(context: Context) = context.startActivity(ChooserActivity.callingIntent(context))
    fun showChangeName(context: Context) = context.startActivity(ChangedNameActivity.callingIntent(context))
    fun showNEList(context: Context) = context.startActivity(NeverEndingActivity.callingIntent(context))
}


