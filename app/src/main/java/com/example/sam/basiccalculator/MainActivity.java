package com.example.sam.basiccalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.*;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {


    private EditText firstVal, secondVal;
    private RadioGroup operationSelection;
    private Button calculateButton;
    private final String selectButton = "Please select an operation";
    private final String enterValue = "Please enter 2 values.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstVal = (EditText) findViewById(R.id.firstVal);
        secondVal = (EditText) findViewById(R.id.secondVal);
        operationSelection = (RadioGroup) findViewById(R.id.operationSelection);
        calculateButton = (Button) findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                String firstNum = firstVal.getText().toString();
                String secondNum = secondVal.getText().toString();

                //ensure numbers entered into EditText view
                if (firstNum.trim().isEmpty() || secondNum.trim().isEmpty()) {
                    Toast.makeText(context, enterValue, Toast.LENGTH_SHORT).show();
                }
                else {
                    //TODO make this block easier to read
                    float first = parseFloat(firstNum);
                    float second = parseFloat(secondNum);

                    //ensure radio button is checked
                    int selectedId = operationSelection.getCheckedRadioButtonId();
                    switch (selectedId) {
                        //calls unnecessary methods for funzies; I am aware we could just perform operate here
                        case 0:
                            addPressed(first, second);
                            break;
                        case 1:
                            subtractPressed(first, second);
                            break;
                        case 2:
                            multiplyPressed(first, second);
                            break;
                        case 3:
                            dividePressed(first, second);
                            break;
                        default:
                            Toast.makeText(context, selectButton, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }


    public float addPressed(float firstVal, float secondVal) {

        float result;

        result = firstVal + secondVal;

        return result;
    }

    public float subtractPressed(float firstVal, float secondVal) {

        float result;

        result = firstVal - secondVal;

        return result;
    }

    public float multiplyPressed(float firstVal, float secondVal) {

        float result;

        result = firstVal * secondVal;

        return result;
    }

    public float dividePressed(float firstVal, float secondVal) {

        float result;

        result = firstVal/secondVal;

        return result;
    }
}


