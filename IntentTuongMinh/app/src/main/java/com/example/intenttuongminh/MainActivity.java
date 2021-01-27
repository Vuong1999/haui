package com.example.intenttuongminh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edt_studentCode, edt_studentName, edt_studentClass;
    RadioGroup rdg_studentGender;
    RadioButton rdb_studentMale, rdb_studentFemale;
    ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Hàm xác định các view có trên giao diện
    public void initWidget(){
        edt_studentCode = findViewById(R.id.edt_studentCode);
        edt_studentName = findViewById(R.id.edt_studentName);
        rdg_studentGender = findViewById(R.id.rdg_studentGender);
        rdb_studentMale = findViewById(R.id.rdb_studentMale);
        rdb_studentFemale = findViewById(R.id.rdb_studentFemale);
        edt_studentClass = findViewById(R.id.edt_studentClass);
    }

    //Phương thức "Thêm sinh viên", nhận dữ liệu từ người dùng nhập vào
    public void Add(View view) {
        String stdCode = edt_studentCode.getText().toString();
        String stdName = edt_studentName.getText().toString();
        String stdGender = getStudentGender();
        String stdClass = edt_studentClass.getText().toString();

        //Check nếu dữ liệu người dùng bị trống
        if(stdCode.isEmpty() || stdName.isEmpty() || stdGender.isEmpty() || stdClass.isEmpty()){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Alert")
                    .setMessage("Can't be empty")
                    .setNegativeButton("Confirm", null)
                    .create()
                    .show();
        }else{
            studentList.add(new Student(stdCode, stdName, stdGender, stdClass));
            Toast.makeText(MainActivity.this, "Add successfully", Toast.LENGTH_SHORT).show();

            //Chuyển màn hình, sử dụng bundle để gửi 1 object sang activity khác
            //Bundle trong android là một đối tượng dữ liệu được tạo ra
            //nhằm mục dích đóng gói các dữ liệu cần được truyền qua lại giữa các Intent trong Android
            Intent intent = new Intent(MainActivity.this, List_Student_Screen.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("key", studentList);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    //Lấy thông tin giới tính sinh viên từ RadioButton người dùng nhập vào
    public String getStudentGender(){
        int id = rdg_studentGender.getCheckedRadioButtonId();
        RadioButton button = findViewById(id);
        return button.getText().toString();
    }

    //Phương thức thoát chương trình
    public void Exit(View view) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Warning")
                .setMessage("Do you want to close app?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new CountDownTimer(3000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                Toast.makeText(MainActivity.this, "Chương trình sẽ thoát trong " + millisUntilFinished/1000 + " giây ", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFinish() {
                                Toast.makeText(MainActivity.this, "Chương trình đã thoát", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }.start();
                    }
                })
                .create()
                .show();
    }

}