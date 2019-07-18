package com.example.chien.quiz;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class SportActivity extends AppCompatActivity {

    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private TextView mTvCauHoi;
    private TextView mTvNext;

    AdapterSport adapterSport;
    ArrayList<ModelSport> modelSports;
    private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        initView();

        GetQsSport getQsSport = new GetQsSport();
        getQsSport.execute("http://dotplays.com/android/lab3.json");

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });

    }

    private void initView() {

        mTvCauHoi = findViewById(R.id.tvCauHoi);
        mLv = findViewById(R.id.lv);

        modelSports = new ArrayList<ModelSport>();
        adapterSport = new AdapterSport(SportActivity.this, modelSports);
        mLv.setAdapter(adapterSport);

    }

    public class GetQsSport extends AsyncTask<String, Long, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                String data = "";

                while (scanner.hasNext()) {
                    data = data + scanner.nextLine();
                }

                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.e("data", s);
            try {
                JSONObject root = new JSONObject(s);
                JSONObject quiz = root.getJSONObject("quiz");
                JSONObject sport = quiz.getJSONObject("sport");
                JSONObject q1 = sport.getJSONObject("q1");
                String qs = q1.getString("question");
                String answer = q1.getString("answer");
                Log.e("Qs", qs);
                mTvCauHoi.setText(qs);

                JSONArray jsonArrayOption = q1.getJSONArray("options");
                for (int i = 0; i < jsonArrayOption.length(); i++) {
                    String as = jsonArrayOption.getString(i);
                    modelSports.add(new ModelSport(as));

                }
                adapterSport.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
