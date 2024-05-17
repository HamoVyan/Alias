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
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView language, section, time, score;
    RadioButton sec1, sec2, sec3, sec4, sec5, sec6;
    RadioButton time45, time60, time75, time90;
    RadioButton score25, score50, score75, score100;
    Button next;
    public static boolean isTime45Selected = false;
    public static boolean isTime60Selected = false;
    public static boolean isTime75Selected = false;
    public static boolean isTime90Selected = false;
    public static boolean isScore25Selected = false;
    public static boolean isScore50Selected = false;
    public static boolean isScore75Selected = false;
    public static boolean isScore100Selected = false;
    public static boolean is_common_words_selected = false;
    public static boolean is_famous_peoples_selected = false;
    public static boolean is_city_countries_selected = false;
    public static boolean is_pantomime_selected = false;
    public static boolean is_films_selected = false;
    public static boolean is_all_selected = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main5);

        TextView section = findViewById(R.id.section);
        TextView language = findViewById(R.id.language);
        Button next = findViewById(R.id.next);
        RadioButton sec1 = findViewById(R.id.sec1);
        RadioButton sec2 = findViewById(R.id.sec2);
        RadioButton sec3 = findViewById(R.id.sec3);
        RadioButton sec4 = findViewById(R.id.sec4);
        RadioButton sec5 = findViewById(R.id.sec5);
        RadioButton sec6 = findViewById(R.id.sec6);
        TextView time = findViewById(R.id.time);
        RadioButton time45 = findViewById(R.id.time45);
        RadioButton time60 = findViewById(R.id.time60);
        RadioButton time75 = findViewById(R.id.time75);
        RadioButton time90 = findViewById(R.id.time90);
        TextView score = findViewById(R.id.score);
        RadioButton score25 = findViewById(R.id.score25);
        RadioButton score50 = findViewById(R.id.score50);
        RadioButton score75 = findViewById(R.id.score75);
        RadioButton score100 = findViewById(R.id.score100);
        ConstraintLayout main5 = findViewById(R.id.main5);

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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTime45Selected = time45.isChecked();
                isTime60Selected = time60.isChecked();
                isTime75Selected = time75.isChecked();
                isTime90Selected = time90.isChecked();

                isScore25Selected = score25.isChecked();
                isScore50Selected = score50.isChecked();
                isScore75Selected = score75.isChecked();
                isScore100Selected = score100.isChecked();

                is_common_words_selected = sec1.isChecked();
                is_famous_peoples_selected = sec2.isChecked();
                is_city_countries_selected = sec3.isChecked();
                is_pantomime_selected = sec4.isChecked();
                is_films_selected = sec5.isChecked();
                is_all_selected = sec6.isChecked();

                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
                finish();
            }
        });

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != sec1) {
                        sec1.setChecked(false);
                    }
                    if (buttonView != sec2) {
                        sec2.setChecked(false);
                    }
                    if (buttonView != sec3) {
                        sec3.setChecked(false);
                    }
                    if (buttonView != sec4) {
                        sec4.setChecked(false);
                    }
                    if (buttonView != sec4) {
                        sec4.setChecked(false);
                    }
                    if (buttonView != sec5) {
                        sec5.setChecked(false);
                    }
                    if (buttonView != sec6) {
                        sec6.setChecked(false);
                    }
                }
            }
        };

        sec1.setOnCheckedChangeListener(listener);
        sec2.setOnCheckedChangeListener(listener);
        sec3.setOnCheckedChangeListener(listener);
        sec4.setOnCheckedChangeListener(listener);
        sec5.setOnCheckedChangeListener(listener);
        sec6.setOnCheckedChangeListener(listener);

        CompoundButton.OnCheckedChangeListener listener3 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != time45) {
                        time45.setChecked(false);
                    }
                    if (buttonView != time60) {
                        time60.setChecked(false);
                    }
                    if (buttonView != time75) {
                        time75.setChecked(false);
                    }
                    if (buttonView != time90) {
                        time90.setChecked(false);
                    }
                }
            }
        };

        time45.setOnCheckedChangeListener(listener3);
        time60.setOnCheckedChangeListener(listener3);
        time75.setOnCheckedChangeListener(listener3);
        time90.setOnCheckedChangeListener(listener3);

        CompoundButton.OnCheckedChangeListener listener4 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != score25) {
                        score25.setChecked(false);
                    }
                    if (buttonView != score50) {
                        score50.setChecked(false);
                    }
                    if (buttonView != score75) {
                        score75.setChecked(false);
                    }
                    if (buttonView != score100) {
                        score100.setChecked(false);
                    }
                }
            }
        };

        score25.setOnCheckedChangeListener(listener4);
        score50.setOnCheckedChangeListener(listener4);
        score75.setOnCheckedChangeListener(listener4);
        score100.setOnCheckedChangeListener(listener4);

        /*Default selected*/
        sec1.setChecked(true);
        time45.setChecked(true);
        score25.setChecked(true);
        /*Default selected*/

        /*Language*/
        if ( MainActivity6.Armenian == true ) {
            section.setText("Ընտրեք բաժինը");
            sec1.setText("Ընդհանուր բառեր");
            sec2.setText("Հայտնի մարդիկ");
            sec3.setText("Երկիր-քաղաքներ");
            sec4.setText("Մնջախաղ");
            sec5.setText("Ֆիլմեր");
            sec6.setText("Բոլորը");
            time.setText("Ժամանակ");
            score.setText("Հաղթական միավոր");
            next.setText("Հաջորդը");
            next.setTextSize(23);
        } else if ( MainActivity6.English ) {
            section.setText("Choose the section");
            sec1.setText("Common words");
            sec2.setText("Famous people");
            sec3.setText("City-countries");
            sec4.setText("Pantomime");
            sec5.setText("Films");
            sec6.setText("All");
            time.setText("Stage duration");
            score.setText("Winning score");
        } else if ( MainActivity6.Russian == true ) {
            section.setText("Выберите раздел");
            sec1.setText("Общеупотребительные слова");
            sec2.setText("Известные люди");
            sec3.setText("Города-страны");
            sec4.setText("Пантомима");
            sec5.setText("Фильмы");
            sec6.setText("Всё");
            time.setText("Продолжительность раунда");
            score.setText("Победный счет");
            next.setText("Следующий");
            next.setTextSize(18);
        }
        /*Language*/

        /*Colors*/
        if ( MainActivity6.isColor1Selected ) {
            main5.setBackgroundColor(white);
            section.setTextColor(black);
            sec1.setTextColor(black);
            sec2.setTextColor(black);
            sec3.setTextColor(black);
            sec4.setTextColor(black);
            sec5.setTextColor(black);
            sec6.setTextColor(black);
            time.setTextColor(black);
            time45.setTextColor(black);
            time60.setTextColor(black);
            time75.setTextColor(black);
            time90.setTextColor(black);
            score.setTextColor(black);
            score25.setTextColor(black);
            score50.setTextColor(black);
            score75.setTextColor(black);
            score100.setTextColor(black);
            next.setTextColor(white);
            next.setBackgroundColor(black);
        } else if ( MainActivity6.isColor2Selected ) {
            main5.setBackgroundColor(dark_emerald_green);
            section.setTextColor(pure_gold);
            sec1.setTextColor(pure_gold);
            sec2.setTextColor(pure_gold);
            sec3.setTextColor(pure_gold);
            sec4.setTextColor(pure_gold);
            sec5.setTextColor(pure_gold);
            sec6.setTextColor(pure_gold);
            time.setTextColor(pure_gold);
            time45.setTextColor(pure_gold);
            time60.setTextColor(pure_gold);
            time75.setTextColor(pure_gold);
            time90.setTextColor(pure_gold);
            score.setTextColor(pure_gold);
            score25.setTextColor(pure_gold);
            score50.setTextColor(pure_gold);
            score75.setTextColor(pure_gold);
            score100.setTextColor(pure_gold);
            next.setTextColor(dark_emerald_green);
            next.setBackgroundColor(pure_gold);
        } else if ( MainActivity6.isColor3Selected ) {
            main5.setBackgroundColor(yellow);
            section.setTextColor(black);
            sec1.setTextColor(black);
            sec2.setTextColor(black);
            sec3.setTextColor(black);
            sec4.setTextColor(black);
            sec5.setTextColor(black);
            sec6.setTextColor(black);
            time.setTextColor(black);
            time45.setTextColor(black);
            time60.setTextColor(black);
            time75.setTextColor(black);
            time90.setTextColor(black);
            score.setTextColor(black);
            score25.setTextColor(black);
            score50.setTextColor(black);
            score75.setTextColor(black);
            score100.setTextColor(black);
            next.setTextColor(yellow);
            next.setBackgroundColor(black);
        } else if ( MainActivity6.isColor4Selected ) {
            main5.setBackgroundColor(red);
            section.setTextColor(black);
            sec1.setTextColor(black);
            sec2.setTextColor(black);
            sec3.setTextColor(black);
            sec4.setTextColor(black);
            sec5.setTextColor(black);
            sec6.setTextColor(black);
            time.setTextColor(black);
            time45.setTextColor(black);
            time60.setTextColor(black);
            time75.setTextColor(black);
            time90.setTextColor(black);
            score.setTextColor(black);
            score25.setTextColor(black);
            score50.setTextColor(black);
            score75.setTextColor(black);
            score100.setTextColor(black);
            next.setTextColor(red);
            next.setBackgroundColor(black);
        } else if ( MainActivity6.isColor5Selected ) {
            main5.setBackgroundColor(teal);
            section.setTextColor(coral);
            sec1.setTextColor(coral);
            sec2.setTextColor(coral);
            sec3.setTextColor(coral);
            sec4.setTextColor(coral);
            sec5.setTextColor(coral);
            sec6.setTextColor(coral);
            time.setTextColor(coral);
            time45.setTextColor(coral);
            time60.setTextColor(coral);
            time75.setTextColor(coral);
            time90.setTextColor(coral);
            score.setTextColor(coral);
            score25.setTextColor(coral);
            score50.setTextColor(coral);
            score75.setTextColor(coral);
            score100.setTextColor(coral);
            next.setTextColor(teal);
            next.setBackgroundColor(coral);
        } else if ( MainActivity6.isColor6Selected ) {
            main5.setBackgroundColor(blooming_dahlia);
            section.setTextColor(purple);
            sec1.setTextColor(purple);
            sec2.setTextColor(purple);
            sec3.setTextColor(purple);
            sec4.setTextColor(purple);
            sec5.setTextColor(purple);
            sec6.setTextColor(purple);
            time.setTextColor(purple);
            time45.setTextColor(purple);
            time60.setTextColor(purple);
            time75.setTextColor(purple);
            time90.setTextColor(purple);
            score.setTextColor(purple);
            score25.setTextColor(purple);
            score50.setTextColor(purple);
            score75.setTextColor(purple);
            score100.setTextColor(purple);
            next.setTextColor(blooming_dahlia);
            next.setBackgroundColor(purple);
        } else if ( MainActivity6.isColor7Selected ) {
            main5.setBackgroundColor(orange);
            section.setTextColor(black);
            sec1.setTextColor(black);
            sec2.setTextColor(black);
            sec3.setTextColor(black);
            sec4.setTextColor(black);
            sec5.setTextColor(black);
            sec6.setTextColor(black);
            time.setTextColor(black);
            time45.setTextColor(black);
            time60.setTextColor(black);
            time75.setTextColor(black);
            time90.setTextColor(black);
            score.setTextColor(black);
            score25.setTextColor(black);
            score50.setTextColor(black);
            score75.setTextColor(black);
            score100.setTextColor(black);
            next.setTextColor(orange);
            next.setBackgroundColor(black);
        } else if ( MainActivity6.isColor8Selected ) {
            main5.setBackgroundColor(light_blue);
            section.setTextColor(orange);
            sec1.setTextColor(orange);
            sec2.setTextColor(orange);
            sec3.setTextColor(orange);
            sec4.setTextColor(orange);
            sec5.setTextColor(orange);
            sec6.setTextColor(orange);
            time.setTextColor(orange);
            time45.setTextColor(orange);
            time60.setTextColor(orange);
            time75.setTextColor(orange);
            time90.setTextColor(orange);
            score.setTextColor(orange);
            score25.setTextColor(orange);
            score50.setTextColor(orange);
            score75.setTextColor(orange);
            score100.setTextColor(orange);
            next.setTextColor(light_blue);
            next.setBackgroundColor(orange);
        }
        /*Colors*/
    }
}