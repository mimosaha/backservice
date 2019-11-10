package com.w3engineers.backservice;


import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.w3engineers.backservice.databinding.PetItemBinding;
import com.w3engineers.ext.strom.application.ui.base.BaseAdapter;
import com.w3engineers.ext.strom.application.ui.base.BaseViewHolder;

/**
 * ============================================================================
 * Copyright (C) 2019 CloudLoopR - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * ============================================================================
 **/
public class MainAdapter extends BaseAdapter<PetInfo> {

    private MainViewModel mainViewModel;

    public MainAdapter(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    @Override
    public boolean isEqual(PetInfo left, PetInfo right) {
        return left.getCode().equals(right.getCode());
    }

    @Override
    public BaseAdapterViewHolder<PetInfo> newViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PetInfoViewHolder(inflate(parent, R.layout.pet_item));
    }

    private class PetInfoViewHolder extends BaseAdapterViewHolder<PetInfo> {

        private PetItemBinding petItemBinding;

        public PetInfoViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            petItemBinding = (PetItemBinding) viewDataBinding;
        }

        @Override
        public void bind(PetInfo item) {
            petItemBinding.setPetInfo(item);
            petItemBinding.setMainViewModel(mainViewModel);
        }
    }
}