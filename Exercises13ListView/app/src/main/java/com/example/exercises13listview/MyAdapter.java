package com.example.exercises13listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

class MyAdapter extends ArrayAdapter<String> {
    Activity context = null;
    int layoutID;
    ArrayList<String> list=null;

    public MyAdapter(Activity context , int layoutID, ArrayList<String> objects) {
        super(context, layoutID, objects);
        this.context=context;
        this.layoutID=layoutID;
        this.list=objects;
    }
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        convertView=inflater.inflate(layoutID, null);
        if((list.size()>0)&&(position>=0)){
            //Lấy dòng thứ i
            final TextView txtStt = convertView.findViewById(R.id.txtSTT);
            final TextView txtNoiDung = convertView.findViewById(R.id.txtNoiDung);
            // Lấy bản ghi thứ possition gán cho thành phần tương ứng
            txtStt.setText(position+"");
            txtNoiDung.setText(list.get(position));
        }
        return convertView;
    }
}
