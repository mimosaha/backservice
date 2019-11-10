package com.w3engineers.backservice;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.w3engineers.backservice.databinding.ActivityMainBinding;
import com.w3engineers.ext.strom.application.ui.base.BaseActivity;
import com.w3engineers.serviceprovider.MyService;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;
    private MainAdapter mainAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void startUI() {
        activityMainBinding = (ActivityMainBinding) getViewDataBinding();
        mainViewModel = getViewModel();

        initUI();
        loadData();
    }

    private void initUI() {
        activityMainBinding.recyclerView.setItemAnimator(null);
        activityMainBinding.recyclerView.setHasFixedSize(true);
        activityMainBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mainAdapter = new MainAdapter(mainViewModel);
        activityMainBinding.recyclerView.setAdapter(mainAdapter);
    }

    private void loadData() {

        mainViewModel.mutableLiveData.observe(this, petInfos -> {
            if (petInfos != null) {
                mainAdapter.addItem(petInfos);
            }
        });

        mainViewModel.petInfoLiveData.observe(this, petInfo -> {
            if (petInfo != null) {
                Intent intent = new Intent(this, BuyActivity.class);
                intent.putExtra(BuyActivity.class.getSimpleName(), petInfo);
                startActivity(intent);
            }
        });

        mainViewModel.startObserver();
    }

    private MainViewModel getViewModel() {
        return ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel();
            }
        }).get(MainViewModel.class);
    }
}
