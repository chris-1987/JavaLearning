package com.christian.yi.wu.geoquiz;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";
    private static final String KEY_ANSWERED_NUMBER = "answered_number";
    private static final String KEY_SCORE = "score";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_IS_CHEATER = "is_cheater";
    private static final String KEY_CHEAT_NUM = "cheat_num";
    private static final int REQUEST_CODE_CHEAT = 0;
    private static final int CHEAT_MAX_NUM =3;

//    private static final String KEY_QUESTIONS = "questions";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;
    private TextView mCheatNumTextView;

    private Question[] mQuestionBank = {
            new Question(R.string.question_austrialia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    private boolean[] mQuestionAnswer;
    private int mCurrentIndex;
    private int mAnsweredNumber;
    private double mScore;
    private boolean[] mIsCheater;
    private int mCheatNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
            mAnsweredNumber = savedInstanceState.getInt(KEY_ANSWERED_NUMBER);
            mScore = savedInstanceState.getDouble(KEY_SCORE);
            mQuestionAnswer = savedInstanceState.getBooleanArray(KEY_ANSWER);
            mIsCheater = savedInstanceState.getBooleanArray(KEY_IS_CHEATER);
            mCheatNum = savedInstanceState.getInt(KEY_CHEAT_NUM);
        } else {
            mCurrentIndex = 0;
            mAnsweredNumber = 0;
            mScore = 0;
            mQuestionAnswer = new boolean[mQuestionBank.length];
            for (boolean answer : mQuestionAnswer) {
                answer = false;
            }
            mIsCheater = new boolean[mQuestionBank.length];
            for (boolean isCheater : mIsCheater) {
                isCheater = false;
            }
            mCheatNum = 0;
        }

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuestionAnswer[mCurrentIndex] = true;
                mAnsweredNumber++;
                setAnswerButtonsEnabled(!mQuestionAnswer[mCurrentIndex]);
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuestionAnswer[mCurrentIndex] = true;
                mAnsweredNumber++;
                setAnswerButtonsEnabled(!mQuestionAnswer[mCurrentIndex]);
                checkAnswer(false);
            }
        });

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(false);
            }
        });
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CheatActivity.newIntent(MainActivity.this, mQuestionBank[mCurrentIndex].isTrueAnswer());
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(false);
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(true);
            }
        });

        mCheatNumTextView = (TextView)findViewById(R.id.cheat_num_text_view);
        mCheatNumTextView.setText("cheatnum remaining:" + Integer.toString(CHEAT_MAX_NUM - mCheatNum));
        setAnswerButtonsEnabled(!mQuestionAnswer[mCurrentIndex]);
        setCheatButtonEnabled();
    }


    private void updateQuestion(boolean isPrev) {
        mCurrentIndex = (mQuestionBank.length + mCurrentIndex + (isPrev ? -1 : +1)) % mQuestionBank.length;
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId());
        setAnswerButtonsEnabled(!mQuestionAnswer[mCurrentIndex]);
        showTotalScore();
    }

    /**
     * check user answer immedately when the specified button is clicked
     *
     * @param userAnswer
     */
    private void checkAnswer(boolean userAnswer) {

        int messageResId = 0;

        if (mIsCheater[mCurrentIndex]) {
         messageResId = R.string.judgement_toast;
        }
        else {
            if (userAnswer == mQuestionBank[mCurrentIndex].isTrueAnswer()) {
                mScore++;
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }

        Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void setAnswerButtonsEnabled(boolean isEnabled) {
        mTrueButton.setEnabled(isEnabled);
        mFalseButton.setEnabled(isEnabled);
    }

    private void setCheatButtonEnabled() {

        if (mCheatNum == CHEAT_MAX_NUM) {
            mCheatButton.setEnabled(false);
        }
        else {
            mCheatButton.setEnabled(true);
        }
    }

    private void showTotalScore() {

        Toast.makeText(this, "" + mAnsweredNumber, Toast.LENGTH_SHORT).show();
        if (mAnsweredNumber == mQuestionBank.length) {
            Toast.makeText(this, Double.toString(mScore / mAnsweredNumber), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(KEY_INDEX, mCurrentIndex);
        outState.putInt(KEY_ANSWERED_NUMBER, mAnsweredNumber);
        outState.putDouble(KEY_SCORE, mScore);
        outState.putBooleanArray(KEY_ANSWER, mQuestionAnswer);
        outState.putInt(KEY_CHEAT_NUM,mCheatNum);
//        outState.putSerializable(KEY_QUESTIONS, mQuestionBank);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            } else {
                mIsCheater[mCurrentIndex]= CheatActivity.wasAnswerShown(data);
                mCheatNum++;
                setCheatButtonEnabled();
                updateCheatNumTextView();
            }
        }
    }

    private void updateCheatNumTextView() {
        mCheatNumTextView.setText("cheatnum remaining:" + Integer.toString(CHEAT_MAX_NUM - mCheatNum));
    }
}
