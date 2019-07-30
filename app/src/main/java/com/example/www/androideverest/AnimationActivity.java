package com.example.www.androideverest;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity {

    TextView tv_fadein, tv_fadeout, tv_fadecross, tv_blink, tv_zoomin, tv_zoomout, tv_flip;
    TextView tv_rotate_c, tv_rotate_cc, tv_move, tv_slideup, tv_slidedown, tv_bounce;

    Animation anim_blink, anim_bounce, anim_fadein, anim_fadeout, anim_zoomin, anim_zoomout;
    Animation anim_rotate_c, anim_rotate_cc, anim_slideup, anim_slidedown, anim_flip, anim_move;
    Animation anim_fadecross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_animation);

        tv_fadein = findViewById(R.id.animation_textview_fadein);
        tv_fadeout = findViewById(R.id.animation_textview_fadeout);
        tv_fadecross = findViewById(R.id.animation_textview_fadecross);
        tv_blink = findViewById(R.id.animation_textview_blink);
        tv_zoomin = findViewById(R.id.animation_textview_zoomin);
        tv_zoomout = findViewById(R.id.animation_textview_zoomout);
        tv_rotate_c = findViewById(R.id.animation_textview_rotateclock);
        tv_rotate_cc = findViewById(R.id.animation_textview_rotatecounterclock);
        tv_move = findViewById(R.id.animation_textview_move);
        tv_slideup = findViewById(R.id.animation_textview_slideup);
        tv_slidedown = findViewById(R.id.animation_textview_slidedown);
        tv_bounce = findViewById(R.id.animation_textview_bounce);
        tv_flip = findViewById(R.id.animation_textview_flip);

        anim_blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        anim_bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        anim_fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        anim_fadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        anim_zoomin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        anim_zoomout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        anim_rotate_c = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        anim_rotate_cc = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_counterclockwise);
        anim_slideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        anim_slidedown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        anim_flip = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flip);
        anim_move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);

        anim_fadecross = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        anim_fadecross.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv_fadecross.startAnimation(anim_fadein);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    public void fade_in(View view) {
        tv_fadein.startAnimation(anim_fadein);
    }

    public void fade_out(View view) {
        tv_fadeout.startAnimation(anim_fadeout);
    }

    public void fade_cross(View view) {
        tv_fadecross.startAnimation(anim_fadecross);
    }

    public void blink(View view) {
        tv_blink.startAnimation(anim_blink);
    }

    public void zoom_in(View view) {
        tv_zoomin.startAnimation(anim_zoomin);
    }

    public void zoom_out(View view) {
        tv_zoomout.startAnimation(anim_zoomout);
    }

    public void rotate_clock(View view) {
        tv_rotate_c.startAnimation(anim_rotate_c);
    }

    public void rotate_counter_clock(View view) {
        tv_rotate_cc.startAnimation(anim_rotate_cc);
    }

    public void move(View view) {
        tv_move.startAnimation(anim_move);
    }

    public void slide_up(View view) {
        tv_slideup.startAnimation(anim_slideup);
    }

    public void slide_down(View view) {
        tv_slidedown.startAnimation(anim_slidedown);
    }

    public void bounce(View view) {
        tv_bounce.startAnimation(anim_bounce);
    }

    public void flip(View view) {
        tv_flip.startAnimation(anim_flip);
    }
}
