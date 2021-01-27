package com.example.vuducvuong_ktpm2;

import android.app.Activity;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

public class myAdapter extends ArrayAdapter {
    Activity context=null;
    ArrayList<KhaiBao> myArray=null;
    int layoutId;
    public myAdapter(Activity context, int layoutId, ArrayList<KhaiBao> arr) {
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

            final KhaiBao kb = myArray.get(position);
            txtdisplay.setText(kb.toString());
        }
        return convertView;
    }
}
