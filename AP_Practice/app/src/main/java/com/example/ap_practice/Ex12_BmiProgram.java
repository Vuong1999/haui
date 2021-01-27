package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ex12_BmiProgram extends AppCompatActivity {
    Button btn_Bmi;
    EditText editNameBmi, editHeightBmi, editWeightBmi, editBmi, editDiagnostic;
    double h = 0;
    double w = 0;
    String name;
    String diagnostic = "";
    // Cách 4: Lắng nghe sự kiện qua biến
    View.OnClickListener myListenner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btn_Bmi) {
                name = editNameBmi.getText().toString();
                h = Double.parseDouble(editHeightBmi.getText()+"");
                w = Double.parseDouble(editWeightBmi.getText()+"");
                double bmi = (double)(w/(h*h));
                editBmi.setText(bmi + "");
                if (bmi < 18)
                    editDiagnostic.setText(name + " là người gầy");
                else if (bmi >= 18 && bmi <= 24.9)
                    editDiagnostic.setText(name + " là người bình thường");
                else if (bmi > 24.9 && bmi <= 29.9)
                    editDiagnostic.setText(name + " bị béo phì cấp độ I");
                else if (bmi > 29.9 && bmi <= 34.9)
                    editDiagnostic.setText(name + " bị béo phì cấp độ II");
                else
                    editDiagnostic.setText(name + " bị béo phì cấp độ III");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12__bmi_program);
        btn_Bmi = findViewById(R.id.btnBmi);
        editNameBmi = (EditText) findViewById(R.id.editNameBmi);
        editHeightBmi = (EditText) findViewById(R.id.editHeightBmi);
        editWeightBmi = (EditText) findViewById(R.id.editWeightBmi);
        editBmi = (EditText) findViewById(R.id.editBmi);
        editDiagnostic = (EditText) findViewById(R.id.editDiagnostic);
        btn_Bmi.setOnClickListener(myListenner);
    }
}