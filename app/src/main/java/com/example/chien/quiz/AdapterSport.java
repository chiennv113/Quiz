package com.example.chien.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSport extends BaseAdapter {
    Context context;
    ArrayList<ModelSport> arrayList;

    public AdapterSport(Context context, ArrayList<ModelSport> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.custom_item_sport,null);

        ModelSport modelSport = arrayList.get(i);

        TextView as = (TextView) view.findViewById(R.id.tvAs);
        as.setText(modelSport.as);
        return view;
    }
}
