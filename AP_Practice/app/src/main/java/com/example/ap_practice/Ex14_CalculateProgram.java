package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex14_CalculateProgram extends AppCompatActivity {

    Button btn_Plus, btn_Minus, btn_Multiply, btn_Divide, btn_ClearCalculate;
    EditText txtA, txtB;
    TextView txtRsCalculate;
    double a = 0;
    double b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex14__calculate_program);
        btn_Plus = findViewById(R.id.btnPlus);
        btn_Minus = findViewById(R.id.btnMinus);
        btn_Multiply = findViewById(R.id.btnMultiply);
        btn_Divide = findViewById(R.id.btnDivide);
        btn_ClearCalculate = findViewById(R.id.btnClearCalculate);
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        txtRsCalculate = (TextView) findViewById(R.id.txtRsCalculate);

        // Làm bằng cách 5
        btn_Plus.setOnClickListener(new DoPlus());
        btn_Minus.setOnClickListener(new DoMinus());
        btn_Multiply.setOnClickListener(new DoMultiply());
        btn_Divide.setOnClickListener(new DoDivide());
        btn_ClearCalculate.setOnClickListener(new DoClear());
    }

    protected class DoPlus implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnPlus){
                a = Double.parseDouble(txtA.getText()+"");
                b = Double.parseDouble(txtB.getText()+"");
                txtRsCalculate.setText((a+b)+"");
            }
        }
    }

    protected class DoMinus implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnMinus){
                a = Double.parseDouble(txtA.getText()+"");
                b = Double.parseDouble(txtB.getText()+"");
                txtRsCalculate.setText((a-b)+"");
            }
        }
    }

    protected class DoMultiply implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnMultiply){
                a = Double.parseDouble(txtA.getText()+"");
                b = Double.parseDouble(txtB.getText()+"");
                txtRsCalculate.setText((a*b)+"");
            }
        }
    }

    protected class DoDivide implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnDivide){
                a = Double.parseDouble(txtA.getText()+"");
                b = Double.parseDouble(txtB.getText()+"");
                if(b==0)
                    txtRsCalculate.setText("Giá trị b không thoả mãn");
                else txtRsCalculate.setText((a/b)+"");
            }
        }
    }

    protected class DoClear implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnClearCalculate){
                txtA.setText("");
                txtB.setText("");
                txtRsCalculate.setText("");
            }
        }
    }
}