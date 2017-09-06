package com.christian.yi.wu.crazyit.customview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.christian.yi.wu.crazyit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */

public class CalPrimeActivity extends Activity {
    static final String UPPER_NUM = "upper";
    static final int MSG_SEND_UPPER_NUM = 1;

    EditText etNum;
    CalThread calThread;

    class CalThread extends Thread {

        public Handler mHandler;

        @Override
        public void run() {
            Looper.prepare(); // Looper serves for the handler created below

            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == MSG_SEND_UPPER_NUM) {
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<>();
                        outer:
                        for (int i = 2; i <= upper; ++i) {
                            for (int j = 2; j <= Math.sqrt(i); ++j) {
                                if (i != 2 && i % j == 0)
                                    continue outer;
                            }
                            nums.add(i);
                        }
                        Toast.makeText(CalPrimeActivity.this, nums.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            };
            Looper.loop(); // continually retrieves newly arrival in the message queue
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_prime);
        etNum = (EditText)findViewById(R.id.etNum);
        calThread = new CalThread();
        calThread.start();
    }

    public void cal(View source) {
        Message msg = new Message();
        msg.what = MSG_SEND_UPPER_NUM;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
        msg.setData(bundle);
        calThread.mHandler.sendMessage(msg);
    }
}
