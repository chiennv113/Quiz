package com.example.chien.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ResultActivitySport extends AppCompatActivity {

    private TextView mTvSoLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_sport);
        initView();

        Intent intent = getIntent();
        int a = intent.getIntExtra("mark",0);
        Log.e("diemden","" + a);

        mTvSoLuong.setText("Bạn đã làm đúng " + a + "/1 câu hỏi  ");

    }

    private void initView() {
        mTvSoLuong = findViewById(R.id.tvSoLuong);
    }
}
