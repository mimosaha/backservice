package com.w3engineers.backservice;


import android.content.Intent;
import android.util.Log;

import com.w3engineers.backservice.databinding.ActivityBuyBinding;
import com.w3engineers.ext.strom.application.ui.base.BaseActivity;

/**
 * ============================================================================
 * Copyright (C) 2019 CloudLoopR - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * ============================================================================
 **/
public class BuyActivity extends BaseActivity {

    private ActivityBuyBinding activityBuyBinding;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy;
    }

    @Override
    protected void startUI() {

        activityBuyBinding = (ActivityBuyBinding) getViewDataBinding();

        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }

        PetInfo petInfo = intent.getParcelableExtra(BuyActivity.class.getSimpleName());
        Log.v("MIMO_SAHA:", "Type: " + petInfo.getType());
    }
}
