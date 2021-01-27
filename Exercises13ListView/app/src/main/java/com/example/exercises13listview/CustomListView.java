package com.example.exercises13listview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView extends ArrayAdapter<Employee> {
    Context context;
    int resource;
    ArrayList<Employee> arrEmploy;
    public CustomListView( Context context, int resource, ArrayList<Employee> arrEmploy) {
        super(context, resource, arrEmploy);
        this.context = context;
        this.resource = resource;
        this.arrEmploy = arrEmploy;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHoler viewHoler;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            viewHoler = new ViewHoler();
            viewHoler.txtID = (TextView) convertView.findViewById(R.id.txtRawID);
            viewHoler.txtTen = (TextView) convertView.findViewById(R.id.txtRawName);
            viewHoler.txtKieu = (TextView) convertView.findViewById(R.id.txtRawType);
            viewHoler.txtLuong = (TextView) convertView.findViewById(R.id.txtRawLuong);
            convertView.setTag(viewHoler);
        }else{
            viewHoler = (ViewHoler) convertView.getTag();
        }
        Employee employee = arrEmploy.get(position);
        viewHoler.txtID.setText("ID: "+employee.getId());
        viewHoler.txtTen.setText("Họ tên: "+employee.getName());
        viewHoler.txtKieu.setText("Full or Part"+position);
        viewHoler.txtLuong.setText("Mức lương: "+employee.TinhLuong());
        if(position % 2 != 0)
        {
            convertView.setBackgroundColor(Color.GREEN);
        }
        return convertView;
    }

    class ViewHoler{
        TextView txtID, txtTen, txtKieu, txtLuong;
    }

}
