package com.poplar.isun.ilovefood;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionnairActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    String food;

    RadioGroup question1, question2;
    int Score1, Score2, Score;

    Button done;

    static  final String Extra_Score = "Score";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnair);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            food = (String) bundle.get(MainActivity.Extra_food);
            Toast.makeText(QuestionnairActivity.this, food, Toast.LENGTH_SHORT).show();
        }

        Score1 = 0;
        Score2 = 0;

        question1 = (RadioGroup) findViewById(R.id.rg_Question_1);
        question1.setOnCheckedChangeListener(this);
        question2 = (RadioGroup) findViewById(R.id.rg_Question_2);
        question2.setOnCheckedChangeListener(this);

        done = (Button) findViewById(R.id.btn_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuestionnairActivity.this,"Thanks",Toast.LENGTH_SHORT).show();
                Score = Score1+Score2;
                Intent back = new Intent(QuestionnairActivity.this,MainActivity.class);
                back.putExtra(Extra_Score,Score);
                startActivity(back);
                finish();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb1_answer1:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer1_Question_1, Toast.LENGTH_SHORT).show();
                Score1 = 4;

                break;
            case R.id.rb1_answer2:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer2_Question_1, Toast.LENGTH_SHORT).show();
                Score1 = 3;
                break;
            case R.id.rb1_answer3:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer3_Question_1, Toast.LENGTH_SHORT).show();
                Score1 = 2;

                break;
            case R.id.rb1_answer4:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer4_Question_1, Toast.LENGTH_SHORT).show();
                Score1 = 1;

                break;
            case R.id.rb1_answer5:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer5_Question_1, Toast.LENGTH_SHORT).show();
                Score1 = 0;

                break;
            case R.id.rb2_answer1:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer1_Question_2, Toast.LENGTH_SHORT).show();
                Score2 = 2;

                break;
            case R.id.rb2_answer2:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer2_Question_2, Toast.LENGTH_SHORT).show();
                Score2 = 1;

                break;
            case R.id.rb2_answer3:
                Toast.makeText(QuestionnairActivity.this, R.string.Answer3_Question_2, Toast.LENGTH_SHORT).show();
                Score2 = 0;
                break;
            default:
                break;
        }
    }
}

