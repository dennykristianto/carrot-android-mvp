package com.mitrais.carrotmobile.activity.home

import com.mitrais.carrotmobile.base.Presenter
import com.mitrais.carrotmobile.base.View
import com.mitrais.carrotmobile.model.Bazaar
import com.mitrais.carrotmobile.model.Login


interface IHomeView : View {
    fun setBazaar(bazaar:List<Bazaar>);
}

interface IHomePresenter<V : IHomeView> : Presenter<V> {
    fun getBazaar();
}
