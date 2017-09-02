package com.christian.yi.wu.criminalintent.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.christian.yi.wu.criminalintent.R;
import com.christian.yi.wu.criminalintent.utils.PictureUtils;

import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2017/9/2.
 */

public class ImageEnlargerFragment extends DialogFragment {

    private static final String ARG_IMAGE_FILE_PATH = "image_file_path";

    private ImageView mImageView;

    public static ImageEnlargerFragment newInstance(String imagePath,Context context) {
        Bundle args = new Bundle();

        args.putString(ARG_IMAGE_FILE_PATH, imagePath);

        ImageEnlargerFragment fragment = new ImageEnlargerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String imagePath = getArguments().getString(ARG_IMAGE_FILE_PATH);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image_enlarger, null);
        mImageView = (ImageView)view.findViewById(R.id.image_view_enlarger);
        Bitmap bitmap = PictureUtils.getScaledBitmap(imagePath, getActivity());
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog
                .Builder(getActivity())
                .setView(view)
                .setTitle(R.string.image_enlarger_title)
                .create();
    }
}
