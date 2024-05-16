package com.example.alias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView alias;
    Button start;
    ImageButton info;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView alias = findViewById(R.id.alias);
        Button start = findViewById(R.id.start);
        ImageButton info = findViewById(R.id.info);
        ConstraintLayout main1 = findViewById(R.id.main1);

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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity6.class);
                startActivity(intent);
                finish();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        /*Language*/
        if ( MainActivity6.Armenian ) {
            start.setText("Սկսել");
            alias.setText("Ալիաս");
            alias.setTextSize(75);
            alias.setTranslationY(-110);
        }
        else if ( MainActivity6.Russian ) {
            start.setText("Начинать");
            alias.setText("Алиас");
            alias.setTextSize(75);
            alias.setTranslationY(-110);
        }
        else if ( MainActivity6.English ) {
            start.setText("Start");
            alias.setText("Alias");
        }
        /*Language*/

        /*Colors*/
        if ( MainActivity6.isColor1Selected ) {
            main1.setBackgroundColor(white);
            alias.setTextColor(black);
            start.setTextColor(white);
            start.setBackgroundColor(black);
            info.setBackgroundColor(white);
            info.setImageResource(R.drawable.info_black);
        }
        else if ( MainActivity6.isColor2Selected ) {
            main1.setBackgroundColor(dark_emerald_green);
            alias.setTextColor(pure_gold);
            start.setTextColor(dark_emerald_green);
            start.setBackgroundColor(pure_gold);
            info.setBackgroundColor(dark_emerald_green);
            info.setImageResource(R.drawable.info_pure_gold);
        }
        else if ( MainActivity6.isColor3Selected ) {
            main1.setBackgroundColor(yellow);
            alias.setTextColor(black);
            start.setTextColor(yellow);
            start.setBackgroundColor(black);
            info.setBackgroundColor(yellow);
            info.setImageResource(R.drawable.info_black);
        }
        else if ( MainActivity6.isColor4Selected ) {
            main1.setBackgroundColor(red);
            alias.setTextColor(black);
            start.setTextColor(red);
            start.setBackgroundColor(black);
            info.setBackgroundColor(red);
            info.setImageResource(R.drawable.info_black);
        }
        else if ( MainActivity6.isColor5Selected ) {
            main1.setBackgroundColor(teal);
            alias.setTextColor(coral);
            start.setTextColor(teal);
            start.setBackgroundColor(coral);
            info.setBackgroundColor(teal);
            info.setImageResource(R.drawable.info_coral);
        }
        else if ( MainActivity6.isColor6Selected ) {
            main1.setBackgroundColor(blooming_dahlia);
            alias.setTextColor(purple);
            start.setTextColor(blooming_dahlia);
            start.setBackgroundColor(purple);
            info.setBackgroundColor(blooming_dahlia);
            info.setImageResource(R.drawable.info_purple);
        }
        else if ( MainActivity6.isColor7Selected ) {
            main1.setBackgroundColor(orange);
            alias.setTextColor(black);
            start.setTextColor(orange);
            start.setBackgroundColor(black);
            info.setBackgroundColor(orange);
            info.setImageResource(R.drawable.info_black);
        }
        else if ( MainActivity6.isColor8Selected ) {
            main1.setBackgroundColor(light_blue);
            alias.setTextColor(orange);
            start.setTextColor(light_blue);
            start.setBackgroundColor(orange);
            info.setBackgroundColor(light_blue);
            info.setImageResource(R.drawable.info_orange);
        }
        /*Colors*/
    }
}