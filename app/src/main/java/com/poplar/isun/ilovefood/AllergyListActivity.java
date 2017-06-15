package com.poplar.isun.ilovefood;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllergyListActivity extends ListActivity {

    String[] Allergy_item = {"Corn Allergy", "Egg Allergy", "Fish Allergy", "Meat Allergy", "Milk Allergy", "Peanut Allergy", "Shellfish Allergy", "Tree Nut Allergy", "Wheat Allergy", "FPIES Allergy"};

    Button done;
    TextView text;

    ArrayAdapter<String> adapter;

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


    }
}
