package com.a13488071.a1_2_3_french;

//https://www.youtube.com/watch?v=3gSIJTHiAvI&list=PLaoF-xhnnrRU7DSfUMP8PGWJf-1UYBQZv&index=1
//https://stackoverflow.com/questions/40938426/progress-bar-on-correct-answers

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class ColourQuiz extends AppCompatActivity {

    private int pressCounter = 0;
    //private int maxPressCounter = 3;
    private String[] keys = {"E", "L", "R", "B", "D", "U"};
    String answer = "RED";
    TextView textQuestion;
    public static int score = 0;
    public static int maxscore = 5;
    Button check, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_quiz);

        check = findViewById(R.id.check);
        reset = findViewById(R.id.reset);
        keys = shuffleArray(keys);

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.givenText)), key, ((EditText) findViewById(R.id.guess)));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_id);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.learn_id:
                        Intent intent = new Intent(ColourQuiz.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.quiz_id:
                        Intent intent1 = new Intent(ColourQuiz.this, QuizPage.class);
                        startActivity(intent1);
                        break;

                    case R.id.stats_id:
                        Intent intent2 = new Intent(ColourQuiz.this, StatsPage.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });
    }

    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    private void addView(final LinearLayout viewParent, final String text, final EditText editText) {
        final LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayoutParams.rightMargin = 5;

        final TextView letters = new TextView(this);
        letters.setLayoutParams(linearLayoutParams);
        letters.setBackground(this.getResources().getDrawable(R.drawable.quest_bck));
        letters.setTextColor(this.getResources().getColor(R.color.colorAccent));
        letters.setGravity(Gravity.CENTER);
        letters.setText(text);
        letters.setClickable(true);
        letters.setFocusable(true);
        letters.setTextSize(32);
        viewParent.addView(letters);
        textQuestion = findViewById(R.id.textQuestion);

        letters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressCounter <= 7) {
                    editText.setText(editText.getText().toString().concat(letters.getText().toString()));
                    letters.setVisibility(View.INVISIBLE);

                    pressCounter++;

                    if (pressCounter == 0) {
                        editText.setText("");
                    }

                    Log.d("", "" + letters.getText().toString());
                }
            }
        });
        // final TextView lnew = new TextView(this);

//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pressCounter--;
//
//                String end = editText.getText().toString();
//                String a = end.substring(end.length()-1, end.length());
//                String ct = text.replace(text,a);
//                letters.setText(ct);
//
//                editText.setText(end.substring(0, end.length() - 1));
//
//                if(letters.getText().toString().equals(a))
//                {
//                    Log.d(TAG, "let " + letters.getText().toString() + "-" + ct);
//                   letters.setEnabled(true);
//                   viewParent.addView(lnew);
//                   lnew.setText(ct);
//                }
//                else if(lnew.getText().toString().equals(a))  {
//                    Log.d(TAG, "ln " + lnew.getText().toString() + "-" + ct);
//                    viewParent.addView(lnew);
//
//                }
//
//                if(pressCounter == 0) {
//                    editText.setText("");
//                    editText.setEnabled(false);
//                }
//                //viewParent.addView(letters);
//                Log.d(TAG, "edit " + editText.getText().toString());
//                Log.d(TAG, "text " + letters.getText().toString());
//                Log.d(TAG, "text1 " + lnew.getText().toString());
//                Log.d(TAG, "char " + a);
//                Log.d(TAG, "ct " + ct);
//
//            }
//        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doValidate();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove();
            }
        });
    }

    private void remove() {
        EditText editText = findViewById(R.id.guess);
        LinearLayout linearLayout = findViewById(R.id.givenText);

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        editText.setText("");
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }
    }

    private void doValidate() {
        pressCounter = 0;
        EditText editText = findViewById(R.id.guess);
        LinearLayout linearLayout = findViewById(R.id.givenText);

        if (editText.getText().toString().equals(answer)) {
            Toast.makeText(ColourQuiz.this, "Correct", Toast.LENGTH_SHORT).show();
            editText.setText("");
            score++;
        } else {
            Toast.makeText(ColourQuiz.this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }
    }

    public static int getScore() {
        return score;
    }

    public static int getMaxscore() {
        return maxscore;
    }
}
