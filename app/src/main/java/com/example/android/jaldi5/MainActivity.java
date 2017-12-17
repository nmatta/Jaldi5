package com.example.android.jaldi5;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    ArrayList numbList = new ArrayList();

    Button btnGenNumb;
    Button btnExit;
    Button btnNewGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Initialize the function to generate the label and load all the functionality
        jaldi5_Init();

        //Declare the Buttons and onclick events for each of them.
        btnGenNumb = (Button) findViewById(R.id.btnGenNumber);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnNewGame = (Button) findViewById(R.id.btnNewGame);

        //Assign the onClick events to the buttons.
        btnGenNumb.setOnClickListener(this.onClickListener);
        btnExit.setOnClickListener(this.onClickListener);
        btnNewGame.setOnClickListener(this.onClickListener);
    }


    public void jaldi5_Init() {
        TableLayout prices = (TableLayout) findViewById(R.id.main_table);
        prices.setStretchAllColumns(true);
        prices.setPadding(40, 40, 40, 40);
        int k = 1;

        //Generate the Table with No's from 1-100.

        for (int i = 1; i <= 9; i++) {
            TableRow tr = new TableRow(this);

            for (int j = 1; j <= 10; j++) {
                TextView col = new TextView(this);
                col.setId(k);
                col.setText(String.valueOf(k));
                col.setTextSize(15);
                col.setTypeface(Typeface.DEFAULT_BOLD);
                col.setPadding(27, 27, 27, 27);
                tr.addView(col);
                k++;
            }
            prices.addView(tr);
        }
    }

    //Generate Random unique no. with a given range below function generates from 1-100.

    public void randomNumGen() {
        try {
            TextView lblGeneratedNum = (TextView) findViewById(R.id.lblGenNumber);
            Button btnGenNumber = (Button) findViewById(R.id.btnGenNumber);

            Random r = new Random();
            int genNumber = (r.nextInt(90) + 1);

            if (numbList.size() < 90) {

                if (numbList.contains(genNumber)) {
                    randomNumGen();
                } else {
                    //below resID is variable is to fetch dynamic values.
                    String dynID = String.valueOf(genNumber);
                    int resID = getResources().getIdentifier(dynID, "id", getPackageName());
                    TextView highlightNumb = (TextView) findViewById(resID);
                    numbList.add(genNumber);
                    lblGeneratedNum.setText(Integer.toString(genNumber));
                    highlightNumb.setTextColor(Color.WHITE);
                    highlightNumb.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle));
                }
            } else {
                btnGenNumber.setEnabled(false);
                btnGenNumber.setText("Game Over!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dialogNewGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("New Game");
        builder.setMessage("Do you really want to close the existing game and start a New Game!");

        //Yes Button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TableLayout prices = (TableLayout) findViewById(R.id.main_table);
                TextView lblGeneratedNum = (TextView) findViewById(R.id.lblGenNumber);
                Button btnGenNumber = (Button) findViewById(R.id.btnGenNumber);
                prices.removeAllViews();
                numbList.clear();
                btnGenNumber.setEnabled(true);
                btnGenNumber.setText("Generate New Number");
                lblGeneratedNum.setText(Integer.toString(0));
                jaldi5_Init();
            }
        });

        //No Button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void dialogExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Exit");
        builder.setMessage("Do you really wanted to exit the application!");

        //Yes Button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        //No Button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //Generic code for Buttons (Common code)
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnGenNumber:
                    randomNumGen();
                    break;

                case R.id.btnExit:
                    dialogExit();
                    break;

                case R.id.btnNewGame:
                    dialogNewGame();
                    break;
            }

        }

    };


}

