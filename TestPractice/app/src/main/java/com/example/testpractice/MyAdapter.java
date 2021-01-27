package com.example.testpractice;

import android.app.Activity;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {
    Activity context=null;
    ArrayList<DonHang> myArray=null;
    int layoutId;
    public MyAdapter(Activity context, int layoutId, ArrayList<DonHang> arr) {
        super(context, layoutId, arr);
        this.context= context;
        this.layoutId=layoutId;
        this.myArray=arr;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final TextView txtdisplay;
            txtdisplay = (TextView) convertView.findViewById(R.id.txtitem);

            final DonHang dh = myArray.get(position);
            txtdisplay.setText(dh.toString());
        }
        return convertView;
    }
}
