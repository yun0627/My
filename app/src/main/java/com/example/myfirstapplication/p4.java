package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class p4 extends AppCompatActivity implements View.OnClickListener {
    private Button[][] array = new Button[3][3];
    boolean player1turn = true;
    int gameround = 0;
    TextView Textviewplayer1;
    TextView Textviewplayer2;
    int score_player1 = 0;
    int score_player2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);
        Textviewplayer1 = findViewById(R.id.textView1);
        Textviewplayer2 = findViewById(R.id.textView2);
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
        gameround = 0;
        player1turn = true;
    }

    private void resetGame() {
        score_player1 = 0;
        score_player2 = 0;
        updatepointtext();
        resetBoard();
    }


    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")){
            return;
        }
        if (player1turn) {
            ((Button) v).setText("X");

        } else {
            ((Button) v).setText("O");


        }
        gameround++;
        if (checkforwin()) {
            if (player1turn) {
                player1win();
            } else {
                player2win();

            }
        }
        else if(gameround == 9) {
            draw();
        }
        else {
            player1turn = !player1turn;
        }
    }

    private boolean checkforwin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = array[i][j].getText().toString();
            }
        }
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] == field[2][2] && !field[0][0].equals("")) {

            return true;
        }
        if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] == field[2][0] && !field[0][2].equals("")) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && !field[i][0].equals("")) {

                return true;

            }

        }
        for (int j = 0; j < 3; j++) {
            if (field[0][j] == field[1][j] && field[0][j] == field[2][j] && !field[0][j].equals("")) {
                return true;

            }

        }
        return false;
    }

    private void draw() {
        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatepointtext() {
        Textviewplayer1.setText("Player 1: " + score_player1);
        Textviewplayer2.setText("Player 2: " + score_player2);

    }

    private void player1win() {
        score_player1++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatepointtext();
        resetBoard();
    }

    private void player2win() {
        score_player2++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatepointtext();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("gameround", gameround);
        outState.putInt("score_player1", score_player1);
        outState.putInt("score_player2", score_player2);
        outState.putBoolean("player1turn", player1turn);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        gameround = savedInstanceState.getInt("gameround");
        score_player1 = savedInstanceState.getInt("score_player1");
        score_player2 = savedInstanceState.getInt("score_player2");
        player1turn = savedInstanceState.getBoolean("player1turn");
    }
}