package com.example.menu_edit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btnDangkymenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //đăng ký menu ngữ cảnh
        btnDangkymenu = findViewById(R.id.btnDangkymenu);
        //đăng ký nút menu ngữ cảnh cho nút lệnh
        registerForContextMenu(btnDangkymenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        doSomething(item);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mymenu, menu);
    }
    public boolean onContextItemSelected(MenuItem item) {
        doSomething(item);
        return super.onContextItemSelected(item);
    }
    public void doSomething(MenuItem item){
        switch (item.getItemId()) {
            case R.id.mnuxemds:
                //Xử lý xem danh sách sinh viên
                Toast.makeText(MainActivity.this, "xem dssv", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuSV:
                //Xử lý xem danh sách sinh viên
                Toast.makeText(MainActivity.this, "xem thông tin sv", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnusuads:
                //xử lý sửa dssv
                Toast.makeText(MainActivity.this, "sửa dssv", Toast.LENGTH_LONG).show();
                break;
        }
    }
}