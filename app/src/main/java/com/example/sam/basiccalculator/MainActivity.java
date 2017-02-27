package com.example.sam.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.*;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {


    private EditText firstVal, secondVal;
    private RadioGroup operationSelection;
    private Button calculateButton;

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

                //get proper values from textFields and radioGroup
                float first = parseFloat(firstVal.getText().toString());
                float second = parseFloat(secondVal.getText().toString());

                //ensure radio button is checked
                boolean checked = ((RadioButton) view).isChecked();
                //if this here doesnt work as I suspect it wont, try declaring selectedID before the if and checking it
                if (checked) {
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
                    }
                }
                //else {
                //    Toast.makeText("Please select an operation");
                //}
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


