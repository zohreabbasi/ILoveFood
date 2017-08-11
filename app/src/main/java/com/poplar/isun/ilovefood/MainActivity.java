package com.poplar.isun.ilovefood;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    //Step #1 Declare a Variable
    CheckBox breakfast, lunch, soups, desserts, salads;
    Button Recipes,Allergy , Multi_Pane;
    Switch diet;

    String temp = "";

    Boolean flag_diet;
    TextView Questionnair;
    static final String Extra_food = "food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(getClass().getSimpleName(),"onCreate");

        //Step #2 FindViewByID
        diet = (Switch) findViewById(R.id.sw_diet);
        diet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    flag_diet = true;
                } else {
                    Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    flag_diet = false;

                }

            }
        });
        diet.setChecked(true);
        breakfast = (CheckBox) findViewById(R.id.cb_breakfast);
        breakfast.setOnCheckedChangeListener(this);
        lunch = (CheckBox) findViewById(R.id.cb_lunch);
        lunch.setOnCheckedChangeListener(this);
        soups = (CheckBox) findViewById(R.id.cb_soups);
        soups.setOnCheckedChangeListener(this);
        desserts = (CheckBox) findViewById(R.id.cb_desserts);
        desserts.setOnCheckedChangeListener(this);
        salads = (CheckBox) findViewById(R.id.cb_salads);
        salads.setOnCheckedChangeListener(this);
        Recipes = (Button) findViewById(R.id.btn_OK);

        Recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);


            }
        });
        Questionnair = (TextView) findViewById(R.id.tv_questioner);
        Questionnair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionnairActivity.class);
                intent.putExtra(Extra_food, temp);
                startActivity(intent);
                finish();
            }
        });
        Allergy = (Button) findViewById(R.id.btn_Allergy);
        Allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllergyListActivity.class);
                startActivity(intent);
            }
        });

       Multi_Pane =(Button)findViewById(R.id.btn_multi_pane);
        Multi_Pane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MultiPane_Activity.class);
                startActivity(intent);

            }
        });


    }

    //Step #3 Handle Checkbox events using onCheckedChanged() method.
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            temp = temp + buttonView.getText() + ",";
        } else {
            temp = temp.replace(buttonView.getText(), " ");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_menu:
                Toast.makeText(getApplicationContext(),"ABOUT",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help_menu:
               // Toast.makeText(getApplicationContext(),"HELP",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent);
                return true;
            case R.id.web_page_menu:
               /* Uri uri = Uri.parse("http://google.com");
                Intent web_page = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(web_page);
                */
                Intent web_page = new Intent(MainActivity.this,WebPageActivity.class);
                startActivity(web_page);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
