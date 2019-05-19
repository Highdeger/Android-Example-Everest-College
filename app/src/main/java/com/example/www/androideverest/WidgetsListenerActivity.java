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

//        ایجاد Listener برای CheckBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //            این متد زمانی اجرا می شود که CheckBox تغییر کند
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                متغییر isChecked برای مشخض کردن تیک خوردن یا تیک برداشتن
//                متغییر buttonView برای دسترسی به CheckBox که کلیک شده است

                Toast.makeText(WidgetsListenerActivity.this, "You change CheckBox to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

//        ایجاد Listener برای RadioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            این متد زمانی اجرا می شود که RadioGroup تغییر کند
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                متغییر checkedId برای مشخض کردن آی دی RadioButton است که انتخاب شده
//                متغییر group برای دسترسی به RadioGroup موردنظر است

//                با این Switch متغییر checkedId را با آی دی همه RadioButton ها مقایسه می کنیم
//                سپس می توانیم واکنشی مناسب با هر کدام نشان دهیم
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

//        ایجاد Listener برای SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            این متد زمانی اجرا می شود که SeekBar تغییر کند
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                متغییر fromUser برای این است که مشخص شود کاربر تغییر را اعمال کرده یا خیر
//                متغییر progress برای مشخص کردن میزان جدید پیشروی بعد از تغییر است
//                متغییر seekBar برای دسترسی به SeekBar موردنظر است

                seekBar_value.setText(String.valueOf(progress));
            }

//            این متد زمانی اجرا می شود که کاربر شروع به حرکت دادن SeekBar کند
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar_status.setText("Changing");
            }

//            این متد زمانی اجرا می شود که حرکت دادن SeekBar را متوقف کند
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar_status.setText("Not Changing");
            }
        });

//        ایجاد Listener برای ToggleButton
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            این متد زمانی اجرا می شود که ToggleButton تغییر کند
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(WidgetsListenerActivity.this, "You change ToggleButton to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

//        ایجاد Listener برای Switch
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            این متد زمانی اجرا می شود که Switch تغییر کند
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(WidgetsListenerActivity.this, "You change Switch to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

//        ایجاد Listener برای RatingBar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            این متد زمانی اجرا می شود که RatingBar تغییر کند
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                متغییر fromUser برای این است که مشخص شود کاربر تغییر را اعمال کرده یا خیر
//                متغییر rating برای مشخص کردن میزان جدید امتیاز بعد از تغییر است
//                متغییر ratingBar برای دسترسی به RatingBar موردنظر است

                ratingbar_status.setText(String.valueOf(rating));
            }
        });

    }

//    در این متد میزان پیشروی ProgressBar به مقدار معین افزایش میدهد
    public void progressbar_add_main(int num) {
        int current = progressBar_horizontal.getProgress();
        int max = progressBar_horizontal.getMax();

//        اگر بعد از افزایش از مقدار max بیشتر شود همان مقدار max برای ProgressBar تعیین می شود
        if ((current + num) >= max) {
            progressBar_horizontal.setProgress(max);

//        اگر بعد از افزایش از مقدار max بیشتر نشود مقدار افزایش یافته برای ProgressBar تعیین می شود
        } else {
            progressBar_horizontal.setProgress(current + num);
        }
    }

//    این متد دقیقا عین متد بالا عمل می کند ولی برای خط ProgressBar دوم یا همان secondary
    public void progressbar_add_secondary(int num) {
        int current = progressBar_horizontal.getSecondaryProgress();
        int max = progressBar_horizontal.getMax();

        if ((current + num) >= max) {
            progressBar_horizontal.setSecondaryProgress(max);

        } else {
            progressBar_horizontal.setSecondaryProgress(current + num);
        }
    }

//    این متد onClick میزان پیشروی خط اصلی ProgressBar را ده واحد افزایش می دهد
    public void progressbar_add_main_onclick(View view) {
        progressbar_add_main(10);
    }

    //    این متد onClick میزان پیشروی خط دوم یا secondary برای ProgressBar را ده واحد افزایش می دهد
    public void progressbar_add_secondary_onclick(View view) {
        progressbar_add_secondary(10);
    }

//    با استفاده از Runnable هر 200 میلی ثانیه خط اصلی را دو واحد و خط فرعی را 5 واحد افزایش می دهد
    public void progressbar_auto_fill(View view) {
        final Handler handler = new Handler();

//        ایجاد یک Runnable برای اجرای منظم کد افزایش خط اصلی و فرعی ProgressBar
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressbar_add_main(2);
                progressbar_add_secondary(5);

//                در صورت به انتها رسیدن خط اصلی ProgressBar پیغام تکمیل شدن را نمایش می دهد
                if (progressBar_horizontal.getProgress() == progressBar_horizontal.getMax())
                    Toast.makeText(WidgetsListenerActivity.this, "ProgressBar Completed.", Toast.LENGTH_SHORT).show();
                else
                    handler.postDelayed(this, 200);
            }
        };

//        اجرای Runnable ایجاد شده توسط یک Handler
        handler.postDelayed(runnable, 100);
    }
}
