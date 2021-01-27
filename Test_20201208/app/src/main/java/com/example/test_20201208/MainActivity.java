package com.example.test_20201208;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText editMa, editTen, editTB;
    static ListView lv;
    static Helper helper;
    ArrayList<SinhVien> listSV = null;
    ArrayAdapter<SinhVien> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSV = new ArrayList<SinhVien>();
        find();
        fake();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien s = listSV.get(i);
                editMa.setText(s.getMaSV() + "");
                editTen.setText(s.getTenSV());
                editTB.setText(s.getDiemTB());
            }
        });
        showAll();


    }

    private void fake() {
        helper.insertSV("1","Nguyễn Văn A","10","KTMP2");
        helper.insertSV("2","Nguyễn Thị B","10","KTMP2");
        helper.insertSV("3","Hoàng Văn C","10","KTMP2");
    }

    private void find() {
        helper = new Helper(getBaseContext());
        lv = (ListView) findViewById(R.id.lv);
    }

    public void showAll() {
        listSV.clear();
        listSV = (ArrayList<SinhVien>) helper.getAllSVAdvanced();
        adapter = new ArrayAdapter<SinhVien>(MainActivity.this, android.R.layout.simple_list_item_1, listSV);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void insert() {
        listSV = (ArrayList<SinhVien>) helper.getAllSVAdvanced();
        String masv = editMa.getText().toString();
        String tensv = editTen.getText().toString();
        String diemtb = editTB.getText().toString();
        String lop = spinner.getSelectedItem().toString();
        helper.insertSV(masv, tensv, diemtb, lop);
    }


    public void dong() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Xác nhận");
        dialog.setMessage("Bạn có chắc chắn muốn xóa không?");
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.create().show();
    }


    //khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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
        getMenuInflater().inflate(R.menu.menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        doSomething(item);
        return super.onContextItemSelected(item);
    }

    public void doSomething(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.themSV:
                startActivity(new Intent(this, MainActivity2.class));
                showAll();
                break;
            case R.id.Dong:
                dong();
                break;
        }
    }
}