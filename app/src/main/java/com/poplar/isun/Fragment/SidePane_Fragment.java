package com.poplar.isun.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poplar.isun.ilovefood.R;

/**
 * Created by isun on 7/22/2017.
 */

public class SidePane_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmetn_side_panel,container,false);
        return view;
    }
}
