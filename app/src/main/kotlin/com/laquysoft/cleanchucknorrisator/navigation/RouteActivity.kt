package com.laquysoft.cleanchucknorrisator.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.laquysoft.cleanchucknorrisator.AndroidApplication
import com.laquysoft.cleanchucknorrisator.di.ApplicationComponent
import javax.inject.Inject

class RouteActivity : AppCompatActivity() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    @Inject internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        navigator.showChooser(this)
    }
}
