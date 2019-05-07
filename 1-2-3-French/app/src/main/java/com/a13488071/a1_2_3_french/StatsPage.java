package com.a13488071.a1_2_3_french;
//https://www.youtube.com/watch?v=a20EchSQgpw
//https://www.youtube.com/watch?v=_cV7cgQFDo0

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatsPage extends AppCompatActivity {
    LineChart chart;
    int number;
    int colour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page);

        chart = findViewById(R.id.chart);

        SharedPreferences preferenceC = getSharedPreferences("PREFC", 0);
        colour = preferenceC.getInt("colourScore", 0);
        SharedPreferences preferenceN = getSharedPreferences("PREFN", 0);
        number = preferenceN.getInt("numberScore", 0);

        int statsC[] = {colour};
        int statsN[] = {number};

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.learn_id:
                        Intent intent = new Intent(StatsPage.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.quiz_id:
                        Intent intent1 = new Intent(StatsPage.this, QuizPage.class);
                        startActivity(intent1);
                        break;

                    case R.id.stats_id:
                        finish();
                        startActivity(getIntent());
                        break;
                }

                return false;
            }
        });

        ArrayList<String> xAxes = new ArrayList<>();
        ArrayList<Entry> yNum = new ArrayList<>();
        ArrayList<Entry> yCol = new ArrayList<>();

        for (int i = 0; i <= statsC.length; i++)
        {
           yCol.add(new Entry(i, colour));
            Log.d("COLOUR", "" + colour);
        }

        for (int i = 0; i <= statsN.length; i++)
        {
            yNum.add(new Entry(i, number));
            Log.d("NUMBER", "" + number);
        }
        LineDataSet colourSet, numberSet;

        colourSet = new LineDataSet(yCol, "Colour Progress");
        colourSet.setColor(Color.RED);
        numberSet = new LineDataSet(yNum, "Number Progress");
        numberSet.setColor(Color.BLUE);

        LineData data = new LineData(colourSet,numberSet);

        chart.setData(data);

    }
}
