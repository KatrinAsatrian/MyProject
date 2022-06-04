package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Records extends AppCompatActivity {
    ImageButton bu;
    SharedPreferences sP;
    TextView textView;
    public static final String myPcoin = "mycoin";

    public static final String coi = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        sP = getSharedPreferences(myPcoin, Context.MODE_PRIVATE);




        bu = (ImageButton) findViewById(R.id.imageButton);
        textView = (TextView) findViewById(R.id.textView6);

        textView.setText(sP.getString(coi, ""));
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Records.this, MainActivity.class);
                startActivity(intent);
                System.exit(0);
            }
        });


    }
}