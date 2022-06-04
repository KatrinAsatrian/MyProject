package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Neravenstva extends AppCompatActivity {

    TextView centr;
    ImageButton butOk;
    ImageButton butFal;
    TextView levo;
    TextView pravo;
    TextView coins;
    TextView health;
    TextView team;

    int x1,x2,x3,znak1,znak2,truf,heal=3,coin=0,plumin;
    MediaPlayer loose;
    SharedPreferences sP;
    AlertDialog.Builder defeat;

    public static final String myPcoin = "mycoin";
    public static final String coi = "0";
    long md;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neravenstva);
        centr = (TextView) findViewById(R.id.Znak2);
        butFal= (ImageButton) findViewById(R.id.button8);
        butOk = (ImageButton) findViewById(R.id.t);
        levo = (TextView) findViewById(R.id.textView7);
        pravo = (TextView) findViewById(R.id.textView8);
        coins = (TextView) findViewById(R.id.Coins);
        health = (TextView) findViewById(R.id.Health);
        loose = MediaPlayer.create(this, R.raw.looser);
        team = (TextView) findViewById(R.id.textView5);

        sP = getSharedPreferences(myPcoin, Context.MODE_PRIVATE);

        if (MainActivity.diff==1)
        {
            easy1();
            butOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (truf == znak1) {
                        coin += 5;
                        coins.setText(Integer.toString(coin));
                        easy1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                    else if (truf != znak1) {
                        heal--;
                        health.setText(Integer.toString(heal));
                        easy1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                }
            });
            butFal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (truf != znak1) {
                        coin += 5;
                        coins.setText(Integer.toString(coin));

                        easy1();
                        if (heal==0)
                        {

                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                    else if (truf == znak1) {
                        heal--;
                        health.setText(Integer.toString(heal));
                        easy1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                }
            });


        }
        else if (MainActivity.diff==2)
        {
            average1();
            butOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (truf == znak1) {
                        coin += 10;
                        coins.setText(Integer.toString(coin));
                        average1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();
                        }
                    }
                    else if (truf != znak1) {
                        heal--;
                        health.setText(Integer.toString(heal));
                        average1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                }
            });
            butFal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (truf != znak1) {
                        coin += 10;
                        coins.setText(Integer.toString(coin));

                        average1();
                        if (heal == 0) {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();
                        }
                    } else if (truf == znak1) {
                        heal--;
                        health.setText(Integer.toString(heal));
                        average1();
                        if (heal == 0) {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                }
            });

        }
        else if(MainActivity.diff==3)
        {
            time();
            hard1();
            butOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (truf == znak1) {
                        md+=5000;
                        coin += 50;
                        coins.setText(Integer.toString(coin));
                        hard1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                    else if (truf != znak1) {
                        heal--;
                        health.setText(Integer.toString(heal));
                        hard1();
                        if (heal==0)
                        {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                }
            });
            butFal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (truf != znak1) {
                        md+=5000;
                        coin += 50;
                        coins.setText(Integer.toString(coin));

                        hard1();
                        if (heal == 0) {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    } else if (truf == znak1) {
                        heal--;
                        health.setText(Integer.toString(heal));
                        hard1();
                        if (heal == 0) {
                            save();
                            loose.start();
                            defeat = new AlertDialog.Builder(Neravenstva.this);
                            defeat.setTitle("Ваш счет!:");
                            defeat.setMessage(Integer.toString(coin));
                            defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int arg1) {
                                    loose.start();
                                    Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            defeat.setCancelable(false);
                            defeat.show();

                        }
                    }
                }
            });
        }


    }
    public boolean easy1()
    {
        Random random = new Random();
        x1 = Integer.valueOf(random.nextInt(10));
        x2 = Integer.valueOf(random.nextInt(10));
        znak1 = Integer.valueOf(random.nextInt(2))+1;
        if (x1 <x2) {
            truf = 1;
        }
        if (x1>x2) {
            truf = 2;
        }
        switch (znak1) {
            case 1:
                centr.setText(" < ");
                break;
            case 2:
                centr.setText(" > ");
                break;
        }
        levo.setText(Integer.toString(x1));
        pravo.setText(Integer.toString(x2));
        return true;
    }
    public boolean average1()
    {
        Random random = new Random();
        x1 = Integer.valueOf(random.nextInt(100));
        x2 = Integer.valueOf(random.nextInt(100));
        x3 = Integer.valueOf(random.nextInt(100));
        plumin = Integer.valueOf(random.nextInt(2))+1;
        znak1 = Integer.valueOf(random.nextInt(2))+1;
        switch (plumin){
            case 1:
                levo.setText(Integer.toString(x1) + " + " + Integer.toString(x2));

                znak2=x1+x2;
                break;
            case 2:
                levo.setText(Integer.toString(x1) + " - " + Integer.toString(x2));
                znak2=x1-x2;
                break;
        }
        pravo.setText(Integer.toString(x3));
        switch (znak1) {
            case 1:
                centr.setText(" < ");
                break;
            case 2:
                centr.setText(" > ");
                break;
        }
        if (znak2 <x3) {
            truf = 1;
        }
        if (znak2>x3) {
            truf = 2;
        }
        return true;
    }
    public boolean hard1()
    {
        Random random = new Random();
        x1 = Integer.valueOf(random.nextInt(500));
        x2 = Integer.valueOf(random.nextInt(500));
        plumin = Integer.valueOf(random.nextInt(2))+1;
        znak1 = Integer.valueOf(random.nextInt(2))+1;
        switch (plumin){
            case 1:
                levo.setText(Integer.toString(x1) + " + " + Integer.toString(x2));

                znak2=x1+x2;
                break;
            case 2:
                levo.setText(Integer.toString(x1) + " - " + Integer.toString(x2));
                znak2=x1-x2;
                break;
        }
        x1 = Integer.valueOf(random.nextInt(500));
        x2 = Integer.valueOf(random.nextInt(500));
        plumin = Integer.valueOf(random.nextInt(2))+1;
        switch (plumin){
            case 1:
                pravo.setText(Integer.toString(x1) + " + " + Integer.toString(x2));

                x3=x1+x2;
                break;
            case 2:
                pravo.setText(Integer.toString(x1) + " - " + Integer.toString(x2));
                x3=x1-x2;
                break;
        }
        switch (znak1) {
            case 1:
                centr.setText(" < ");
                break;
            case 2:
                centr.setText(" > ");
                break;
        }
        if (znak2 <x3) {
            truf = 1;
        }
        if (znak2>x3) {
            truf = 2;
        }
        return true;
    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public boolean save()
    {

        SharedPreferences.Editor editor = sP.edit();
        editor.putString(coi, Integer.toString(coin));
        editor.apply();
        return true;
    }
    public boolean time() {
        new CountDownTimer(100000, 1000) {

            public void onTick(long md) {
                team.setText("Осталось: " + md / 1000);
            }

            public void onFinish() {


                heal -= 3;
                cancel();
                if (heal <= 0) {
                    loose.start();
                    save();
                    defeat = new AlertDialog.Builder(Neravenstva.this);
                    defeat.setTitle("Ваш счет!:");
                    defeat.setMessage(Integer.toString(coin));
                    defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            loose.start();
                            Intent intent = new Intent(Neravenstva.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    defeat.setCancelable(false);
                    defeat.show();

                }
                health.setText(Integer.toString(heal));

                hard1();

            }

        }.start();
        return true;
    }
}