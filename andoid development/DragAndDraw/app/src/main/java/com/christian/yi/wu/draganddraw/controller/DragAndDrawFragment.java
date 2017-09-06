package com.christian.yi.wu.draganddraw.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.christian.yi.wu.draganddraw.R;

/**
 * Created by Administrator on 2017/9/6.
 */

public class DragAndDrawFragment extends Fragment {

    public static DragAndDrawFragment newInstance(Context context) {
        return new DragAndDrawFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_and_draw, container, false);
        return view;
    }
}
