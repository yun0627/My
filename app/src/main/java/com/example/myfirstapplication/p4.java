package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class p4 extends AppCompatActivity implements View.OnClickListener {
    private Button[][] array = new Button[3][3];
    int player1point;
    int player2point;
    boolean player1turn = true;
int gameround = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);
        TextView Textviewplayer1 = findViewById(R.id.textView1);
        TextView Textviewplayer2 = findViewById(R.id.textView2);
        Button reset = findViewById(R.id.button12);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int resID = getResources().getIdentifier("button_" + i + j, "id", getPackageName());
                array[i][j] = findViewById(resID);
                array[i][j].setOnClickListener(this);
            }
        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j].setText("");


            }
        }
    }

    private void resetGame() {
        player1point = 0;
        player2point = 0;
        resetBoard();
    }


    @Override
    public void onClick(View v) {
        if (player1turn) {
            ((Button) v).setText("X");
            player1turn = false;
        } else {
            ((Button) v).setText("O");
            player1turn = true;

        }
        gameround++;
        if (!checkforwin()){
            resetBoard();

        }
        if (gameround == 9){
            draw();
        }
    }

    private boolean checkforwin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = array[i][j].getText().toString();
            }
        }
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] == field[2][2]) {
            return true;
        }
        if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] == field[2][0]) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2]) {
                return true;

            }


        }
        for (int j = 0; j < 3; j++) {
            if (field[0][j] == field[1][j] && field[0][j] == field[2][j]) {
                return true;

            }


        }
        return false;
    }
    private void draw(){
        Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
        resetBoard();
    }
}