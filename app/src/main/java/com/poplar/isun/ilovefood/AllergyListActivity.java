package com.poplar.isun.ilovefood;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllergyListActivity extends ListActivity implements AdapterView.OnItemSelectedListener {

    String[] Allergy_item = {"Corn Allergy", "Egg Allergy", "Fish Allergy", "Meat Allergy", "Milk Allergy", "Peanut Allergy", "Shellfish Allergy", "Tree Nut Allergy", "Wheat Allergy", "FPIES Allergy"};


    Button done;
    TextView text;

    ArrayAdapter<String> adapter;

    Spinner FemaleORMale,Age;
    String[] FemaleOrMale_item = {"Female","Male"};
    ArrayAdapter<String> FemaleOrMale_adapter;
    ArrayAdapter<CharSequence> Age_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_list);
        done = (Button) findViewById(R.id.btn_SaveAllergy);
        text = (TextView) findViewById(R.id.tv_Allergy);
        //getListView().setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, Allergy_item);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AllergyListActivity.this, adapter.getItem(position), Toast.LENGTH_LONG).show();
            }
        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AllergyListActivity.this, adapter.getItem(position) + " "+ position, Toast.LENGTH_LONG).show();

                return false;
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checked = getListView().getCheckedItemPositions();
                ArrayList<String> result = new ArrayList<String>();
                for(int i =0 ;i<checked.size();i++){
                    int p = checked.keyAt(i);
                    if(checked.valueAt(i)){
                        result.add(adapter.getItem(p));
                    }
                }

                text.setText(result.toString());
            }
        });

        FemaleORMale = (Spinner) findViewById(R.id.MaleOrFemale_spinner);
        Age = (Spinner) findViewById(R.id.age_spinner);

        FemaleOrMale_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,FemaleOrMale_item);
        FemaleOrMale_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FemaleORMale.setAdapter(FemaleOrMale_adapter);

        FemaleORMale.setOnItemSelectedListener(this);

        Age_adapter =ArrayAdapter.createFromResource(this,R.array.age_array,android.R.layout.simple_spinner_item);
        Age_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Age.setAdapter(Age_adapter);

        Age.setOnItemSelectedListener(this);





    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String temp = parent.getItemAtPosition(position).toString();

        Toast.makeText(AllergyListActivity.this,temp,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
