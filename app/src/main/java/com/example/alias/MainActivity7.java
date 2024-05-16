package com.example.alias;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity7 extends AppCompatActivity {

    Button exit;
    TextView win;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main7);

        TextView win = findViewById(R.id.win);
        Button exit = findViewById(R.id.exit);
        ConstraintLayout main7 = findViewById(R.id.main7);

        int black = ContextCompat.getColor(this, R.color.black);
        int white = ContextCompat.getColor(this, R.color.white);
        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);
        int yellow = ContextCompat.getColor(this, R.color.yellow);
        int red = ContextCompat.getColor(this, R.color.red);
        int coral = ContextCompat.getColor(this, R.color.coral);
        int teal = ContextCompat.getColor(this, R.color.teal);
        int purple = ContextCompat.getColor(this, R.color.purple);
        int blooming_dahlia = ContextCompat.getColor(this, R.color.blooming_dahlia);
        int orange = ContextCompat.getColor(this, R.color.orange);
        int light_blue = ContextCompat.getColor(this, R.color.light_blue);

        boolean team1_win = getIntent().getBooleanExtra("team1_win", true);
        boolean team2_win = getIntent().getBooleanExtra("team2_win", true);
        if ( team1_win ) {
            win.setText("Team 1 won");
        } else if ( team2_win ) {
            win.setText("Team 2 won");
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });

        /*Colors*/
        if ( MainActivity6.isColor1Selected ) {
            main7.setBackgroundColor(white);
            win.setTextColor(black);
            exit.setBackgroundColor(black);
            exit.setTextColor(white);
        } else if ( MainActivity6.isColor2Selected ) {
            main7.setBackgroundColor(dark_emerald_green);
            win.setTextColor(pure_gold);
            exit.setBackgroundColor(pure_gold);
            exit.setTextColor(dark_emerald_green);
        } else if ( MainActivity6.isColor3Selected ) {
            main7.setBackgroundColor(yellow);
            win.setTextColor(black);
            exit.setBackgroundColor(black);
            exit.setTextColor(yellow);
        } else if ( MainActivity6.isColor4Selected ) {
            main7.setBackgroundColor(red);
            win.setTextColor(black);
            exit.setBackgroundColor(black);
            exit.setTextColor(red);
        } else if ( MainActivity6.isColor5Selected ) {
            main7.setBackgroundColor(teal);
            win.setTextColor(coral);
            exit.setBackgroundColor(coral);
            exit.setTextColor(teal);
        } else if ( MainActivity6.isColor6Selected ) {
            main7.setBackgroundColor(blooming_dahlia);
            win.setTextColor(purple);
            exit.setBackgroundColor(purple);
            exit.setTextColor(blooming_dahlia);
        } else if ( MainActivity6.isColor7Selected ) {
            main7.setBackgroundColor(orange);
            win.setTextColor(black);
            exit.setBackgroundColor(black);
            exit.setTextColor(orange);
        } else if ( MainActivity6.isColor8Selected ) {
            main7.setBackgroundColor(light_blue);
            win.setTextColor(orange);
            exit.setBackgroundColor(orange);
            exit.setTextColor(light_blue);
        }
        /*Colors*/
    }
}