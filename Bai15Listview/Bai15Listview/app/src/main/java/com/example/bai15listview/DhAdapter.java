package com.example.bai15listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DhAdapter extends ArrayAdapter<DH> {
     Activity context;
     int resource;
     ArrayList<DH> arr;

    public DhAdapter(Activity context, int resource,ArrayList<DH> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource =resource;
        this.arr = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(resource, null);
        DH dh = arr.get(position);
        TextView txtTT = convertView.findViewById(R.id.txt_tt);
        txtTT.setText(dh.toString());
        return convertView;
    }
}
