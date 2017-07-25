package com.poplar.isun.ilovefood;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.poplar.isun.Fragment.HelpFragment;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ViewPager pager = (ViewPager) findViewById(R.id.pager_help);
        pager.setAdapter(new HelpAdapter(getFragmentManager()));


    }


    class HelpAdapter extends FragmentPagerAdapter{
        String[] titles ;
        String[] Contents;
        HelpAdapter(FragmentManager frg){
            super(frg);
            titles = getResources().getStringArray(R.array.titles_help_array);
        }
        @Override
        public Fragment getItem(int position) {
            return HelpFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
