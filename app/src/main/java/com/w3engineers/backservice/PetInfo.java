package com.w3engineers.backservice;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * ============================================================================
 * Copyright (C) 2019 CloudLoopR - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * ============================================================================
 **/
public class PetInfo implements Parcelable {

    private String code, type;
    private int quantity, price;

    public PetInfo() {

    }

    protected PetInfo(Parcel in) {
        code = in.readString();
        type = in.readString();
        quantity = in.readInt();
        price = in.readInt();
    }

    public static final Creator<PetInfo> CREATOR = new Creator<PetInfo>() {
        @Override
        public PetInfo createFromParcel(Parcel in) {
            return new PetInfo(in);
        }

        @Override
        public PetInfo[] newArray(int size) {
            return new PetInfo[size];
        }
    };

    public String getCode() {
        return code;
    }

    public PetInfo setCode(String code) {
        this.code = code;
        return this;
    }

    public String getType() {
        return type;
    }

    public PetInfo setType(String type) {
        this.type = type;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public PetInfo setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public PetInfo setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(type);
        dest.writeInt(quantity);
        dest.writeInt(price);
    }
}
