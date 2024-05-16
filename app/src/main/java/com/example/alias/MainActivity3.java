package com.example.alias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ImageButton back;
    TextView info1, info2, info3, info4, info5, info6, HowToPlay, language;
    RadioButton armenian, russian, english;
    public static boolean isArmenianSelected = false;
    public static boolean isRussianSelected = false;
    public static boolean isEnglishSelected = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        TextView HowToPlay = findViewById(R.id.HowToPlay);
        ImageButton back = findViewById(R.id.back);
        TextView info1 = findViewById(R.id.info1);
        TextView info2 = findViewById(R.id.info2);
        TextView info3 = findViewById(R.id.info3);
        TextView info4 = findViewById(R.id.info4);
        TextView info5 = findViewById(R.id.info5);
        TextView info6 = findViewById(R.id.info6);
        TextView language = findViewById(R.id.language);
        RadioButton armenian = findViewById(R.id.armenian);
        RadioButton russian = findViewById(R.id.russian);
        RadioButton english = findViewById(R.id.english);
        ConstraintLayout main3 = findViewById(R.id.main3);

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

        /*RadioButtons*/
        CompoundButton.OnCheckedChangeListener listener3 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != armenian) {
                        armenian.setChecked(false);
                    }
                    if (buttonView != russian) {
                        russian.setChecked(false);
                    }
                    if (buttonView != english) {
                        english.setChecked(false);
                    }
                }
            }
        };

        armenian.setOnCheckedChangeListener(listener3);
        russian.setOnCheckedChangeListener(listener3);
        english.setOnCheckedChangeListener(listener3);
        english.setChecked(true);
        /*RadioButtons*/

        armenian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HowToPlay.setText("Ինչպես Խաղալ");
                info1.setText("Խաղը նախատեսված է ընկերների հետ խաղալու համար: Խաղացողները բաժանված են 2 թիմի: Խաղացողը պետք է խաղընկերոջը բացատրի էկրանին գրված բառը, յուրաքանչյուր ճիշտ գուշակած բառի համար թիմը կստանա 1 միավոր: Մեկ փուլի ընթացքում թիմը կարող է վաստակել առավելագույնը 30 միավոր։");
                info2.setText("Խաղը սկսելուց առաջ խաղացողը պետք է ընտրի`");
                info3.setText("1)Հաղթական միավորների քանակը");
                info4.setText("2)1 փուլի տևողությունը");
                info5.setText("3)Բաժինը");
                info6.setText("Խաղացողը կարող է նաև ընտրել խաղի գույները:");
                language.setText("Ընտրեք լեզուն");
                armenian.setText("Հայերեն");
                russian.setText("Ռուսերեն");
                english.setText("Անգլերեն");

            }
        });

        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HowToPlay.setText("Как Играть");
                info1.setText("Игра предназначена для игры с друзьями. Игроки делятся на 2 команды. Игрок должен объяснить товарищу по команде слово, написанное на экране, за каждое правильно угаданное слово команда получает 1 очко. За один раунд команда может заработать максимум 30 очков.");
                info2.setText("Перед началом игры игрок должен выбрать:");
                info3.setText("1)Количество выигрышных очков");
                info4.setText("2)Продолжительность 1 раунда");
                info5.setText("3)Раздел");
                info6.setText("Игрок также может выбирать цвета игры.");
                language.setText("Выберите язык");
                armenian.setText("Армянский");
                russian.setText("Русский");
                english.setText("Английский");
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HowToPlay.setText("How To Play");
                info1.setText("The game is designed to be played with friends. The players are divided into 2 teams. The player must explain the word written on the screen to his teammate, for each correctly guessed word, the team will get 1 point. During one round, the team can earn a maximum of 30 points.");
                info2.setText("Before starting the game, the player must choose:");
                info3.setText("1)Number of winning points");
                info4.setText("2)1 round duration");
                info5.setText("3)The section");
                info6.setText("The player can also choose the colors of the game.");
                language.setText("Choose the language");
                armenian.setText("Armenian");
                russian.setText("Russian");
                english.setText("English");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        /*Colors*/
        if ( MainActivity6.isColor1Selected ) {
            main3.setBackgroundColor(white);
            back.setBackgroundColor(white);
            HowToPlay.setTextColor(black);
            info1.setTextColor(black);
            info2.setTextColor(black);
            info3.setTextColor(black);
            info4.setTextColor(black);
            info5.setTextColor(black);
            info6.setTextColor(black);
            language.setTextColor(black);
            armenian.setTextColor(black);
            russian.setTextColor(black);
            english.setTextColor(black);
            back.setImageResource(R.drawable.back_black);
        } else if ( MainActivity6.isColor2Selected ) {
            main3.setBackgroundColor(dark_emerald_green);
            back.setBackgroundColor(dark_emerald_green);
            HowToPlay.setTextColor(pure_gold);
            info1.setTextColor(pure_gold);
            info2.setTextColor(pure_gold);
            info3.setTextColor(pure_gold);
            info4.setTextColor(pure_gold);
            info5.setTextColor(pure_gold);
            info6.setTextColor(pure_gold);
            language.setTextColor(pure_gold);
            armenian.setTextColor(pure_gold);
            russian.setTextColor(pure_gold);
            english.setTextColor(pure_gold);
            back.setImageResource(R.drawable.back_pure_gold);
        } else if ( MainActivity6.isColor3Selected ) {
            main3.setBackgroundColor(yellow);
            back.setBackgroundColor(yellow);
            HowToPlay.setTextColor(black);
            info1.setTextColor(black);
            info2.setTextColor(black);
            info3.setTextColor(black);
            info4.setTextColor(black);
            info5.setTextColor(black);
            info6.setTextColor(black);
            language.setTextColor(black);
            armenian.setTextColor(black);
            russian.setTextColor(black);
            english.setTextColor(black);
            back.setImageResource(R.drawable.back_black);
        } else if ( MainActivity6.isColor4Selected ) {
            main3.setBackgroundColor(red);
            back.setBackgroundColor(red);
            HowToPlay.setTextColor(black);
            info1.setTextColor(black);
            info2.setTextColor(black);
            info3.setTextColor(black);
            info4.setTextColor(black);
            info5.setTextColor(black);
            info6.setTextColor(black);
            language.setTextColor(black);
            armenian.setTextColor(black);
            russian.setTextColor(black);
            english.setTextColor(black);
            back.setImageResource(R.drawable.back_black);
        } else if ( MainActivity6.isColor5Selected ) {
            main3.setBackgroundColor(teal);
            back.setBackgroundColor(teal);
            HowToPlay.setTextColor(coral);
            info1.setTextColor(coral);
            info2.setTextColor(coral);
            info3.setTextColor(coral);
            info4.setTextColor(coral);
            info5.setTextColor(coral);
            info6.setTextColor(coral);
            language.setTextColor(coral);
            armenian.setTextColor(coral);
            russian.setTextColor(coral);
            english.setTextColor(coral);
            back.setImageResource(R.drawable.back_coral);
        } else if ( MainActivity6.isColor6Selected ) {
            main3.setBackgroundColor(blooming_dahlia);
            back.setBackgroundColor(blooming_dahlia);
            HowToPlay.setTextColor(purple);
            info1.setTextColor(purple);
            info2.setTextColor(purple);
            info3.setTextColor(purple);
            info4.setTextColor(purple);
            info5.setTextColor(purple);
            info6.setTextColor(purple);
            language.setTextColor(purple);
            armenian.setTextColor(purple);
            russian.setTextColor(purple);
            english.setTextColor(purple);
            back.setImageResource(R.drawable.back_purple);
        } else if ( MainActivity6.isColor7Selected ) {
            main3.setBackgroundColor(orange);
            back.setBackgroundColor(orange);
            HowToPlay.setTextColor(black);
            info1.setTextColor(black);
            info2.setTextColor(black);
            info3.setTextColor(black);
            info4.setTextColor(black);
            info5.setTextColor(black);
            info6.setTextColor(black);
            language.setTextColor(black);
            armenian.setTextColor(black);
            russian.setTextColor(black);
            english.setTextColor(black);
            back.setImageResource(R.drawable.back_black);
        } else if ( MainActivity6.isColor8Selected ) {
            main3.setBackgroundColor(light_blue);
            back.setBackgroundColor(light_blue);
            HowToPlay.setTextColor(orange);
            info1.setTextColor(orange);
            info2.setTextColor(orange);
            info3.setTextColor(orange);
            info4.setTextColor(orange);
            info5.setTextColor(orange);
            info6.setTextColor(orange);
            language.setTextColor(orange);
            armenian.setTextColor(orange);
            russian.setTextColor(orange);
            english.setTextColor(orange);
            back.setImageResource(R.drawable.back_orange);
        }
        /*Colors*/
    }
}