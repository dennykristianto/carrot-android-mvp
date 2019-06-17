package com.mitrais.carrotmobile.activity.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mitrais.carrotmobile.R;
import com.mitrais.carrotmobile.adapter.BazaarAdapter;
import com.mitrais.carrotmobile.base.BaseActivity;
import com.mitrais.carrotmobile.model.Bazaar;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeView extends BaseActivity implements IHomeView {
    @Inject
    IHomePresenter<IHomeView> homePresenter;
    @BindView(R.id.bazaar_list)
    RecyclerView bazaarList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        /*Attaching this view into presenter*/
        homePresenter.onAttach(this);
        homePresenter.getBazaar();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setBazaar(@NotNull List<Bazaar> bazaar) {
        bazaarList.setAdapter(new BazaarAdapter(bazaar,this));
        bazaarList.setLayoutManager(new LinearLayoutManager(this));
    }
}
