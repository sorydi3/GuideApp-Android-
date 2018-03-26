package com.example.android.guideapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sam on 29/06/2017.
 */

public class Info implements Parcelable {
    private String mName;
    private String mDirection;
    private int mImage;
    private String mNumber;
    private String details;

    public Info(String name, String direction, int image, String detail, String number) {
        this.mName = name;
        this.mDirection = direction;
        this.mImage = image;
        this.details = detail;
        this.mNumber = number;
    }

    public Info(Parcel input) {
        mName = input.readString();
        mDirection = input.readString();
        mImage = input.readInt();
        details = input.readString();
        mNumber = input.readString();
    }

    public String getmName() {
        return mName;
    }

    public String getDetails() {
        return details;
    }

    public String getmDirection() {
        return mDirection;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmNumber() {
        return mNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDirection);
        dest.writeInt(mImage);
        dest.writeString(details);
        dest.writeString(mNumber);
    }

    public static final Parcelable.Creator<Info> CREATOR
            = new Parcelable.Creator<Info>() {
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        public Info[] newArray(int size) {
            return new Info[size];
        }
    };
}
