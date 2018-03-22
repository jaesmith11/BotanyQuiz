package com.example.android.botanyquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //initialize global variable to track user's score
    private int scoreTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Add one to scoreTotal if question 1 is correct
    public void answer1() {
        RadioButton rb1a = findViewById(R.id.answer_1a);
        if (rb1a.isChecked()) {
            scoreTotal++;
        }
    }

    //Add one to scoreTotal if question 2 is correct
    public void answer2() {
        CheckBox cb2a = findViewById(R.id.answer_2a);
        CheckBox cb2b = findViewById(R.id.answer_2b);
        CheckBox cb2c = findViewById(R.id.answer_2c);
        CheckBox cb2d = findViewById(R.id.answer_2d);
        CheckBox cb2e = findViewById(R.id.answer_2e);
        //cb2b, cb2c, cb2e are correct and should be checked; cb2a, cb2d are incorrect
        if (!cb2a.isChecked() && cb2b.isChecked() && cb2c.isChecked() && !cb2d.isChecked() && cb2e.isChecked()) {
            scoreTotal++;
        }
    }

    //Add one to scoreTotal if question 3 is correct
    public void answer3() {
        EditText et3 = findViewById(R.id.answer_3);
        if (et3.getText().toString().toLowerCase() == "sequoia sempervirons") {
            scoreTotal++;
        }
    }

    //Add one to scoreTotal if question 4 is correct
    public void answer4() {
        RadioButton rb4b = findViewById(R.id.answer_4b);
        if (rb4b.isChecked()) {
            scoreTotal++;
        }
    }

    //Add one to scoreTotal if question 5 is correct
    public void answer5() {
        CheckBox cb5a = findViewById(R.id.answer_5a);
        CheckBox cb5b = findViewById(R.id.answer_5b);
        CheckBox cb5c = findViewById(R.id.answer_5c);
        CheckBox cb5d = findViewById(R.id.answer_5d);
        //cb5a and cb5c are correct and should be checked; cb5b, cb5d are incorrect
        if (cb5a.isChecked() && !cb5b.isChecked() && cb5c.isChecked() && !cb5d.isChecked()) {
            scoreTotal++;
        }
    }

    //when submit button is pressed, call methods to score each answer
    public void submitQuiz(View view) {
        answer1();
        answer2();
        answer3();
        answer4();
        answer5();
        //call method to display score
        scoreMessage(scoreTotal);
        //reset score so user can try again
        scoreTotal = 0;
    }

    //display score via toast message
    private void scoreMessage(int scoreTotal) {
        Context context = getApplicationContext();
        CharSequence text = "Your score is " + scoreTotal + "/5!";
        int duration = Toast.LENGTH_SHORT;

        Toast.makeText(context, text, duration).show();
    }

}