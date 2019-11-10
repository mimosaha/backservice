package com.w3engineers.backservice;


import android.arch.lifecycle.MutableLiveData;

import com.w3engineers.ext.strom.application.ui.base.BaseRxViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ============================================================================
 * Copyright (C) 2019 CloudLoopR - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * ============================================================================
 **/
public class MainViewModel extends BaseRxViewModel {

    public MutableLiveData<List<PetInfo>> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<PetInfo> petInfoLiveData = new MutableLiveData<>();

    public MainViewModel() {

    }

    public void startObserver() {

        Random random = new Random();

        String[] type = {"Cat", "Dog", "Duck", "Hen", "Mice", "Parrot", "Rabbit"};
        String[] code = {"0x01", "0x02", "0x03", "0x04", "0x05", "0x06", "0x07"};

        List<PetInfo> petInfos = new ArrayList<>();

        for (int i = 0; i < type.length; i++) {
            PetInfo petInfo = new PetInfo()
                    .setType(type[i])
                    .setCode(code[i])
                    .setPrice(random.nextInt(10))
                    .setQuantity(random.nextInt(200));

            petInfos.add(petInfo);
        }

        mutableLiveData.postValue(petInfos);
    }

    public void buyPet(PetInfo petInfo) {
        petInfoLiveData.postValue(petInfo);
    }
}
