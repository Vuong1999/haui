package com.example.ap_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex11_ConvertCalendar extends AppCompatActivity {
    Button btn_CvYear;
    EditText EditYearDL;
    TextView txtYearAL;
    int YearDL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11__convert_calendar);
        btn_CvYear=findViewById(R.id.btnCvYear);
        EditYearDL=(EditText)findViewById(R.id.EditYearDL);
        txtYearAL=(TextView)findViewById(R.id.txtYearAL);
        // Dùng cách 2:
        btn_CvYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YearDL = Integer.parseInt(EditYearDL.getText()+"");

                String can = "", chi = "";

                // Xác định Can
                switch ((int)YearDL % 10) {
                    case 0:
                        can = "Canh";
                        break;
                    case 1:
                        can = "Tân";
                        break;
                    case 2:
                        can = "Nhâm";
                        break;
                    case 3:
                        can = "Quý";
                        break;
                    case 4:
                        can = "Giáp";
                        break;
                    case 5:
                        can = "Ất";
                        break;
                    case 6:
                        can = "Bính";
                        break;
                    case 7:
                        can = "Đinh";
                        break;
                    case 8:
                        can = "Mậu";
                        break;
                    case 9:
                        can = "Kỷ";
                        break;
                }

                // Xác định Chi
                switch ((int)YearDL % 12) {
                    case 0:
                        chi = "Thân";
                        break;
                    case 1:
                        chi = "Dậu";
                        break;
                    case 2:
                        chi = "Tuất";
                        break;
                    case 3:
                        chi = "Hợi";
                        break;
                    case 4:
                        chi = "Tý";
                        break;
                    case 5:
                        chi = "Sửu";
                        break;
                    case 6:
                        chi = "Dần";
                        break;
                    case 7:
                        chi = "Mẹo";
                        break;
                    case 8:
                        chi = "Thìn";
                        break;
                    case 9:
                        chi = "Tỵ";
                        break;
                    case 10:
                        chi = "Ngọ";
                        break;
                    case 11:
                        chi = "Mùi";
                        break;
                }

                txtYearAL.setText((can + " " + chi)+"");
            }
        });
    }
}