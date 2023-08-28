package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void multiplayer(View view) {
        Intent intent = new Intent(this, MultiplayerActivity.class);
        startActivity(intent);
    }
    public void singleplayer(View view) {
        Intent intent = new Intent(this, SingleplayerActivity.class);
        startActivity(intent);
    }
}