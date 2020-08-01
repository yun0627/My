package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class p2 extends AppCompatActivity {
    private ImageView dice_Image;
    private Button button;
    Random random_dice = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        dice_Image = (ImageView) findViewById(R.id.dice1);
        button = (Button) findViewById(R.id.dice_roll);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaddice();

            }
        });

    }

    private void loaddice() {

        int rand = random_dice.nextInt(6) +1;

        switch (rand) {
            case 1:
                dice_Image.setImageResource(R.drawable.dice11);
                break;
            case 2:
                dice_Image.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice_Image.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice_Image.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice_Image.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice_Image.setImageResource(R.drawable.dice6);
                break;
        }

    }
}