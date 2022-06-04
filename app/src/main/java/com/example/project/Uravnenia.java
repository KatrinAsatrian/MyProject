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

public class Uravnenia extends AppCompatActivity {

    ImageButton but;
    EditText editText;
    TextView znak;
    TextView levo;
    TextView pravo;
    TextView coins;
    TextView health;
    TextView tima;
    SharedPreferences sP;

    public static final String myPcoin = "mycoin";
    public static final String coi = "0";



    long md;


    public int otvet,result;
    int x1, x2, x3,heal=3,coin=0,plumin,plumin2,scroudge;
    AlertDialog.Builder otvetok1,otvetok2,otvetok3,defeat;
    MediaPlayer loose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uravnenia);
        sP = getSharedPreferences(myPcoin, Context.MODE_PRIVATE);


        editText = (EditText) findViewById(R.id.editText);




        tima = (TextView) findViewById(R.id.textView4);
        znak = (TextView) findViewById(R.id.Znak);
        levo = (TextView) findViewById(R.id.levo);
        pravo = (TextView) findViewById(R.id.pravo);
        coins = (TextView) findViewById(R.id.Coins);
        health = (TextView) findViewById(R.id.Health);
        but = (ImageButton) findViewById(R.id.button6);
        loose = MediaPlayer.create(this, R.raw.looser);
        otvetok1 = new AlertDialog.Builder(this);
        otvetok1.setTitle("Подтверждение ответа");
        otvetok1.setMessage("Вы уверены в правильности собственного ответа?");
        otvetok1.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                if (otvet == result) {
                    coin += scroudge;
                    coins.setText(Integer.toString(coin));
                    editText.setText("");
                    easy();
                } else if (otvet != result) {
                    heal -= 1;
                    health.setText(Integer.toString(heal));
                    editText.setText("");
                    easy();
                }
                if (heal==0)
                {
                    loose.start();
                    save();
                    defeat = new AlertDialog.Builder(Uravnenia.this);
                    defeat.setTitle("Ваш счет!:");
                    defeat.setMessage(Integer.toString(coin));
                    defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            loose.start();
                            Intent intent = new Intent(Uravnenia.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    defeat.setCancelable(false);
                    defeat.show();

                }


            }
        });

        otvetok1.setNegativeButton("Подумаю еще", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.cancel();
            }
        });
        otvetok1.setCancelable(false);



        otvetok2 = new AlertDialog.Builder(this);
        otvetok2.setTitle("Подтверждение ответа");
        otvetok2.setMessage("Вы уверены в правильности собственного ответа?");
        otvetok2.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                if (otvet == result) {
                    coin += scroudge;
                    coins.setText(Integer.toString(coin));
                    editText.setText("");
                    average();
                } else if (otvet != result) {
                    heal -= 1;
                    health.setText(Integer.toString(heal));
                    editText.setText("");
                    average();
                }
                if (heal==0)
                {
                    loose.start();
                    save();
                    defeat = new AlertDialog.Builder(Uravnenia.this);
                    defeat.setTitle("Ваш счет!:");
                    defeat.setMessage(Integer.toString(coin));
                    defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            loose.start();
                            Intent intent = new Intent(Uravnenia.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    defeat.setCancelable(false);
                    defeat.show();

                }


            }
        });

        otvetok2.setNegativeButton("Подумаю еще", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.cancel();
            }
        });
        otvetok2.setCancelable(false);



        otvetok3 = new AlertDialog.Builder(this);
        otvetok3.setTitle("Подтверждение ответа");
        otvetok3.setMessage("Вы уверены в правильности собственного ответа?");
        otvetok3.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                if (otvet == result) {

                    coin += scroudge;
                    coins.setText(Integer.toString(coin));
                    editText.setText("");
                    md+=2000;
                    hard();

                } else if (otvet != result) {
                    heal -= 1;
                    health.setText(Integer.toString(heal));
                    editText.setText("");
                    hard();

                }
                if (heal==0)
                {
                    loose.start();
                    save();
                    defeat = new AlertDialog.Builder(Uravnenia.this);
                    defeat.setTitle("Ваш счет!:");
                    defeat.setMessage(Integer.toString(coin));
                    defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            loose.start();
                            Intent intent = new Intent(Uravnenia.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    defeat.setCancelable(false);
                    defeat.show();

                }


            }
        });

        otvetok3.setNegativeButton("Подумаю еще", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.cancel();
            }
        });
        otvetok3.setCancelable(false);



        if (MainActivity.diff == 1) {
            scroudge=5;
            easy();
            try {
                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        otvet = Integer.parseInt(String.valueOf(editText.getText()));
                        otvetok1.show();

                    }
                });
            }
            catch (NullPointerException e)
            {

                otvet=15000;
            }


        }
        else if (MainActivity.diff == 2) {
            scroudge=10;
            average();
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    otvet = Integer.parseInt(String.valueOf(editText.getText()));

                    otvetok2.show();
                    if (heal==0)
                    {
                        loose.start();
                        save();
                        defeat = new AlertDialog.Builder(Uravnenia.this);
                        defeat.setTitle("Ваш счет!:");
                        defeat.setMessage(Integer.toString(coin));
                        defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                loose.start();
                                Intent intent = new Intent(Uravnenia.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                        defeat.setCancelable(false);
                        defeat.show();

                    }


                }
            });

        }
        else if (MainActivity.diff == 3) {
            scroudge=50;
            tim();
            hard();
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    otvet = Integer.parseInt(String.valueOf(editText.getText()));
                    otvetok3.show();
                    if (heal==0)
                    {
                        loose.start();
                        save();
                        defeat = new AlertDialog.Builder(Uravnenia.this);
                        defeat.setTitle("Ваш счет!:");
                        defeat.setMessage(Integer.toString(coin));
                        defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                loose.start();
                                Intent intent = new Intent(Uravnenia.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                        defeat.setCancelable(false);
                        defeat.show();

                    }

                }
            });
        }


    }


    public int easy() {

        Random random = new Random();
        x1 = Integer.valueOf(random.nextInt(10));
        x2 = Integer.valueOf(random.nextInt(10));
        result = x1 + x2;

        levo.setText(Integer.toString(x1) + " + " + Integer.toString(x2));
        pravo.setText("X");
        return result;
    }
    public int average(){
        Random random = new Random();
        x1 = Integer.valueOf(random.nextInt(100));
        x3 = Integer.valueOf(random.nextInt(100));
        plumin = Integer.valueOf(random.nextInt(2))+1;
        if (plumin==1) {
            result = x3 - x1;
            levo.setText(Integer.toString(x1)+" + "+"X");
            pravo.setText(Integer.toString(x3));
        }
        else if (plumin==2){
            result = x1 - x3;
            levo.setText(Integer.toString(x1)+ " - " +"X");
            pravo.setText(Integer.toString(x3));
        }
        return result;
    }
    public int hard()
    {
        Random random = new Random();
        x1 = Integer.valueOf(random.nextInt(500));
        x2 = Integer.valueOf(random.nextInt(500));
        x3 = Integer.valueOf(random.nextInt(500));
        plumin = Integer.valueOf(random.nextInt(2))+1;
        plumin2 = Integer.valueOf(random.nextInt(2))+1;

        if (plumin==1)
        {
            if (plumin2 == 1) {
                result = x2 + x3 - x1;
                levo.setText("X"+ " + "+Integer.toString(x1));
                pravo.setText(Integer.toString(x2) + " + " +Integer.toString(x3));
            }
            else if(plumin2==2){
                result = x2 - x3 - x1;
                levo.setText("X"+ " + "+Integer.toString(x1));
                pravo.setText(Integer.toString(x2) + " - " +Integer.toString(x3));
            }
        }
        else if (plumin==2)
        {
            if (plumin2==1)
            {
                result = x2 + x3 + x1;
                levo.setText("X"+ " - "+Integer.toString(x1));
                pravo.setText(Integer.toString(x2) + " + " +Integer.toString(x3));
            }
            else if(plumin2==2)
            {
                result = x2 - x3 + x1;
                levo.setText("X"+ " - "+Integer.toString(x1));
                pravo.setText(Integer.toString(x2) + " - " +Integer.toString(x3));
            }
        }


        return result;
    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public boolean save()
    {

        SharedPreferences.Editor editor = sP.edit();
        editor.putString(coi, Integer.toString(coin));
        editor.apply();
        return true;
    }
    public boolean tim()
    {
        new CountDownTimer(100000, 1000) {

            public void onTick(long md) {
                tima.setText("Осталось: " + md / 1000);
            }

            public void onFinish() {


                heal -= 3;
                cancel ();
                if (heal<=0)
                {
                    loose.start();
                    save();
                    defeat = new AlertDialog.Builder(Uravnenia.this);
                    defeat.setTitle("Ваш счет!:");
                    defeat.setMessage(Integer.toString(coin));
                    defeat.setPositiveButton("В главное меню", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int arg1) {
                            loose.start();
                            Intent intent = new Intent(Uravnenia.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    defeat.setCancelable(false);
                    defeat.show();

                }
                health.setText(Integer.toString(heal));
                editText.setText("");
                hard();

            }

        }.start();

        return true;
    }
    public void erorr() throws NullPointerException{
        throw new NullPointerException("15000");
    }
}