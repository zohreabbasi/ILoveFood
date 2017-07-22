package com.poplar.isun.ilovefood;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MultiPane_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_pane);

       int screen = getResources().getConfiguration().orientation;

        if(screen == Configuration.ORIENTATION_PORTRAIT){
            View v = findViewById(R.id.side_fragment);
            if(v.getVisibility()==View.VISIBLE){
                v.setVisibility(View.GONE);
            }
        }



    }
}
