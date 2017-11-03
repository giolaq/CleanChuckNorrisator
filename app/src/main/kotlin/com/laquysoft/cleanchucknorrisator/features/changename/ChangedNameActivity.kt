package com.laquysoft.cleanchucknorrisator.features.changename

import android.content.Context
import android.content.Intent
import com.laquysoft.cleanchucknorrisator.BaseActivity
import com.laquysoft.cleanchucknorrisator.features.chooser.ChooserFragment

class ChangedNameActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, ChangedNameActivity::class.java)
    }

    override fun fragment() = ChangedNameFragment()
}