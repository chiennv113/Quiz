package com.example.chien.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSport;
    private Button mBtnMarth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mBtnMarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MarthActivity.class);
                startActivity(intent);
            }
        });

        mBtnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,SportActivity.class);
                startActivity(intent1);
            }
        });

    }

    private void initView() {
        mBtnSport = findViewById(R.id.btnSport);
        mBtnMarth = findViewById(R.id.btnMarth);
    }
}
