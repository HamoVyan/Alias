package com.example.alias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    ImageButton back;
    TextView color, language;
    RadioButton armenian, english, russian;
    Button next;
    RadioButton color1, color2, color3, color4, color5, color6, color7, color8;
    public static boolean isColor1Selected = false;
    public static boolean isColor2Selected = false;
    public static boolean isColor3Selected = false;
    public static boolean isColor4Selected = false;
    public static boolean isColor5Selected = false;
    public static boolean isColor6Selected = false;
    public static boolean isColor7Selected = false;
    public static boolean isColor8Selected = false;

    public static boolean Armenian = false;
    public static boolean Russian = false;
    public static boolean English = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main6);

        ImageButton back = findViewById(R.id.back);
        RadioButton armenian = findViewById(R.id.armenian);
        RadioButton english = findViewById(R.id.english);
        RadioButton russian = findViewById(R.id.russian);
        Button next = findViewById(R.id.next);
        TextView language = findViewById(R.id.language);
        TextView color = findViewById(R.id.color);
        RadioButton color1 = findViewById(R.id.color1);
        RadioButton color2 = findViewById(R.id.color2);
        RadioButton color3 = findViewById(R.id.color3);
        RadioButton color4 = findViewById(R.id.color4);
        RadioButton color5 = findViewById(R.id.color5);
        RadioButton color6 = findViewById(R.id.color6);
        RadioButton color7 = findViewById(R.id.color7);
        RadioButton color8 = findViewById(R.id.color8);
        ConstraintLayout main6 = findViewById(R.id.main6);

        int gray = ContextCompat.getColor(this, R.color.gray);
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

        armenian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Armenian = armenian.isChecked();
                language.setText("Ընտրեք լեզուն");
                armenian.setText("Հայերեն");
                russian.setText("Ռուսերեն");
                english.setText("Անգլերեն");
                color.setText("Ընտրեք գույնը");
                next.setText("Հաջորդը");
                next.setTextSize(23);
            }
        });

        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Russian = russian.isChecked();
                language.setText("Выберите язык");
                armenian.setText("Армянский");
                russian.setText("Русский");
                english.setText("Английский");
                color.setText("Выберите цвет");
                next.setText("Следующий");
                next.setTextSize(18);
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                English = english.isChecked();
                language.setText("Choose the language");
                armenian.setText("Armenian");
                russian.setText("Russian");
                english.setText("English");
                color.setText("Choose the color");
                next.setText("Next");
            }
        });

        /*Colors*/
        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor1Selected = color1.isChecked();
                main6.setBackgroundColor(white);
                back.setBackgroundColor(white);
                language.setTextColor(black);
                armenian.setTextColor(black);
                russian.setTextColor(black);
                english.setTextColor(black);
                color.setTextColor(black);
                color1.setBackgroundColor(white);
                color2.setBackgroundColor(white);
                color3.setBackgroundColor(white);
                color4.setBackgroundColor(white);
                color5.setBackgroundColor(white);
                color6.setBackgroundColor(white);
                color7.setBackgroundColor(white);
                color8.setBackgroundColor(white);
                next.setTextColor(white);
                next.setBackgroundColor(black);
                back.setImageResource(R.drawable.back_black);
            }
        });

        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor2Selected = color2.isChecked();
                main6.setBackgroundColor(dark_emerald_green);
                back.setBackgroundColor(dark_emerald_green);
                language.setTextColor(pure_gold);
                armenian.setTextColor(pure_gold);
                russian.setTextColor(pure_gold);
                english.setTextColor(pure_gold);
                color.setTextColor(pure_gold);
                color1.setBackgroundColor(dark_emerald_green);
                color2.setBackgroundColor(dark_emerald_green);
                color3.setBackgroundColor(dark_emerald_green);
                color4.setBackgroundColor(dark_emerald_green);
                color5.setBackgroundColor(dark_emerald_green);
                color6.setBackgroundColor(dark_emerald_green);
                color7.setBackgroundColor(dark_emerald_green);
                color8.setBackgroundColor(dark_emerald_green);
                next.setTextColor(dark_emerald_green);
                next.setBackgroundColor(pure_gold);
                back.setImageResource(R.drawable.back_pure_gold);
            }
        });

        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor3Selected = color3.isChecked();
                main6.setBackgroundColor(yellow);
                back.setBackgroundColor(yellow);
                language.setTextColor(black);
                armenian.setTextColor(black);
                russian.setTextColor(black);
                english.setTextColor(black);
                color.setTextColor(black);
                color1.setBackgroundColor(yellow);
                color2.setBackgroundColor(yellow);
                color3.setBackgroundColor(yellow);
                color4.setBackgroundColor(yellow);
                color5.setBackgroundColor(yellow);
                color6.setBackgroundColor(yellow);
                color7.setBackgroundColor(yellow);
                color8.setBackgroundColor(yellow);
                next.setTextColor(yellow);
                next.setBackgroundColor(black);
                back.setImageResource(R.drawable.back_black);
            }
        });

        color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor4Selected = color4.isChecked();
                main6.setBackgroundColor(red);
                back.setBackgroundColor(red);
                language.setTextColor(black);
                armenian.setTextColor(black);
                russian.setTextColor(black);
                english.setTextColor(black);
                color.setTextColor(black);
                color1.setBackgroundColor(red);
                color2.setBackgroundColor(red);
                color3.setBackgroundColor(red);
                color4.setBackgroundColor(red);
                color5.setBackgroundColor(red);
                color6.setBackgroundColor(red);
                color7.setBackgroundColor(red);
                color8.setBackgroundColor(red);
                next.setTextColor(red);
                next.setBackgroundColor(black);
                back.setImageResource(R.drawable.back_black);
            }
        });

        color5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor5Selected = color5.isChecked();
                main6.setBackgroundColor(teal);
                back.setBackgroundColor(teal);
                language.setTextColor(coral);
                armenian.setTextColor(coral);
                russian.setTextColor(coral);
                english.setTextColor(coral);
                color.setTextColor(coral);
                color1.setBackgroundColor(teal);
                color2.setBackgroundColor(teal);
                color3.setBackgroundColor(teal);
                color4.setBackgroundColor(teal);
                color5.setBackgroundColor(teal);
                color6.setBackgroundColor(teal);
                color7.setBackgroundColor(teal);
                color8.setBackgroundColor(teal);
                next.setTextColor(teal);
                next.setBackgroundColor(coral);
                back.setImageResource(R.drawable.back_coral);
            }
        });

        color6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor6Selected = color6.isChecked();
                main6.setBackgroundColor(blooming_dahlia);
                back.setBackgroundColor(blooming_dahlia);
                language.setTextColor(purple);
                armenian.setTextColor(purple);
                russian.setTextColor(purple);
                english.setTextColor(purple);
                color.setTextColor(purple);
                color1.setBackgroundColor(blooming_dahlia);
                color2.setBackgroundColor(blooming_dahlia);
                color3.setBackgroundColor(blooming_dahlia);
                color4.setBackgroundColor(blooming_dahlia);
                color5.setBackgroundColor(blooming_dahlia);
                color6.setBackgroundColor(blooming_dahlia);
                color7.setBackgroundColor(blooming_dahlia);
                color8.setBackgroundColor(blooming_dahlia);
                next.setTextColor(blooming_dahlia);
                next.setBackgroundColor(purple);
                back.setImageResource(R.drawable.back_purple);

            }
        });

        color7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor7Selected = color7.isChecked();
                main6.setBackgroundColor(orange);
                back.setBackgroundColor(orange);
                language.setTextColor(black);
                armenian.setTextColor(black);
                russian.setTextColor(black);
                english.setTextColor(black);
                color.setTextColor(black);
                color1.setBackgroundColor(orange);
                color2.setBackgroundColor(orange);
                color3.setBackgroundColor(orange);
                color4.setBackgroundColor(orange);
                color5.setBackgroundColor(orange);
                color6.setBackgroundColor(orange);
                color7.setBackgroundColor(orange);
                color8.setBackgroundColor(orange);
                next.setTextColor(orange);
                next.setBackgroundColor(black);
                back.setImageResource(R.drawable.back_black);
            }
        });

        color8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isColor8Selected = color8.isChecked();
                main6.setBackgroundColor(light_blue);
                back.setBackgroundColor(light_blue);
                language.setTextColor(orange);
                armenian.setTextColor(orange);
                russian.setTextColor(orange);
                english.setTextColor(orange);
                color.setTextColor(orange);
                color1.setBackgroundColor(light_blue);
                color2.setBackgroundColor(light_blue);
                color3.setBackgroundColor(light_blue);
                color4.setBackgroundColor(light_blue);
                color5.setBackgroundColor(light_blue);
                color6.setBackgroundColor(light_blue);
                color7.setBackgroundColor(light_blue);
                color8.setBackgroundColor(light_blue);
                next.setTextColor(light_blue);
                next.setBackgroundColor(orange);
                back.setImageResource(R.drawable.back_orange);
            }
        });
        /*Colors*/

        CompoundButton.OnCheckedChangeListener listener2 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != armenian) {
                        armenian.setChecked(false);
                    }
                    if (buttonView != english) {
                        english.setChecked(false);
                    }
                    if (buttonView != russian) {
                        russian.setChecked(false);
                    }
                }
            }
        };
        armenian.setOnCheckedChangeListener(listener2);
        english.setOnCheckedChangeListener(listener2);
        russian.setOnCheckedChangeListener(listener2);

        CompoundButton.OnCheckedChangeListener listener3 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != color1) {
                        color1.setChecked(false);
                    }
                    if (buttonView != color2) {
                        color2.setChecked(false);
                    }
                    if (buttonView != color3) {
                        color3.setChecked(false);
                    }
                    if (buttonView != color4) {
                        color4.setChecked(false);
                    }
                    if (buttonView != color5) {
                        color5.setChecked(false);
                    }
                    if (buttonView != color6) {
                        color6.setChecked(false);
                    }
                    if (buttonView != color7) {
                        color7.setChecked(false);
                    }
                    if (buttonView != color8) {
                        color8.setChecked(false);
                    }
                }
            }
        };
        color1.setOnCheckedChangeListener(listener3);
        color2.setOnCheckedChangeListener(listener3);
        color3.setOnCheckedChangeListener(listener3);
        color4.setOnCheckedChangeListener(listener3);
        color5.setOnCheckedChangeListener(listener3);
        color6.setOnCheckedChangeListener(listener3);
        color7.setOnCheckedChangeListener(listener3);
        color8.setOnCheckedChangeListener(listener3);

        /*Default*/
        english.setChecked(true);
        color1.setChecked(true);
        /*Default*/

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Armenian = armenian.isChecked();
                Russian = russian.isChecked();
                English = english.isChecked();
                isColor1Selected = color1.isChecked();
                isColor2Selected = color2.isChecked();
                isColor3Selected = color3.isChecked();
                isColor4Selected = color4.isChecked();
                isColor5Selected = color5.isChecked();
                isColor6Selected = color6.isChecked();
                isColor7Selected = color7.isChecked();
                isColor8Selected = color8.isChecked();
                Intent intent = new Intent(MainActivity6.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Armenian = armenian.isChecked();
                Russian = russian.isChecked();
                English = english.isChecked();
                isColor1Selected = color1.isChecked();
                isColor2Selected = color2.isChecked();
                isColor3Selected = color3.isChecked();
                isColor4Selected = color4.isChecked();
                isColor5Selected = color5.isChecked();
                isColor6Selected = color6.isChecked();
                isColor7Selected = color7.isChecked();
                isColor8Selected = color8.isChecked();
                Intent intent = new Intent(MainActivity6.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });
    }
}