package com.holdetc.yhu.on.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.holdetc.yhu.on.R;

/**
 * Created by yangchengwei on 15/10/28.
 */
public class CameraHistroyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_camera_histroy, container, false);
        return v;
    }
}
