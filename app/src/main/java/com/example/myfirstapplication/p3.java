package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class p3 extends AppCompatActivity {
    ImageView bottle;
    Random rand = new Random();
    int a;
    int b;
    boolean spinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        bottle = findViewById(R.id.bottlepic);
    }

    public void spinBottle(View v){
        if(!spinning) {
            b = rand.nextInt(14400);
            float y = bottle.getHeight() / 2;
            float x = bottle.getWidth() / 2;
            final Animation spin = new RotateAnimation(a, b, x, y);
            spin.setDuration(3000);
            bottle.startAnimation(spin);
            spin.setFillAfter(true);
            a = b;
            spin.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }

    }
}