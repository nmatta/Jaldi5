package com.example.android.jaldi5;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    ArrayList numbList = new ArrayList();
    Button btnGenNumb;
    Button btnExit;
    Button btnGameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the function to generate the label and load all the functionality
        jaldi5_Init();

        //Declare the Buttons and onclick events for each of them.
        btnGenNumb = (Button) findViewById(R.id.btnGenNumber);
        btnExit = (Button) findViewById(R.id.btnExit);

        //Assign the onClick events to the buttons.
        btnGenNumb.setOnClickListener(this.onClickListener);
        btnExit.setOnClickListener(this.onClickListener);
  }


    public void jaldi5_Init() {

        TableLayout prices = (TableLayout) findViewById(R.id.main_table);
        prices.setStretchAllColumns(true);
        prices.setPadding(40, 40, 40, 40);
        int k = 1;

        for (int i = 1; i <= 10; i++) {
            TableRow tr = new TableRow(this);

            for (int j = 1; j <= 10; j++) {
                TextView c1 = new TextView(this);
                c1.setId(k);
                c1.setText(String.valueOf(k));
                c1.setTextSize(15);
                c1.setTypeface(Typeface.DEFAULT_BOLD);
                c1.setPadding(30, 30, 30, 30);
                tr.addView(c1);

                k++;
            }
            prices.addView(tr);
        }
    }


    public void randomNumGen() {
        try {
            TextView lblGeneratedNum = (TextView) findViewById(R.id.lblGenNumber);
            Button btnGenNumber = (Button) findViewById(R.id.btnGenNumber);

            Random r = new Random();
            int genNumber = (r.nextInt(100) + 1);

            if (numbList.size() < 100) {

                if (numbList.contains(genNumber)) {
                    randomNumGen();
                } else {
                    String dynID = String.valueOf(genNumber);
                    int resID = getResources().getIdentifier(dynID, "id", getPackageName());
                    TextView highlightNumb = (TextView) findViewById(resID);
                    numbList.add(genNumber);
                    lblGeneratedNum.setText(Integer.toString(genNumber));
                    highlightNumb.setTextColor(Color.WHITE);
                    highlightNumb.setTextSize(15);
                   //highlightNumb.setTypeface(Typeface.DEFAULT_BOLD);
                    highlightNumb.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle));
                }
            } else {
                btnGenNumber.setEnabled(false);
                btnGenNumber.setText("Game Over!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Memory exceptions", "exceptions" + e);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnGenNumber:
                    randomNumGen();
                    break;
                case R.id.btnExit:
                    Log.i("Btn Exit", "Exit Game Function Called");

                    break;

            }
        }
    };


}

