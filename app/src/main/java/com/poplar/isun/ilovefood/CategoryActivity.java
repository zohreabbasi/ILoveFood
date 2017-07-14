package com.poplar.isun.ilovefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {

    GridView Category_grid;

    private Integer[] image_item = {
            R.drawable.baked_denver_omlete,
            R.drawable.big_steak_omelette,
            R.drawable.delish_omelet,
            R.drawable.delish_philly_cheesesteak_omelette,
            R.drawable.easy_mexican_omelet,
            R.drawable.greek_quinoa_dinner_omelets_with_feta_and_tzatziki,
            R.drawable.loaded_greek_asparagus_omelets,
            R.drawable.mushroomomelet,
            R.drawable.spinach_and_bacon_omelette,
            R.drawable.sweet_potato_black_bean_egg_white_omelet};

    private String[] text_item = {
            "Baked Denver Omelet",
            "Big Steak Omelet",
            "Delish Omelet",
            "Delish Philly cheese steak Omelet",
            "Mexican Egg White Omelet",
            "Greek Quinoa Dinner Omelets with Feta and Tzatziki",
            "Loaded greek asparagus Omelets",
            "Spinach and bacon Omelet",
            "Mushroom and Goat Cheese Omelet",
            "Sweet Potato Black Bean Egg White Omelet"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getSimpleName(),"onCreate");

        setContentView(R.layout.activity_category);

        Category_grid = (GridView) findViewById(R.id.grid);
        //Category_grid.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, text_item));

        GridAdapter adapter = new GridAdapter(CategoryActivity.this,image_item,text_item);

        Category_grid.setAdapter(adapter);

        Category_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CategoryActivity.this,text_item[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onResume() {
        Log.d(getClass().getSimpleName(),"onResume");

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(getClass().getSimpleName(),"onPause");

        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.d(getClass().getSimpleName(),"onStart");

        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(getClass().getSimpleName(),"onStop");

        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(getClass().getSimpleName(),"onRestart");

        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(getClass().getSimpleName(),"onDestroy");

        super.onDestroy();
    }


}
