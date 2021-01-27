package com.example.test_20201208;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.test_20201208.MainActivity.helper;

public class MainActivity2 extends AppCompatActivity {
    EditText lop, maSV, tenSV, diemTB;
    Button xn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findID();
        btnXN();
    }

    private void findID() {
        lop = findViewById(R.id.editLop);
        maSV = findViewById(R.id.editMa);
        tenSV = findViewById(R.id.editTen);
        diemTB = findViewById(R.id.editTB);
        xn = findViewById(R.id.ChapNhan);

    }

    void btnXN() {
        xn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.lv = (ListView) helper.getAllSVAdvanced();
                String masv = maSV.getText().toString();
                String tensv = tenSV.getText().toString();
                String diemtb = diemTB.getText().toString();
                String Lop = lop.getText().toString();
                helper.insertSV(masv, tensv, diemtb, Lop);
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
            }
        });
    }
}