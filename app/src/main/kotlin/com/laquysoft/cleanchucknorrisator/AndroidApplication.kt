package com.laquysoft.cleanchucknorrisator

import android.app.Application
import com.laquysoft.cleanchucknorrisator.di.ApplicationComponent
import com.laquysoft.cleanchucknorrisator.di.ApplicationModule
import com.laquysoft.cleanchucknorrisator.di.DaggerApplicationComponent
import com.squareup.leakcanary.LeakCanary

val prefs: Prefs by lazy {
    AndroidApplication.prefs!!
}
class AndroidApplication : Application() {
    companion object {
        var prefs: Prefs? = null
    }
    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
        this.injectMembers()
        this.initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) LeakCanary.install(this)
    }
}
