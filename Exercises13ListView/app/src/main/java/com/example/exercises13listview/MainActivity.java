package com.example.exercises13listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtten;
    TextView txtchon;
    Button btn, btnNext, btnEx14;
    ListView lv;
    ArrayList<String> arrList = null;
//    ArrayAdapter<String> adapter=null;

    MyAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtten=(EditText) findViewById(R.id.editName);
        txtchon=(TextView) findViewById(R.id.txtShow);
        lv=(ListView) findViewById(R.id.lvName);
        btnNext = (Button) findViewById(R.id.btnEx13Th4);
        btnEx14 = (Button) findViewById(R.id.btnEx14);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Ex13_TH4.class);
                startActivity(intent1);
            }
        });

        btnEx14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Ex14.class);
                startActivity(intent2);
            }
        });

        //1. Tạo ArrayList object
        arrList= new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
//        adapter=new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, arrList);
        adapter=new MyAdapter(MainActivity.this, R.layout.myitemlist, arrList);
        //3. gán Adapter vào ListView
        lv.setAdapter(adapter);
        btn=(Button) findViewById(R.id.btnNhap);
        //4. Xử lý sự kiện nhấn nút Nhập
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arrList.add(txtten.getText()+"");
                adapter.notifyDataSetChanged();
                txtten.setText("");
            }
        });

        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg2, long arg3) {
                txtchon.setText("position : "+ arg2+ "; value ="+arrList.get(arg2));
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