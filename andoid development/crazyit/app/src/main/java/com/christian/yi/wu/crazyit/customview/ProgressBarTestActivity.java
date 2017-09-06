package com.christian.yi.wu.crazyit.customview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.christian.yi.wu.crazyit.R;

/**
 * Created by Administrator on 2017/9/4.
 */

public class ProgressBarTestActivity extends AppCompatActivity{

    private static final int MSG_REPORT_IN_PROGRESS = 1;

    private int[] data = new int[100];
    int hasData = 0;
    int status = 0;

    ProgressBar bar;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_REPORT_IN_PROGRESS) {
                bar.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_test);
        bar = (ProgressBar)findViewById(R.id.progressbar);

        new Thread() {
            @Override
            public void run() {

                if (status < 100) {
                    status = doWork();
                    handler.sendEmptyMessage(MSG_REPORT_IN_PROGRESS);
                }
            }
        }.start();
    }

    private int doWork() {
        data[hasData++] = (int)(Math.random() * 100);
        try{
            Thread.sleep(100);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
