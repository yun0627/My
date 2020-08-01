package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView dice_Image;
private Button button;
Random random_dice = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dicebutton = findViewById(R.id.button1);

        dicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotodice = new Intent(MainActivity.this,p2.class);
                startActivity(gotodice);
            }
        });
        Button bottlebutton = findViewById(R.id.button2);

        bottlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotobottle = new Intent(MainActivity.this,p3.class);
                startActivity(gotobottle);
            }
        });
        Button ticbutton = findViewById(R.id.button3);
        ticbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototic = new Intent(MainActivity.this,p4.class);
                startActivity(gototic);
            }
        });
    }
}