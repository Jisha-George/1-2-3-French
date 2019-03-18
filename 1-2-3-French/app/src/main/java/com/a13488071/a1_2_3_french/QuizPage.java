package com.a13488071.a1_2_3_french;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class QuizPage extends AppCompatActivity {

    ProgressBar progC, progN, progCM;
    ImageButton cQuiz, nQuiz, cmQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);


        cQuiz = findViewById(R.id.cBut);
        nQuiz = findViewById(R.id.nBut);
        cmQuiz = findViewById(R.id.cmBut);

        progC = findViewById(R.id.cProg);
        progC.setMax(cQuiz3.getMaxscore());
        progC.setProgress(0);

        progN = findViewById(R.id.nProg);
        progN.setMax(nQuiz2.getMaxscore());
        progN.setProgress(0);

        progCM = findViewById(R.id.cmProg);
        //progCM.setMax(ColourM.getQuest());
        progCM.setProgress(0);

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

                        break;

                    case R.id.stats_id:
                        Intent intent2 = new Intent(QuizPage.this, StatsPage.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });

        progC.setProgress(cQuiz3.getScore());

//        if(progC.getProgress() == progC.getMax())
//        {
//            cQuiz.setEnabled(false);
//        }

        progN.setProgress(NumberQuiz.getScore());

//        if(progN.getProgress() == progN.getMax())
//        {
//            nQuiz.setEnabled(false);
//        }

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


//    public void loadCM(View view)
//    {
//        Intent intent2 = new Intent(this, ColourM.class);
//        startActivity(intent2);
//    }
//    public void loadNM(View view)
//    {
//        Intent intent3 = new Intent(this, ColourM.class);
//        startActivity(intent3);
//    }
}
