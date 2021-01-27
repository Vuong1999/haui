package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex13_QuadraticProgram extends AppCompatActivity {

    Button btn_Continue, btn_Quadratic, btn_ExitQp;
    EditText EditAQp, EditBQp, EditCQp;
    TextView txtRsQp;
    double AQp, BQp, CQp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex13__quadratic_program);
        btn_Continue = findViewById(R.id.btnContinue);
        btn_Quadratic = findViewById(R.id.btnQuadratic);
        btn_ExitQp = findViewById(R.id.btnExitQuadratic);
        EditAQp = (EditText) findViewById(R.id.EditAQp);
        EditBQp = (EditText) findViewById(R.id.EditBQp);
        EditCQp = (EditText) findViewById(R.id.EditCQp);
        txtRsQp = (TextView) findViewById(R.id.txtRsQp);

        // Cách 5: Tạo đối tượng lắng nghe sự kiện gán cho nút lệnh
        btn_Continue.setOnClickListener(new DoContinue());
        btn_Quadratic.setOnClickListener(new DoQuadratic());
        btn_ExitQp.setOnClickListener(new DoExitQp());
    }

    protected class DoContinue implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnContinue){
                EditAQp.setText("");
                EditBQp.setText("");
                EditCQp.setText("");
            }
        }
    }

    protected class DoQuadratic implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnQuadratic){
                AQp = Double.parseDouble(EditAQp.getText()+"");
                BQp = Double.parseDouble(EditBQp.getText()+"");
                CQp = Double.parseDouble(EditCQp.getText()+"");
                if (AQp == 0) {
                    if (BQp == 0) {
                        txtRsQp.setText("Phương trình vô nghiệm");
                    } else {
                        txtRsQp.setText("Phương trình có một nghiệm:" + "x = " + (-CQp / BQp));
                    }
                    return;
                }
                // tính delta
                double delta = BQp*BQp - 4*AQp*CQp;
                double x1;
                double x2;
                // tính nghiệm
                if (delta > 0) {
                    x1 = (double) ((-BQp + Math.sqrt(delta)) / (2*AQp));
                    x2 = (double) ((-BQp - Math.sqrt(delta)) / (2*AQp));
                    txtRsQp.setText("Phương trình có 2 nghiệm:" + "x1 = " + x1 + " và x2 = " + x2);
                } else if (delta == 0) {
                    x1 = (-BQp / (2 * AQp));
                   txtRsQp.setText("Phương trình có nghiệm kép: "+ "x1 = x2 = " + x1);
                } else {
                    txtRsQp.setText("Phương trình vô nghiệm!");
                }
            }
        }
    }

    protected class DoExitQp implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent7 = new
                    Intent(Ex13_QuadraticProgram.this, MainActivity.class);
            startActivity(intent7);
        }
    }
}