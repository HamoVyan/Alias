package com.example.alias;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private TextView word1, word2, word3, word4, word5, word6, word7, word8, word9, word10;
    private TextView timer, team1, team2, points_value, points;
    LinearLayout linearlayout;
    private CountDownTimer countDownTimer;
    int initialTimeSeconds = 5;
    private SharedPreferences sharedPreferences;
    private int count;
    private int clickcount = 0;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<String> words_cwa = new ArrayList<>();
    ArrayList<String> words_cwr = new ArrayList<>();
    ArrayList<String> words_cwe = new ArrayList<>();
    Map<String, Object> data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        TextView word1 = findViewById(R.id.word1);
        TextView word2 = findViewById(R.id.word2);
        TextView word3 = findViewById(R.id.word3);
        TextView word4 = findViewById(R.id.word4);
        TextView word5 = findViewById(R.id.word5);
        TextView word6 = findViewById(R.id.word6);
        TextView word7 = findViewById(R.id.word7);
        TextView word8 = findViewById(R.id.word8);
        TextView word9 = findViewById(R.id.word9);
        TextView word10 = findViewById(R.id.word10);
        TextView team1 = findViewById(R.id.team1);
        TextView team2 = findViewById(R.id.team2);
        TextView points_value = findViewById(R.id.points_value);
        timer = findViewById(R.id.timer);
        TextView points = findViewById(R.id.points);
        LinearLayout linearlayout = findViewById(R.id.linearlayout);
        ConstraintLayout main2 = findViewById(R.id.main2);

        /*Common Words*/
        if ( MainActivity5.is_common_words_selected ) {
            if ( MainActivity6.Armenian ) {
                db.collection("Common Words-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        words_cwa.add((String) data.get("cwa"));
                                    }
                                    word1.setText(getRandomArray(words_cwa));
                                    word2.setText(getRandomArray(words_cwa));
                                    word3.setText(getRandomArray(words_cwa));
                                    word4.setText(getRandomArray(words_cwa));
                                    word5.setText(getRandomArray(words_cwa));
                                    word6.setText(getRandomArray(words_cwa));
                                    word7.setText(getRandomArray(words_cwa));
                                    word8.setText(getRandomArray(words_cwa));
                                    word9.setText(getRandomArray(words_cwa));
                                    word10.setText(getRandomArray(words_cwa));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity6.Russian ) {
                db.collection("Common Words-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        words_cwr.add((String) data.get("cwr"));
                                    }
                                    word1.setText(getRandomArray(words_cwr));
                                    word2.setText(getRandomArray(words_cwr));
                                    word3.setText(getRandomArray(words_cwr));
                                    word4.setText(getRandomArray(words_cwr));
                                    word5.setText(getRandomArray(words_cwr));
                                    word6.setText(getRandomArray(words_cwr));
                                    word7.setText(getRandomArray(words_cwr));
                                    word8.setText(getRandomArray(words_cwr));
                                    word9.setText(getRandomArray(words_cwr));
                                    word10.setText(getRandomArray(words_cwr));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity6.English ) {
                db.collection("Common Words-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        words_cwe.add((String) data.get("cwe"));
                                    }
                                    word1.setText(getRandomArray(words_cwe));
                                    word2.setText(getRandomArray(words_cwe));
                                    word3.setText(getRandomArray(words_cwe));
                                    word4.setText(getRandomArray(words_cwe));
                                    word5.setText(getRandomArray(words_cwe));
                                    word6.setText(getRandomArray(words_cwe));
                                    word7.setText(getRandomArray(words_cwe));
                                    word8.setText(getRandomArray(words_cwe));
                                    word9.setText(getRandomArray(words_cwe));
                                    word10.setText(getRandomArray(words_cwe));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }
        /*Common Words*/

        /*Colors*/
        int black = ContextCompat.getColor(this, R.color.black);
        int white = ContextCompat.getColor(this, R.color.white);
        int gray = ContextCompat.getColor(this, R.color.gray);
        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);
        int dark_emerald_green_dark = ContextCompat.getColor(this, R.color.dark_emerald_green_dark);
        int yellow = ContextCompat.getColor(this, R.color.yellow);
        int yellow_dark = ContextCompat.getColor(this, R.color.yellow_dark);
        int red = ContextCompat.getColor(this, R.color.red);
        int red_dark = ContextCompat.getColor(this, R.color.red_dark);
        int coral = ContextCompat.getColor(this, R.color.coral);
        int teal = ContextCompat.getColor(this, R.color.teal);
        int teal_dark = ContextCompat.getColor(this, R.color.teal_dark);
        int purple = ContextCompat.getColor(this, R.color.purple);
        int blooming_dahlia = ContextCompat.getColor(this, R.color.blooming_dahlia);
        int blooming_dahlia_dark = ContextCompat.getColor(this, R.color.blooming_dahlia_dark);
        int orange = ContextCompat.getColor(this, R.color.orange);
        int orange_dark = ContextCompat.getColor(this, R.color.orange_dark);
        int light_blue = ContextCompat.getColor(this, R.color.light_blue);
        int light_blue_dark = ContextCompat.getColor(this, R.color.light_blue_dark);
        /*Colors*/

        /*Words*/
        word1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color1 == white ) {
                        word1.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word1.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word1.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word1.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word1.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word1.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color4 == red ) {
                        word1.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word1.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word1.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word1.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word1.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word1.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word1.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word1.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word1.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word1.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color1 == white ) {
                        word2.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word2.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word2.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word2.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word2.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word2.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color4 == red ) {
                        word2.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word2.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word2.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word2.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word2.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word2.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word2.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word2.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word2.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word2.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word2.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color1 == white ) {
                        word3.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word3.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word3.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word3.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word3.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word3.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color4 == red ) {
                        word3.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word3.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word3.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word3.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word3.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word3.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word3.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word3.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word3.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word3.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color1 == white ) {
                        word4.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word4.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word4.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word4.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word4.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word4.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color4 == red ) {
                        word4.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word4.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word4.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word4.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word4.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word4.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word4.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word4.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word4.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word4.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color1 == white ) {
                        word5.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word5.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word5.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word5.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word5.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word5.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color4 == red ) {
                        word5.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word5.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word5.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word5.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word5.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word5.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word5.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word5.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word5.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word5.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color1 == white ) {
                        word6.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word6.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word6.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word6.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word6.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word6.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color4 == red ) {
                        word6.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word6.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word6.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word6.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word6.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word6.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word6.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word6.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word6.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word6.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color1 == white ) {
                        word7.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word7.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word7.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word7.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word7.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word7.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color4 == red ) {
                        word7.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word7.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word7.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word7.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word7.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word7.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word7.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word7.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word7.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word7.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color1 == white ) {
                        word8.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word8.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word8.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word8.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word8.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word8.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color4 == red ) {
                        word8.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word8.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word8.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word8.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word8.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word8.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word8.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word8.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word8.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word8.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color1 == white ) {
                        word9.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word9.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word9.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word9.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word9.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word9.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color4 == red ) {
                        word9.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word9.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word9.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word9.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word9.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word9.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word9.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word9.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word9.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word9.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        word10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color1 == white ) {
                        word10.setBackgroundColor(gray);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor1();
                    } else if (color1 == gray) {
                        word10.setBackgroundColor(white);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(gray);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor1();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color2 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color2 == dark_emerald_green ) {
                        word10.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor2();
                    } else if (color2 == dark_emerald_green_dark) {
                        word10.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor2();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color3 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color3 == yellow ) {
                        word10.setBackgroundColor(yellow_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor3();
                    } else if (color3 == yellow_dark) {
                        word10.setBackgroundColor(yellow);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(yellow_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor3();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color4 == red ) {
                        word10.setBackgroundColor(red_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor4();
                    } else if (color4 == red_dark) {
                        word10.setBackgroundColor(red);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(red_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor4();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color4 == teal ) {
                        word10.setBackgroundColor(teal_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor5();
                    } else if (color4 == teal_dark) {
                        word10.setBackgroundColor(teal);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor5();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color4 == blooming_dahlia ) {
                        word10.setBackgroundColor(blooming_dahlia_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor6();
                    } else if (color4 == blooming_dahlia_dark) {
                        word10.setBackgroundColor(blooming_dahlia);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(teal_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor6();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color4 == orange ) {
                        word10.setBackgroundColor(orange_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor7();
                    } else if (color4 == orange_dark) {
                        word10.setBackgroundColor(orange);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(orange_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor7();
                }
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color4 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color4 == light_blue ) {
                        word10.setBackgroundColor(light_blue_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        pageChangingColor8();
                    } else if (color4 == light_blue_dark) {
                        word10.setBackgroundColor(light_blue);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(light_blue_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    pageChangingColor8();
                }
            }

            private void resetWordsColor1() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(white);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(white);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(white);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(white);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(white);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(white);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(white);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(white);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(white);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(white);
            }

            private void resetWordsColor2() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void resetWordsColor3() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(yellow);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(yellow);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(yellow);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(yellow);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(yellow);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(yellow);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(yellow);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(yellow);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(yellow);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(yellow);
            }

            private void resetWordsColor4() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(red);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(red);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(red);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(red);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(red);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(red);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(red);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(red);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(red);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(red);
            }

            private void resetWordsColor5() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(teal);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(teal);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(teal);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(teal);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(teal);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(teal);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(teal);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(teal);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(teal);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(teal);
            }

            private void resetWordsColor6() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(blooming_dahlia);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(blooming_dahlia);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(blooming_dahlia);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(blooming_dahlia);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(blooming_dahlia);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(blooming_dahlia);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(blooming_dahlia);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(blooming_dahlia);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(blooming_dahlia);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(blooming_dahlia);
            }

            private void resetWordsColor7() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(orange);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(orange);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(orange);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(orange);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(orange);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(orange);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(orange);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(orange);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(orange);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(orange);
            }

            private void resetWordsColor8() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(light_blue);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(light_blue);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(light_blue);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(light_blue);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(light_blue);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(light_blue);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(light_blue);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(light_blue);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(light_blue);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(light_blue);
            }

            private void pageChangingColor1() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor1();
                }
            }

            private void pageChangingColor2() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor2();
                }
            }

            private void pageChangingColor3() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor3();
                }
            }

            private void pageChangingColor4() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor4();
                }
            }

            private void pageChangingColor5() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor5();
                }
            }

            private void pageChangingColor6() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor6();
                }
            }

            private void pageChangingColor7() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor7();
                }
            }

            private void pageChangingColor8() {
                if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40 || clickcount == 50) {
                    resetWordsColor8();
                }
            }
        });
        /*Words*/

        String team_1 = getIntent().getStringExtra("keyteam1");
        String team_2 = getIntent().getStringExtra("keyteam2");

        /*Timer*/
        if ( MainActivity5.isTime45Selected ) {
            initialTimeSeconds = 5;
        } else if (  MainActivity5.isTime60Selected ) {
            initialTimeSeconds = 61;
        } else if ( MainActivity5.isTime75Selected ) {
            initialTimeSeconds = 76;
        } else if ( MainActivity5.isTime90Selected ) {
            initialTimeSeconds = 91;
        }
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);
        countDownTimer = new CountDownTimer(initialTimeSeconds * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) (millisUntilFinished / 1000));
            }
            @Override
            public void onFinish() {
                String point = points_value.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("team1_point", point);
                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();
        /*Timer*/

        /*Language*/
        if ( MainActivity6.Armenian ) {
            if (MainActivity4.team()) {
                team1.setText(team_1);
                team2.setText("");
            } else {
                team1.setText("");
                team2.setText(team_2);
            }
            MainActivity4.toggleText();
            points.setText("միավորներ:");
            points.setTranslationX(-35);
            points_value.setTranslationX(35);
        } else if ( MainActivity6.English ) {
            if (MainActivity4.team()) {
                team1.setText(team_1);
                team2.setText("");
            } else {
                team1.setText("");
                team2.setText(team_2);
            }
            MainActivity4.toggleText();
            points.setText("points:");
        } else if ( MainActivity6.Russian ) {
            if (MainActivity4.team()) {
                team1.setText(team_1);
                team2.setText("");
            } else {
                team1.setText("");
                team2.setText(team_2);
            }
            MainActivity4.toggleText();
            points.setText("очки:");
            points.setTranslationX(10);
            points_value.setTranslationX(-10);
        }
        /*Language*/

        /*Colors*/
        if ( MainActivity6.isColor1Selected ) {
            main2.setBackgroundColor(white);
            timer.setTextColor(black);
            team1.setTextColor(black);
            team2.setTextColor(black);
            linearlayout.setBackgroundColor(black);
            word1.setBackgroundColor(white);
            word1.setTextColor(black);
            word2.setBackgroundColor(white);
            word2.setTextColor(black);
            word3.setBackgroundColor(white);
            word3.setTextColor(black);
            word4.setBackgroundColor(white);
            word4.setTextColor(black);
            word5.setBackgroundColor(white);
            word5.setTextColor(black);
            word6.setBackgroundColor(white);
            word6.setTextColor(black);
            word7.setBackgroundColor(white);
            word7.setTextColor(black);
            word8.setBackgroundColor(white);
            word8.setTextColor(black);
            word9.setBackgroundColor(white);
            word9.setTextColor(black);
            word10.setBackgroundColor(white);
            word10.setTextColor(black);
            points.setTextColor(black);
            points_value.setTextColor(black);
        } else if ( MainActivity6.isColor2Selected ) {
            main2.setBackgroundColor(dark_emerald_green);
            timer.setTextColor(pure_gold);
            team1.setTextColor(pure_gold);
            team2.setTextColor(pure_gold);
            linearlayout.setBackgroundColor(pure_gold);
            word1.setBackgroundColor(dark_emerald_green);
            word1.setTextColor(pure_gold);
            word2.setBackgroundColor(dark_emerald_green);
            word2.setTextColor(pure_gold);
            word3.setBackgroundColor(dark_emerald_green);
            word3.setTextColor(pure_gold);
            word4.setBackgroundColor(dark_emerald_green);
            word4.setTextColor(pure_gold);
            word5.setBackgroundColor(dark_emerald_green);
            word5.setTextColor(pure_gold);
            word6.setBackgroundColor(dark_emerald_green);
            word6.setTextColor(pure_gold);
            word7.setBackgroundColor(dark_emerald_green);
            word7.setTextColor(pure_gold);
            word8.setBackgroundColor(dark_emerald_green);
            word8.setTextColor(pure_gold);
            word9.setBackgroundColor(dark_emerald_green);
            word9.setTextColor(pure_gold);
            word10.setBackgroundColor(dark_emerald_green);
            word10.setTextColor(pure_gold);
            points.setTextColor(pure_gold);
            points_value.setTextColor(pure_gold);
        } else if ( MainActivity6.isColor3Selected ) {
            main2.setBackgroundColor(yellow);
            timer.setTextColor(black);
            team1.setTextColor(black);
            team2.setTextColor(black);
            linearlayout.setBackgroundColor(black);
            word1.setBackgroundColor(yellow);
            word1.setTextColor(black);
            word2.setBackgroundColor(yellow);
            word2.setTextColor(black);
            word3.setBackgroundColor(yellow);
            word3.setTextColor(black);
            word4.setBackgroundColor(yellow);
            word4.setTextColor(black);
            word5.setBackgroundColor(yellow);
            word5.setTextColor(black);
            word6.setBackgroundColor(yellow);
            word6.setTextColor(black);
            word7.setBackgroundColor(yellow);
            word7.setTextColor(black);
            word8.setBackgroundColor(yellow);
            word8.setTextColor(black);
            word9.setBackgroundColor(yellow);
            word9.setTextColor(black);
            word10.setBackgroundColor(yellow);
            word10.setTextColor(black);
            points.setTextColor(black);
            points_value.setTextColor(black);
        } else if ( MainActivity6.isColor4Selected ) {
            main2.setBackgroundColor(red);
            timer.setTextColor(black);
            team1.setTextColor(black);
            team2.setTextColor(black);
            linearlayout.setBackgroundColor(black);
            word1.setBackgroundColor(red);
            word1.setTextColor(black);
            word2.setBackgroundColor(red);
            word2.setTextColor(black);
            word3.setBackgroundColor(red);
            word3.setTextColor(black);
            word4.setBackgroundColor(red);
            word4.setTextColor(black);
            word5.setBackgroundColor(red);
            word5.setTextColor(black);
            word6.setBackgroundColor(red);
            word6.setTextColor(black);
            word7.setBackgroundColor(red);
            word7.setTextColor(black);
            word8.setBackgroundColor(red);
            word8.setTextColor(black);
            word9.setBackgroundColor(red);
            word9.setTextColor(black);
            word10.setBackgroundColor(red);
            word10.setTextColor(black);
            points.setTextColor(black);
            points_value.setTextColor(black);
        } else if ( MainActivity6.isColor5Selected ) {
            main2.setBackgroundColor(teal);
            timer.setTextColor(coral);
            team1.setTextColor(coral);
            team2.setTextColor(coral);
            linearlayout.setBackgroundColor(coral);
            word1.setBackgroundColor(teal);
            word1.setTextColor(coral);
            word2.setBackgroundColor(teal);
            word2.setTextColor(coral);
            word3.setBackgroundColor(teal);
            word3.setTextColor(coral);
            word4.setBackgroundColor(teal);
            word4.setTextColor(coral);
            word5.setBackgroundColor(teal);
            word5.setTextColor(coral);
            word6.setBackgroundColor(teal);
            word6.setTextColor(coral);
            word7.setBackgroundColor(teal);
            word7.setTextColor(coral);
            word8.setBackgroundColor(teal);
            word8.setTextColor(coral);
            word9.setBackgroundColor(teal);
            word9.setTextColor(coral);
            word10.setBackgroundColor(teal);
            word10.setTextColor(coral);
            points.setTextColor(coral);
            points_value.setTextColor(coral);
        } else if ( MainActivity6.isColor6Selected ) {
            main2.setBackgroundColor(blooming_dahlia);
            timer.setTextColor(purple);
            team1.setTextColor(purple);
            team2.setTextColor(purple);
            linearlayout.setBackgroundColor(purple);
            word1.setBackgroundColor(blooming_dahlia);
            word1.setTextColor(purple);
            word2.setBackgroundColor(blooming_dahlia);
            word2.setTextColor(purple);
            word3.setBackgroundColor(blooming_dahlia);
            word3.setTextColor(purple);
            word4.setBackgroundColor(blooming_dahlia);
            word4.setTextColor(purple);
            word5.setBackgroundColor(blooming_dahlia);
            word5.setTextColor(purple);
            word6.setBackgroundColor(blooming_dahlia);
            word6.setTextColor(purple);
            word7.setBackgroundColor(blooming_dahlia);
            word7.setTextColor(purple);
            word8.setBackgroundColor(blooming_dahlia);
            word8.setTextColor(purple);
            word9.setBackgroundColor(blooming_dahlia);
            word9.setTextColor(purple);
            word10.setBackgroundColor(blooming_dahlia);
            word10.setTextColor(purple);
            points.setTextColor(purple);
            points_value.setTextColor(purple);
        } else if ( MainActivity6.isColor7Selected ) {
            main2.setBackgroundColor(orange);
            timer.setTextColor(black);
            team1.setTextColor(black);
            team2.setTextColor(black);
            linearlayout.setBackgroundColor(black);
            word1.setBackgroundColor(orange);
            word1.setTextColor(black);
            word2.setBackgroundColor(orange);
            word2.setTextColor(black);
            word3.setBackgroundColor(orange);
            word3.setTextColor(black);
            word4.setBackgroundColor(orange);
            word4.setTextColor(black);
            word5.setBackgroundColor(orange);
            word5.setTextColor(black);
            word6.setBackgroundColor(orange);
            word6.setTextColor(black);
            word7.setBackgroundColor(orange);
            word7.setTextColor(black);
            word8.setBackgroundColor(orange);
            word8.setTextColor(black);
            word9.setBackgroundColor(orange);
            word9.setTextColor(black);
            word10.setBackgroundColor(orange);
            word10.setTextColor(black);
            points.setTextColor(black);
            points_value.setTextColor(black);
        } else if ( MainActivity6.isColor8Selected ) {
            main2.setBackgroundColor(light_blue);
            timer.setTextColor(orange);
            team1.setTextColor(orange);
            team2.setTextColor(orange);
            linearlayout.setBackgroundColor(orange);
            word1.setBackgroundColor(light_blue);
            word1.setTextColor(orange);
            word2.setBackgroundColor(light_blue);
            word2.setTextColor(orange);
            word3.setBackgroundColor(light_blue);
            word3.setTextColor(orange);
            word4.setBackgroundColor(light_blue);
            word4.setTextColor(orange);
            word5.setBackgroundColor(light_blue);
            word5.setTextColor(orange);
            word6.setBackgroundColor(light_blue);
            word6.setTextColor(orange);
            word7.setBackgroundColor(light_blue);
            word7.setTextColor(orange);
            word8.setBackgroundColor(light_blue);
            word8.setTextColor(orange);
            word9.setBackgroundColor(light_blue);
            word9.setTextColor(orange);
            word10.setBackgroundColor(light_blue);
            word10.setTextColor(orange);
            points.setTextColor(orange);
            points_value.setTextColor(orange);
        }
        /*Colors*/
    }

    /*Timer function*/
    private void updateTimer(int seconds) {
        timer.setText(String.valueOf(seconds));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    /*Timer function*/

    /*Random word's get function*/
    private String getRandomArray(ArrayList<String> arrayList) {
        int size = arrayList.size();
        Random random = new Random();
        Log.d("error", arrayList.get(random.nextInt(size)));
        return arrayList.get(random.nextInt(size));
    }
    /*Random word's get function*/

    /*Random word set*/
    private void RandomWordSet() {
        word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(Color.WHITE);
        word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(Color.WHITE);
        word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(Color.WHITE);
        word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(Color.WHITE);
        word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(Color.WHITE);
        word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(Color.WHITE);
        word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(Color.WHITE);
        word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(Color.WHITE);
        word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(Color.WHITE);
        word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(Color.WHITE);
    }
    /*Random word set*/
}

