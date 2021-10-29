package com.example.memorygamehw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView tv_p1, tv_p2;
    ImageView iv_11, iv_12,iv_13,iv_21,iv_22,iv_23;

    Integer[] cardsArray = {101, 102,103,201,202,203};

    int image101, image102, image103, image201, image202, image203;
    int FirstCard, SecondCard;
    int ClickedFirst, ClickedSecond;
    int CardNumber =1;
    int turn = 1;
    int PlayerPoints = 0, cpuPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_p1= (TextView) findViewById(R.id.tv_p1);
        tv_p2= (TextView) findViewById(R.id.tv_p2);

        iv_11= (ImageView) findViewById(R.id.iv_11);
        iv_12= (ImageView) findViewById(R.id.iv_12);
        iv_13= (ImageView) findViewById(R.id.iv_13);
        iv_21= (ImageView) findViewById(R.id.iv_21);
        iv_22= (ImageView) findViewById(R.id.iv_22);
        iv_23= (ImageView) findViewById(R.id.iv_23);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_21.setTag("3");
        iv_22.setTag("4");
        iv_23.setTag("5");

        fontOfCardsResources();
        Collections.shuffle(Arrays.asList(cardsArray));
        tv_p2.setTextColor(Color.GRAY);

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11,theCard);
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12,theCard);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_13,theCard);

            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21,theCard);

            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22,theCard);

            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_23,theCard);

            }
        });
    }

    private void doStuff(ImageView iv, int Card){

        if(cardsArray[Card] == 101){
            iv.animate().translationYBy(2000).setDuration(500);
            iv.setImageResource(image101);

        }else if(cardsArray[Card] == 102){
            iv.animate().translationYBy(2000).setDuration(500);
            iv.setImageResource(image102);
        }else if(cardsArray[Card] == 103){
            iv.animate().translationYBy(2000).setDuration(500);
            iv.setImageResource(image103);
        }else if(cardsArray[Card] == 104){
            iv.animate().translationYBy(2000).setDuration(500);
            iv.setImageResource(image201);
        }else if(cardsArray[Card] == 105){
            iv.animate().translationYBy(2000).setDuration(500);
            iv.setImageResource(image202);
        }else if(cardsArray[Card] == 106){
            iv.animate().translationYBy(2000).setDuration(500);
            iv.setImageResource(image203);
        }

        if(CardNumber == 1)
        {
            FirstCard = cardsArray[Card];
            if(FirstCard>200){
                FirstCard = FirstCard -100;

            }
            CardNumber =2;
            ClickedFirst = Card;
            iv.setEnabled(false);

        }else if (CardNumber == 2){
            SecondCard = cardsArray[Card];
            if(SecondCard>200){
                SecondCard = SecondCard -100;

            }
            CardNumber =2;
            ClickedSecond= Card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 500);
        }
    }

    private void calculate(){
        if(FirstCard == SecondCard){
            if(ClickedFirst == 0){
                iv_11.setVisibility(View.INVISIBLE);
            } else if(ClickedFirst == 1){
                iv_12.setVisibility(View.INVISIBLE);
            }else if(ClickedFirst == 2){
                iv_13.setVisibility(View.INVISIBLE);
            }else if(ClickedFirst == 3){
                iv_21.setVisibility(View.INVISIBLE);
            }else if(ClickedFirst == 4){
                iv_22.setVisibility(View.INVISIBLE);
            }else if(ClickedFirst == 5){
                iv_23.setVisibility(View.INVISIBLE);
            }

            if(ClickedSecond == 0){
                iv_11.setVisibility(View.INVISIBLE);
            } else if(ClickedSecond == 1){
                iv_12.setVisibility(View.INVISIBLE);
            }else if(ClickedSecond == 2){
                iv_13.setVisibility(View.INVISIBLE);
            }else if(ClickedSecond == 3){
                iv_21.setVisibility(View.INVISIBLE);
            }else if(ClickedSecond == 4){
                iv_22.setVisibility(View.INVISIBLE);
            }else if(ClickedSecond == 5){
                iv_23.setVisibility(View.INVISIBLE);
            }

            if(turn == 1){
                PlayerPoints++;
                tv_p1.setText("P1: "+ PlayerPoints);
            }else if(turn == 2){
                cpuPoints++;
                tv_p2.setText("P2: "+ cpuPoints);
            }
        }else{
            iv_11.setImageResource(R.drawable.ic_close);
            iv_12.setImageResource(R.drawable.ic_close);
            iv_13.setImageResource(R.drawable.ic_close);
            iv_21.setImageResource(R.drawable.ic_close);
            iv_22.setImageResource(R.drawable.ic_close);
            iv_23.setImageResource(R.drawable.ic_close);

            if(turn == 1){
                turn =2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLACK);
            }else if(turn == 2){
                turn =1;
                tv_p1.setTextColor(Color.BLACK);
                tv_p2.setTextColor(Color.GRAY);
            }

        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);

        checkEnd();

    }

    private void checkEnd() {

        if(iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE
        ){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nP1: "+ PlayerPoints+"P2: "+cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

            AlertDialog alertDialog= alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void fontOfCardsResources() {

        image101=R.drawable.city1;
        image102=R.drawable.city2;
        image103=R.drawable.city3;
        image201=R.drawable.city1;
        image202=R.drawable.city2;
        image203=R.drawable.city3;

    }
}