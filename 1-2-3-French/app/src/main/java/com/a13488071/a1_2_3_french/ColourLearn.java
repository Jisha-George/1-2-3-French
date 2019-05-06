package com.a13488071.a1_2_3_french;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class ColourLearn extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_learn);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.learn_id:
                        Intent intent = new Intent(ColourLearn.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.quiz_id:
                        Intent intent1 = new Intent(ColourLearn.this, QuizPage.class);
                        startActivity(intent1);
                        break;

                    case R.id.stats_id:
                        Intent intent2 = new Intent(ColourLearn.this, StatsPage.class);
                        startActivity(intent2);
                        break;
                }

                return true;
            }
        });

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

    }
}
