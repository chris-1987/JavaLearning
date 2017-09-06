package com.christian.yi.wu.draganddraw.controller;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/9/6.
 */

public class Box implements Parcelable {

    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin) {
        mOrigin = origin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {

        mCurrent = current;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public static final Parcelable.Creator<Box> CREATOR = new Creator<Box>() {
        @Override
        public Box createFromParcel(Parcel parcel) {
            PointF origin = new PointF(parcel.readFloat(), parcel.readFloat());
            Box box = new Box(origin);
            PointF current = new PointF(parcel.readFloat(), parcel.readFloat());
            box.setCurrent(current);
            return box;
        }

        @Override
        public Box[] newArray(int size) {
            return new Box[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(mOrigin.x);
        parcel.writeFloat(mOrigin.y);
        parcel.writeFloat(mCurrent.x);
        parcel.writeFloat(mCurrent.y);
    }

    @Override
    public String toString() {
        return "Box{" +
                "mCurrent=" + mCurrent +
                ", mOrigin=" + mOrigin +
                '}';
    }
}
