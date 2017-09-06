package com.christian.yi.wu.crazyit.customview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.christian.yi.wu.crazyit.R;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends AppCompatActivity {

    private static final int MSG_CHANGE_COLOR = 1;

    private int currentColor = 0;

    final int[] colors = new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3
    };

    final int[] names = new int[]{
            R.id.textview1,
            R.id.textview2,
            R.id.textview3
    };

    TextView[] views = new TextView[names.length];

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == MSG_CHANGE_COLOR) {
                for (int i = 0; i < names.length; ++i) {
                    views[i].setBackgroundResource(colors[(i + currentColor)  % names.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        for (int i =0; i < names.length; ++i) {
            views[i] = (TextView)findViewById(names[i]);
        }

        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                handler.sendEmptyMessage(MSG_CHANGE_COLOR);
            }
        }, 0, 200);
    }


}
