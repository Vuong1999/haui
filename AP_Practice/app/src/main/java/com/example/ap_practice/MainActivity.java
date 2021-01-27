package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEx9, btnEx10, btnEx11, btnEx12, btnEx13, btnEx14, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEx9 = findViewById(R.id.btnEx9);
        btnEx10 = findViewById(R.id.btnEx10);
        btnEx11 = findViewById(R.id.btnEx11);
        btnEx12 = findViewById(R.id.btnEx12);
        btnEx13 = findViewById(R.id.btnEx13);
        btnEx14 = findViewById(R.id.btnEx14);
        btnExit = findViewById(R.id.btnExit);
        btnEx9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new
                        Intent(MainActivity.this, Ex9_SumProgram.class);
                startActivity(intent1);
            }
        });
        btnEx10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new
                        Intent(MainActivity.this, Ex10_ConvertProgram.class);
                startActivity(intent2);
            }
        });
        btnEx11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new
                        Intent(MainActivity.this, Ex11_ConvertCalendar.class);
                startActivity(intent3);
            }
        });
        btnEx12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new
                        Intent(MainActivity.this, Ex12_BmiProgram.class);
                startActivity(intent4);
            }
        });
        btnEx13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new
                        Intent(MainActivity.this, Ex13_QuadraticProgram.class);
                startActivity(intent5);
            }
        });
        btnEx14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new
                        Intent(MainActivity.this, Ex14_CalculateProgram.class);
                startActivity(intent6);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khoi tao lai Activity main
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
    }
}