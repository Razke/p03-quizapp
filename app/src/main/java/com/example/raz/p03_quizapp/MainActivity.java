package com.example.raz.p03_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * This app displays questions and gives back a result based on the answers.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox
            checkBoxOne,
            checkBoxTwo,
            checkBoxThree;

    private RadioButton
            radioButtonOne,
            radioButtonTwo,
            radioButtonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initiate views for the answer toasts.
        checkBoxOne = findViewById(R.id.check_box_answer_one);
        checkBoxOne.setOnClickListener(this);
        checkBoxTwo = findViewById(R.id.check_box_answer_two);
        checkBoxTwo.setOnClickListener(this);
        checkBoxThree = findViewById(R.id.check_box_answer_three);
        checkBoxThree.setOnClickListener(this);
        radioButtonOne = findViewById(R.id.radio_answer_one);
        radioButtonOne.setOnClickListener(this);
        radioButtonTwo = findViewById(R.id.radio_answer_two);
        radioButtonTwo.setOnClickListener(this);
        radioButtonThree = findViewById(R.id.radio_answer_three);
        radioButtonThree.setOnClickListener(this);
    }

    /**
     * This sets the click event on buttons and displays toast messages on the selected answers.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_box_answer_one:
                if (checkBoxOne.isChecked())
                    Toast.makeText(this,
                            R.string.toast_check_box_answer_one, Toast.LENGTH_SHORT).show();
                break;
            case R.id.check_box_answer_two:
                if (checkBoxTwo.isChecked())
                    Toast.makeText(this,
                            R.string.toast_check_box_answer_two, Toast.LENGTH_SHORT).show();
                break;
            case R.id.check_box_answer_three:
                if (checkBoxThree.isChecked())
                    Toast.makeText(this,
                            R.string.toast_check_box_answer_three, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_answer_one:
                if (radioButtonOne.isChecked())
                    Toast.makeText(this,
                            R.string.toast_radio_answer_one, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_answer_two:
                if (radioButtonTwo.isChecked())
                    Toast.makeText(this,
                            R.string.toast_radio_answer_two, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_answer_three:
                if (radioButtonThree.isChecked())
                    Toast.makeText(this,
                            R.string.toast_radio_answer_three, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * This method gets the rights answers and displays a toast with the results.
     */
    public void submitResult(View view) {
        CheckBox checkBoxAnswerOne = checkBoxOne;
        boolean checkBoxAnswerFirst = checkBoxAnswerOne.isChecked();

        CheckBox checkBoxAnswerTwo = checkBoxTwo;
        boolean checkBoxAnswerSecond = checkBoxAnswerTwo.isChecked();

        CheckBox checkBoxAnswerThree = checkBoxThree;
        boolean checkBoxAnswerThird = checkBoxAnswerThree.isChecked();

        RadioButton radioAnswerTwo = radioButtonTwo;
        boolean radioButtonAnswerSecond = radioAnswerTwo.isChecked();

        EditText editTextAnswerOne = findViewById(R.id.edit_text_answer_one);
        String editTextStringAnswerOne = String.valueOf(editTextAnswerOne.getText());
        boolean editTextAnswerFirst = false;
        if (editTextStringAnswerOne.equals(getString(R.string.edit_text_answer_one_correct))) {
            editTextAnswerFirst = true;
        }

        EditText editTextAnswerTwo = findViewById(R.id.edit_text_answer_two);
        String editTextStringAnswerTwo = String.valueOf(editTextAnswerTwo.getText());
        boolean editTextAnswerSecond = false;
        if (editTextStringAnswerTwo.equals(getString(R.string.edit_text_answer_two_correct))) {
            editTextAnswerSecond = true;
        }

        int result = calculateResult(
                checkBoxAnswerFirst,
                checkBoxAnswerSecond,
                checkBoxAnswerThird,
                radioButtonAnswerSecond,
                editTextAnswerFirst,
                editTextAnswerSecond);

        displayResult(result);
    }

    /**
     * This method checks the right answers and makes a score.
     *
     * @param checkBoxAnswerOne   is whether or not selected.
     * @param checkBoxAnswerTwo   is whether or not selected.
     * @param checkBoxAnswerThree is whether or not selected.
     * @param radioAnswerTwo      is whether or not selected.
     * @param editTextAnswerOne   is whether or not true.
     * @param editTextAnswerTwo   is whether or not true.
     * @return                    the total result of the quiz.
     */
    public int calculateResult(boolean checkBoxAnswerOne,
                               boolean checkBoxAnswerTwo,
                               boolean checkBoxAnswerThree,
                               boolean radioAnswerTwo,
                               boolean editTextAnswerOne,
                               boolean editTextAnswerTwo) {
        int result = 0;

        if (checkBoxAnswerOne && checkBoxAnswerTwo && !checkBoxAnswerThree) {
            result++;
        }
        if (radioAnswerTwo) {
            result++;
        }
        if (editTextAnswerOne) {
            result++;
        }
        if (editTextAnswerTwo) {
            result++;
        }

        return result;
    }

    /**
     * This method displays the total result in a toast message.
     *
     * @param result    is the total number of right answers.
     */
    public void displayResult(int result) {
        if (result == 0) {
            Toast.makeText(this, getString(R.string.toast_zero_points, result), Toast.LENGTH_LONG).show();
        } else if (result == 1) {
            Toast.makeText(this, getString(R.string.toast_one_point, result), Toast.LENGTH_LONG).show();
        } else if (result == 2) {
            Toast.makeText(this, getString(R.string.toast_two_points, result), Toast.LENGTH_LONG).show();
        } else if (result == 3) {
            Toast.makeText(this, getString(R.string.toast_three_points, result), Toast.LENGTH_LONG).show();
        } else if (result == 4) {
            Toast.makeText(this, getString(R.string.toast_four_points, result), Toast.LENGTH_LONG).show();
        }
    }
}
