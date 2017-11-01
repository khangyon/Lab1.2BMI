package com.example.taruc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Ui to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewBMI);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
    }

    public void calculateBMI(View view){

        double weight, height, bmi;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        //imageViewResult.setImageResource(R.drawable.normal);

        bmi = weight/((height/100)*(height/100));

        if (bmi<=18.5) {
            imageViewResult.setImageResource(R.drawable.under);
            textViewResult.setText("Your BMI is " + Double.toString(bmi)+ ". It is Under Weight.");
        }
        else if (bmi >= 21) {
            imageViewResult.setImageResource(R.drawable.over);
            textViewResult.setText("Your BMI is " + Double.toString(bmi)+ ". It is Over Weight.");
        }
            else {
            imageViewResult.setImageResource(R.drawable.normal);
            textViewResult.setText("Your BMI is " + Double.toString(bmi) + ". It is Normal.");
        }
    }
    public void reset(View view){
        editTextHeight.setText("");
        editTextWeight.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
        textViewResult.setText("BMI");
    }
}
