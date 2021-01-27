package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex9_SumProgram extends AppCompatActivity {

    Button btnKq;
    EditText txtA, txtB;
    TextView txtRsSum;
    int a=0; int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex9__sum_program);
        btnKq = findViewById(R.id.btnKq);
        txtA = (EditText)findViewById(R.id.txtA);
        txtB = (EditText)findViewById(R.id.txtB);
        txtRsSum = (TextView) findViewById(R.id.txtRsSum);
    }

    // Cách 1: Tạo hàm trùng với chuỗi gán cho thuộc tính onClick xml
    public void btn_Kq(View v){
        a = Integer.parseInt(txtA.getText()+"");
        b = Integer.parseInt(txtB.getText()+"");
        txtRsSum.setText((a + b)+"");
    }




}