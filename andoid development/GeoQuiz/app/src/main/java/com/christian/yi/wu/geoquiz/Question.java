package com.christian.yi.wu.geoquiz;

import java.io.Serializable;

/**
 * @author wu.yi.chrisitan
 * Question Model
 */

public class Question{

    private int mTextResId;
    private boolean mTrueAnswer;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mTrueAnswer = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isTrueAnswer() {
        return mTrueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        mTrueAnswer = trueAnswer;
    }
}
