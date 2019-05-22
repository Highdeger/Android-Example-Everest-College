package com.example.www.androideverest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void alert_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("This is a message")
                .setTitle("The Title")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "OK Pressed.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Cancel Pressed.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Nothing", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Nothing Pressed.", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void timepicker_dialog(View view) {

        TimePickerDialog dialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String temp_text = String.format(
                                Locale.getDefault(),
                                "%02d:%02d Selected",
                                hourOfDay,
                                minute
                        );
                        Toast.makeText(DialogActivity.this, temp_text, Toast.LENGTH_SHORT).show();
                    }
                },
                22,
                34,
                true
        );

        dialog.show();
    }

    public void datepicker_dialog(View view) {
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String temp_text = String.format(
                                Locale.getDefault(),
                                "%02d/%02d/%04d Selected",
                                dayOfMonth,
                                month,
                                year
                        );
                        Toast.makeText(DialogActivity.this, temp_text, Toast.LENGTH_SHORT).show();
                    }
                },
                2019,
                5,
                13
        );

        dialog.show();
    }

    public void list_select_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final String[] my_list = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        builder.setTitle("The Title")
                .setItems(my_list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp_text = "You Selected " + my_list[which];
                        Toast.makeText(DialogActivity.this, temp_text, Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void list_radiobutton_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final String[] my_list = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        builder.setTitle("The Title")
                .setSingleChoiceItems(my_list, 3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp_text = "You Selected " + my_list[which];
                        Toast.makeText(DialogActivity.this, temp_text, Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void list_checkbox_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final String[] my_list = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        boolean[] check_list = {true, false, false, true, false};

        builder.setTitle("The Title")
                .setMultiChoiceItems(my_list, check_list, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String temp_text = "You Changed " + my_list[which] + " to " + String.valueOf(isChecked);
                        Toast.makeText(DialogActivity.this, temp_text, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "OK Pressed.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Cancel Pressed.", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void custom_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View customView = inflater.inflate(R.layout.dialog_custom_layout, null);
        final EditText customUsername = customView.findViewById(R.id.username);
        final EditText customPassword = customView.findViewById(R.id.password);

        builder.setView(customView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp_text = String.format(
                                Locale.getDefault(),
                                "Username: %s\nPassword: %s",
                                customUsername.getText().toString(),
                                customPassword.getText().toString()
                        );
                        Toast.makeText(DialogActivity.this, temp_text, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Cancel Pressed.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Nothing", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Nothing Pressed.", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

}
