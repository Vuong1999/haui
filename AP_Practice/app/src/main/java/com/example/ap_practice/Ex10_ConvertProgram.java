package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex10_ConvertProgram extends AppCompatActivity {
    Button btn_CvC, btn_CvF, btn_Clear;
    EditText EditC, EditF;
    double doC=0.0;
    double doF=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10__convert_program);
        btn_CvC = findViewById(R.id.btnCvC);
        btn_CvF = findViewById(R.id.btnCvF);
        btn_Clear = findViewById(R.id.btnClear);
        EditC = (EditText)findViewById(R.id.EditC);
        EditF = (EditText)findViewById(R.id.EditF);

        // Cách 2: Chọn sự kiện của nút lênh
        btn_CvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doF= Double.parseDouble(EditF.getText()+"");
                EditC.setText(((doC-32)/1.8)+"");
            }
        });

        btn_CvF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doC = Double.parseDouble(EditC.getText()+"");
                EditF.setText(((doC*1.8)+32)+"");
            }
        });

        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditF.setText("");
                EditC.setText("");
            }
        });
    }
}