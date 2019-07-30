package com.example.www.androideverest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView calc_tv;
    private double first_number = 0;
    private double second_number = 0;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_calculator);

        calc_tv = findViewById(R.id.calc_tv);
    }

    public void clear_line(View view) {
        calc_tv.setText("");
    }

    public void get_result(View view) {

        second_number = Double.valueOf(calc_tv.getText().toString());
        double result = 0;

        switch (operation) {
            case "":
                break;

            case "plus":
                result = first_number + second_number;
                break;

            case "minus":
                result = first_number - second_number;
                break;

            case "multiple":
                result = first_number * second_number;
                break;

            case "divide":
                result = first_number / second_number;
                break;

            case "mod":
                result = first_number % second_number;
                break;
        }

        calc_tv.setText(String.valueOf(result));

        first_number = 0;
        second_number = 0;
        operation = "";
    }

    public void do_math(View view) {
        String tag = view.getTag().toString();

        if (operation.equals("")) {
            first_number = Double.valueOf(calc_tv.getText().toString());
            calc_tv.setText("");

            operation = tag;
        }

//        switch (tag) {
//            case "plus":
//                break;
//
//            case "minus":
//                break;
//
//            case "multiple":
//                break;
//
//            case "divide":
//                break;
//        }
    }

    public void type_number(View view) {

        String tag = view.getTag().toString();
        String current_text = calc_tv.getText().toString();
        String new_text;

        switch (tag) {
            case ".":
                if (!current_text.contains(".")) {
                    if (current_text.equals("")) {
                        new_text = current_text + "0.";
                    } else {
                        new_text = current_text + ".";
                    }
                    calc_tv.setText(new_text);
                }
                break;

            case "0":
                if (!current_text.equals("")) {
                    new_text = current_text + "0";
                    calc_tv.setText(new_text);
                }
                break;

            case "1":
                new_text = current_text + "1";
                calc_tv.setText(new_text);
                break;

            case "2":
                new_text = current_text + "2";
                calc_tv.setText(new_text);
                break;

            case "3":
                new_text = current_text + "3";
                calc_tv.setText(new_text);
                break;

            case "4":
                new_text = current_text + "4";
                calc_tv.setText(new_text);
                break;

            case "5":
                new_text = current_text + "5";
                calc_tv.setText(new_text);
                break;

            case "6":
                new_text = current_text + "6";
                calc_tv.setText(new_text);
                break;

            case "7":
                new_text = current_text + "7";
                calc_tv.setText(new_text);
                break;

            case "8":
                new_text = current_text + "8";
                calc_tv.setText(new_text);
                break;

            case "9":
                new_text = current_text + "9";
                calc_tv.setText(new_text);
                break;

        }
    }
}
