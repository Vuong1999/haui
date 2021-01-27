package com.example.exercises13listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtTen, txtTuoi;
    TextView txtchon;
    Button btn, btnNext;
    ListView lv;
    ArrayList<Nguoi> arrList = null;
//    ArrayAdapter<String> adapter=null;

    MyAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTen=(EditText) findViewById(R.id.editName);
        txtTuoi=(EditText) findViewById(R.id.editTuoi);
        lv=(ListView) findViewById(R.id.lvName);
        btnNext = (Button) findViewById(R.id.btnEx13Th4);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Ex13_TH4.class);
                startActivity(intent1);
            }
        });

        //1. Tạo ArrayList object
        arrList= new ArrayList<Nguoi>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
//        adapter=new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, arrList);
        adapter=new MyAdapter(MainActivity.this, R.layout.myitemlist, arrList);
        //3. gán Adapter vào ListView
        lv.setAdapter(adapter);
        btn=(Button) findViewById(R.id.btnNhap);
        //4. Xử lý sự kiện nhấn nút Nhập
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nguoi nguoi = new Nguoi();
                nguoi.setTen(txtTen.getText()+"");
                nguoi.setTuoi(Integer.parseInt(txtTuoi.getText()+""));
                arrList.add(nguoi);
                adapter.notifyDataSetChanged();
                txtTen.setText("");
                txtTuoi.setText("");
                txtTen.requestFocus();
            }
        });

        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg2, long arg3) {
               txtTen.setText(arrList.get(arg2).getTen()+"");
                txtTuoi.setText(arrList.get(arg2).getTuoi()+"");
            }
        });
        //6. xử lý sự kiện Long click
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                arrList.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}