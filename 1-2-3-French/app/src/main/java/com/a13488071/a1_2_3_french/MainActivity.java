package com.a13488071.a1_2_3_french;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.learn_id:
                        finish();
                        startActivity(getIntent());
                        break;

                    case R.id.quiz_id:
                        Intent intent1 = new Intent(MainActivity.this, QuizPage.class);
                        startActivity(intent1);
                        break;

                    case R.id.stats_id:
                        Intent intent2 = new Intent(MainActivity.this, StatsPage.class);
                        startActivity(intent2);
                        break;
                }

                return true;
            }
        });

    }

    public void loadColour(View view) {
        Intent intent = new Intent(MainActivity.this, ColourLearn.class);
        startActivity(intent);
    }

    public void loadNumber(View view) {
        Intent intent = new Intent(MainActivity.this, NumberLearn.class);
        startActivity(intent);
    }
}
