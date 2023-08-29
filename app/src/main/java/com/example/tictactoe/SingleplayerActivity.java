package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SingleplayerActivity extends AppCompatActivity {
    boolean gameActive = true;
    int flag = 0;
    int size=9;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = 0;
            img.setTranslationY(-1000f);
            img.setImageResource(R.drawable.x);
            TextView status = findViewById(R.id.status);
            status.setText("O's Turn - Tap the tile to play");
            img.animate().translationYBy(1000f).setDuration(300);
            Random random = new Random();
            int rand = 0;
            size--;
            if (size > 0) {
                while (true) {
                    rand = random.nextInt(9);
                    if (gameState[rand] == 2) break;
                }
                gameState[rand] = 1;
                ImageView img1 = (ImageView) findViewById(R.id.activity_singleplayer).findViewWithTag(Integer.toString(rand));
                img1.setTranslationY(-1000f);
                img1.setImageResource(R.drawable.o);
                status.setText("X's Turn - Tap the tile to play");
                img1.animate().translationYBy(1000f).setDuration(300);
                System.out.println(rand - 1);
                size--;
            }
        }
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                // Somebody has won! - Find out who!
                String winnerStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = "Congratulations X has won!";
                } else {
                    winnerStr = "Congratulations O has won!";
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
        if(flag==0 && gameActive) {
            for (int i = 0; i < gameState.length; i++) {
                if (gameState[i] != 2) {
                    gameActive = false;
                    flag = 1;
                } else {
                    gameActive = true;
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                TextView status = findViewById(R.id.status);
                status.setText("It's a tie! Click to start a new game");
            }
        }
    }
    public void gameReset(View view) {
        gameActive = true;
        size=9;
        flag = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap the tile to play");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
    }
}