package com.poplar.isun.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poplar.isun.ilovefood.R;

/**
 * Created by isun on 7/25/2017.
 */

public class HelpFragment extends Fragment {
    private static final String KEY_POSITION ="POSITION";
    String[] Contents ;

    public static HelpFragment newInstance(int position){
        HelpFragment frg = new HelpFragment();
        Bundle b = new Bundle();
        b.putInt(KEY_POSITION,position);

        frg.setArguments(b);
        return  frg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_help,container,false);
        TextView text = (TextView) view.findViewById(R.id.txt_help);
        int position = getArguments().getInt(KEY_POSITION,-1);
        Contents = getResources().getStringArray(R.array.contents_help_array);

        text.setText(Contents[position]);
        return view;
    }
}
