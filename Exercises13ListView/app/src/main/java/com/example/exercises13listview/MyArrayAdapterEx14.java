package com.example.exercises13listview;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyArrayAdapterEx14 extends ArrayAdapter<Employee> {
        Activity context=null;
        ArrayList<Employee> myArray=null;
        IntlayoutId;
/**
 * Constructor này dùng để khởi tạo các giá trị
 * từ MainActivity truyền vào
 * @param context : là Activity từ Main
 * @param layoutId: Là layout custom do ta tạo
(my_item_layout.xml)
 * @param arr : Danh sách nhân viên truyền từ Main
 */
        PublicvMyArrayAdapter(Activity
        context, intlayoutId, ArrayList<Employee>arr)
        {
        super(context, layoutId, arr);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arr;
        }
/**
 * hàm dùng để custom layout, ta phải override lại hàm này
 * từ MainActivity truyền vào
 * @param position : là vị trí của phần tử trong danh sách nhân
viên
 * @param convertView: convertView, dùng nó để xử lý Item
 * @param parent : Danh sách nhân viên truyền từ Main
 * @return View: trả về chính convertView
 */
        Public View getView(intposition, View convertView,ViewGroup
        parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);

    public MyArrayAdapterEx14(@NonNull Context context, int resource) {
        super(context, resource);
    }