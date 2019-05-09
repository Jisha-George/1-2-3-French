package com.a13488071.a1_2_3_french;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class QuizPage extends AppCompatActivity {

    public static ProgressBar progC, progN;
    ImageButton cQuiz, nQuiz;
    public static int colour, number =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        cQuiz = findViewById(R.id.cBut);
        nQuiz = findViewById(R.id.nBut);

        progC = findViewById(R.id.cProg);
        progC.setMax(cQuiz3.getMaxscore());
        progC.setProgress(0);

        progN = findViewById(R.id.nProg);
        progN.setMax(nQuiz2.getMaxscore());
        progN.setProgress(0);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.learn_id:
                        Intent intent = new Intent(QuizPage.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.quiz_id:
                        finish();
                        startActivity(getIntent());
                        break;

                    case R.id.stats_id:
                        Intent intent2 = new Intent(QuizPage.this, StatsPage.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });

        if (cQuiz3.getScore() > 0) {
            progC.setProgress(cQuiz3.getScore());
        }
        else
        {
            progC.setProgress(cQuiz2.getScore());
        }

        progN.setProgress(nQuiz2.getScore());
        Log.d("HERE", "--" + progC.getProgress());

        colour = progC.getProgress();
        number = progN.getProgress();

        SharedPreferences preferenceC = getSharedPreferences("PREFC", 0);
        SharedPreferences.Editor editorC = preferenceC.edit();
        editorC.putInt("colourScore", colour);
        editorC.apply();

        SharedPreferences preferenceN = getSharedPreferences("PREFN", 0);
        SharedPreferences.Editor editorN = preferenceN.edit();
        editorN.putInt("numberScore", number);
        editorN.apply();
    }

    public void loadCQuiz(View view)
    {
        Intent intent = new Intent(this, ColourQuiz.class);
        startActivity(intent);
    }
    public void loadNQuiz(View view)
    {
        Intent intent1 = new Intent(this, NumberQuiz.class);
        startActivity(intent1);
    }

    public static int getColour() {
        return colour;
    }
    public static int getNumber() {
        return number;
    }
}
