package com.example.www.androideverest;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WidgetsListenerActivity extends AppCompatActivity {

    CheckBox checkBox;
    RadioGroup radioGroup;
    SeekBar seekBar;
    ProgressBar progressBar_horizontal;
    ToggleButton toggleButton;
    Switch aSwitch;
    RatingBar ratingBar;

    TextView seekBar_status, seekBar_value, ratingbar_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_listener);

        checkBox = findViewById(R.id.widgets_checkbox);
        radioGroup = findViewById(R.id.widgets_radio_group);
        seekBar = findViewById(R.id.widgets_seekbar);
        progressBar_horizontal = findViewById(R.id.widgets_progressbar_horizontal);
        toggleButton = findViewById(R.id.widgets_togglebutton);
        aSwitch = findViewById(R.id.widgets_switch);
        ratingBar = findViewById(R.id.widgets_ratingbar);

        seekBar_value = findViewById(R.id.widgets_seekbar_textview_value);
        seekBar_status = findViewById(R.id.widgets_seekbar_textview_status);
        ratingbar_status = findViewById(R.id.widgets_ratingbar_textview_status);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(WidgetsListenerActivity.this, "You change CheckBox to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.widgets_radio_button_1:
                        Toast.makeText(WidgetsListenerActivity.this, "You select RadioButton 1", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.widgets_radio_button_2:
                        Toast.makeText(WidgetsListenerActivity.this, "You select RadioButton 2", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.widgets_radio_button_3:
                        Toast.makeText(WidgetsListenerActivity.this, "You select RadioButton 3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar_value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar_status.setText("Changing");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar_status.setText("Not Changing");
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(WidgetsListenerActivity.this, "You change ToggleButton to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(WidgetsListenerActivity.this, "You change Switch to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingbar_status.setText(String.valueOf(rating));
            }
        });

    }

    public void progressbar_add_main(int num) {
        int current = progressBar_horizontal.getProgress();
        int max = progressBar_horizontal.getMax();

        if ((current + num) >= max) {
            progressBar_horizontal.setProgress(max);

        } else {
            progressBar_horizontal.setProgress(current + num);
        }
    }

    public void progressbar_add_secondary(int num) {
        int current = progressBar_horizontal.getSecondaryProgress();
        int max = progressBar_horizontal.getMax();

        if ((current + num) >= max) {
            progressBar_horizontal.setSecondaryProgress(max);

        } else {
            progressBar_horizontal.setSecondaryProgress(current + num);
        }
    }

    public void progressbar_add_main_onclick(View view) {
        progressbar_add_main(10);
    }

    public void progressbar_add_secondary_onclick(View view) {
        progressbar_add_secondary(10);
    }

    public void progressbar_auto_fill(View view) {
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressbar_add_main(2);
                progressbar_add_secondary(5);

                if (progressBar_horizontal.getProgress() == progressBar_horizontal.getMax())
                    Toast.makeText(WidgetsListenerActivity.this, "ProgressBar Completed.", Toast.LENGTH_SHORT).show();
                else
                    handler.postDelayed(this, 200);
            }
        };

        handler.postDelayed(runnable, 100);
    }
}
