package com.poplar.isun.ilovefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    //Step #1 Declare a Variable
    CheckBox breakfast, lunch, soups, desserts, salads;
    Button Ok;
    Switch diet;

    String temp = "";

    Boolean flag_diet;


    TextView Questionnair;
    static final  String Extra_food = "food";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step #2 FindViewByID
        diet = (Switch) findViewById(R.id.sw_diet);
        diet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(isChecked){
                  Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                  flag_diet = true;
              }
              else {
                  Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
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
        Ok = (Button) findViewById(R.id.btn_OK);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,temp,Toast.LENGTH_LONG).show();
            }
        });
        Questionnair = (TextView) findViewById(R.id.tv_questioner);
        Questionnair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,QuestionnairActivity.class);
                intent.putExtra(Extra_food,temp);
                startActivity(intent);
                finish();
            }
        });

    }
    //Step #3 Handle Checkbox events using onCheckedChanged() method.
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            temp = temp +buttonView.getText()+",";
        }
        else {
            temp = temp.replace(buttonView.getText()," ");
        }


    }



}
