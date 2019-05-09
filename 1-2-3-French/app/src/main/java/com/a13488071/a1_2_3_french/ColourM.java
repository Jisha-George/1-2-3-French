package com.a13488071.a1_2_3_french;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ColourM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_m);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_id);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.learn_id:
                        Intent intent = new Intent(ColourM.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.quiz_id:
                        Intent intent1 = new Intent(ColourM.this, QuizPage.class);
                        startActivity(intent1);
                        break;

                    case R.id.stats_id:
                        Intent intent2 = new Intent(ColourM.this, StatsPage.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });
    }

    public void Previous(View view){
        Intent intent = new Intent (ColourM.this, ColourLearn.class);
        startActivity(intent);
    }
}
