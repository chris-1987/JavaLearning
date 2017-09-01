package com.christian.yi.wu.criminalintent.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/31.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private boolean mRequirePolice;

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
        mRequirePolice = false;
    }

    public Crime() {
        this(UUID.randomUUID());
    }


    public Date getDate() {
        return mDate;
    }

    // no setter for mDate
    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId() {
        return mId;
    }

    // no getter for mId

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public boolean isRequirePolice() {
        return mRequirePolice;
    }

    public void setRequirePolice(boolean requirePolice) {
        mRequirePolice = requirePolice;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "mDate=" + mDate +
                ", mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mSolved=" + mSolved +
                ", mRequirePolice=" + mRequirePolice +
                '}';
    }
}
