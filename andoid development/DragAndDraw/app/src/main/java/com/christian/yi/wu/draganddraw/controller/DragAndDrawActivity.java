package com.christian.yi.wu.draganddraw.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.christian.yi.wu.draganddraw.R;

import java.util.zip.Inflater;

public class DragAndDrawActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return DragAndDrawFragment.newInstance(this);
    }
}
