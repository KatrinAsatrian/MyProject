package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton button1;
    ImageButton buttonNastr;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    AlertDialog.Builder builder;
    Context context;

    SharedPreferences sP;

    public static final String myPcoin = "mycoin";
    public static final String coi = "0";
    static int diff=1;
    static int coin=0;
    static int heal=3;


    private final int duff = 2;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sP = getSharedPreferences(myPcoin, Context.MODE_PRIVATE);



        button1 = (ImageButton) findViewById(R.id.button);
        buttonNastr = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);
        button5 = (ImageButton) findViewById(R.id.button5);
        context = MainActivity.this;

        mp = MediaPlayer.create(this, R.raw.fun);





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Разработчики")
                        .setMessage("Разработчик данного продукта:Асатрян Катрин Самсоновна, благодарит вас за использование нашего продукта.")
                        .setIcon(R.drawable.bro)
                        .setCancelable(false)
                        .setNegativeButton("Спасибо",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Uravnenia.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Neravenstva.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Records.class);
                startActivity(intent);

            }
        });
    }




    public void Sett  (View view){
        showDialog(duff);
    }
    @Override
    protected Dialog onCreateDialog (int id) {
        switch (id) {
            case duff:
                final String[] mChooseDiff = { "Легкий", "Средний", "Сложный" };
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Выберите уровень сложности")
                        .setCancelable(false)
                        .setNeutralButton("Назад",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();

                                    }
                                })
                        .setSingleChoiceItems(mChooseDiff, -1,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int item) {
                                        if (mChooseDiff[item]=="Легкий")
                                            diff=1;
                                        else if (mChooseDiff[item]=="Средний")
                                            diff=2;
                                        else if (mChooseDiff[item]=="Сложный")
                                            diff=3;

                                    }
                                });

                return builder.create();
            default:
                return null;
        }
    }
}