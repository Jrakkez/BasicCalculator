package com.example.sam.basiccalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.RadioGroup;
import android.widget.*;

import static java.lang.Float.parseFloat;

/**
 * Created by Samantha Martinez around 2/26/27
 */

public class MainActivity extends AppCompatActivity {

    private EditText firstVal, secondVal;
    private RadioGroup operationSelection;
    private Button calculateButton;
    private float result;

    private final String IS_ANSWER = " is your answer.";
    private final String PLEASE_SELECT_OPERATION = "Please select an operation";
    private final String ENTER_TWO_VALUES = "Please enter 2 values.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationSelection = (RadioGroup) findViewById(R.id.operationSelection);
        firstVal = (EditText) findViewById(R.id.firstVal);
        secondVal = (EditText) findViewById(R.id.secondVal);
        calculateButton = (Button) findViewById(R.id.calculate);

        //Make the ime done option call the calculateButton
        secondVal.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                  calculateButton.callOnClick();
                    handled = true;
                }
                return handled;
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                String firstNum = firstVal.getText().toString();
                String secondNum = secondVal.getText().toString();

                //ensure numbers entered into EditText view
                if (firstNum.trim().isEmpty() || secondNum.trim().isEmpty()) {
                    Toast.makeText(context, ENTER_TWO_VALUES, Toast.LENGTH_SHORT).show();
                }
                else {
                    float first = parseFloat(firstNum);
                    float second = parseFloat(secondNum);

                    //ensure radio button is checked
                    int selectedId = operationSelection.getCheckedRadioButtonId();

                    //calls unnecessary methods for funzies; I am aware we could just perform operations here
                    switch (selectedId) {
                        case R.id.add:
                            addPressed(first, second);
                            break;
                        case R.id.subtract:
                            subtractPressed(first, second);
                            break;
                        case R.id.multiply:
                            multiplyPressed(first, second);
                            break;
                        case R.id.divide:
                            dividePressed(first, second);
                            break;
                        default:
                            Toast.makeText(context, PLEASE_SELECT_OPERATION, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }


    private void addPressed(float firstVal, float secondVal) {

        result = firstVal + secondVal;

        makeToast(result);
    }

    private void subtractPressed(float firstVal, float secondVal) {

        result = firstVal - secondVal;

        makeToast(result);
    }

    private void multiplyPressed(float firstVal, float secondVal) {

        result = firstVal * secondVal;

        makeToast(result);
    }

    private void dividePressed(float firstVal, float secondVal) {
        if(secondVal == 0.0) {
            makeToast("Cannot divide by 0");
        }
        else {
            result = firstVal / secondVal;
            makeToast(result);
        }
    }

    private <T> void makeToast(T result) {

        Context context = getApplicationContext();
        String answer = result + IS_ANSWER;

        Toast.makeText(context, answer, Toast.LENGTH_LONG).show();
    }
}


