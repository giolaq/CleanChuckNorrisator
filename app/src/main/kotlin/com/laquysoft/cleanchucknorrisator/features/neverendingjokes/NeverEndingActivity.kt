package com.laquysoft.cleanchucknorrisator.features.neverendingjokes

/**
 * Created by joaobiriba on 06/11/2017.
 */

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.laquysoft.cleanchucknorrisator.BaseActivity

class NeverEndingActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, NeverEndingActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableHomeUpButton()
    }
    override fun fragment() = NeverEndingFragment()
}