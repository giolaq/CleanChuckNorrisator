package com.laquysoft.cleanchucknorrisator.features.chooser

import android.content.Context
import android.content.Intent
import com.laquysoft.cleanchucknorrisator.BaseActivity

class ChooserActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, ChooserActivity::class.java)
    }

    override fun fragment() = ChooserFragment()
}