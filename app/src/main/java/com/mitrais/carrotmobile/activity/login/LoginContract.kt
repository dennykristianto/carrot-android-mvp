package com.mitrais.carrotmobile.activity.login

import com.mitrais.carrotmobile.base.Presenter
import com.mitrais.carrotmobile.base.View
import com.mitrais.carrotmobile.model.Login

interface ILoginView : View {
    fun successfulLogin(loginResponseModel: Login)
    fun showError(call: String, statusMessage: String)
}

interface ILoginPresenter<V : ILoginView> : Presenter<V> {
    fun performLogin(email: String, password: String)
}
