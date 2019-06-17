package com.mitrais.carrotmobile.base

interface Presenter<V : View> {
    fun onAttach(mvpView: V)
    fun onDetach()
}

interface View {
    val isNetworkConnected: Boolean
    fun showLoading()
    fun hideLoading()
}
