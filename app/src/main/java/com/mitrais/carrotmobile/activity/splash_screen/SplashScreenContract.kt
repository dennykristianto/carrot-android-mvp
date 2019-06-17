package com.mitrais.carrotmobile.activity.splash_screen

import com.mitrais.carrotmobile.base.Presenter
import com.mitrais.carrotmobile.base.View
import com.mitrais.carrotmobile.model.ActivityScope

interface ISplashView : View {
    fun showIndexPage()
    fun showLoginPage()
}

 interface ISplashPresenter<V : ISplashView> : Presenter<V> {
    fun checkUserLogin()
}
