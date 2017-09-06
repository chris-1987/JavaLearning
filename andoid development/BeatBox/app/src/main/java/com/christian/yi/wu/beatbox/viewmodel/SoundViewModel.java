package com.christian.yi.wu.beatbox.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.christian.yi.wu.beatbox.model.BeatBox;
import com.christian.yi.wu.beatbox.model.Sound;

/**
 * Created by Administrator on 2017/9/5.
 */

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

}
