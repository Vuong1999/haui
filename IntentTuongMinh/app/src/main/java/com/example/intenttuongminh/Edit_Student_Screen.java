package com.example.intenttuongminh;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Edit_Student_Screen extends AppCompatActivity {

    String studentCode, studentName, studentGender, studentClass;
    EditText edt_studentCode, edt_studentName, edt_studentClass;
    RadioGroup rdg_studentGender;
    RadioButton rdb_studentMale, rdb_studentFemale;
    public static final String EDITED_STUDENT_CODE = "edited_Student_code";
    public static final String EDITED_STUDENT_NAME = "edited_Student_name";
    public static final String EDITED_STUDENT_GENDER = "edited_Student_gender";
    public static final String EDITED_STUDENT_CLASS = "edited_Student_class";
    public static final String RESULT = "result";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student);

        initWidget();
        getData();

    }

    public void Edit(View view) {
        Intent intent = new Intent();

        //Sửa thông tin sinh viên dựa vào các dữ liệu người dùng nhập vào từ bàn phím
        String studentCode = edt_studentCode.getText().toString();
        String studentName = edt_studentName.getText().toString();
        String studentGender = getEditedStudentGender();
        String studentClass = edt_studentClass.getText().toString();
        Student student = new Student(studentCode, studentName, studentGender, studentClass);

        //đóng gói dữ liệu để trả lại activity cần nhận dữ liệu
        intent.putExtra(RESULT, student);
        setResult(RESULT_OK, intent);
        finish();
    }

    //Nhận dữ liệu cần sửa và đẩy lên các view tương ứng
    public void getData(){
        Intent intent = getIntent();
        studentCode = intent.getStringExtra(List_Student_Screen.STUDENT_CODE);
        studentName = intent.getStringExtra(List_Student_Screen.STUDENT_NAME);
        studentGender = intent.getStringExtra(List_Student_Screen.STUDENT_GENDER);
        studentClass = intent.getStringExtra(List_Student_Screen.STUDENT_CLASS);
        edt_studentCode.setText(studentCode);
        edt_studentName.setText(studentName);

        if(studentGender.equals("Male")){
            rdb_studentMale.setChecked(true);
        }else{
            rdb_studentFemale.setChecked(true);
        }

        edt_studentClass.setText(studentClass);
    }

    public String getEditedStudentGender(){
        int id = rdg_studentGender.getCheckedRadioButtonId();
        RadioButton button = findViewById(id);
        return button.getText().toString();
    }

    public void initWidget(){
        edt_studentCode = findViewById(R.id.edt_editStudentCode);
        edt_studentName = findViewById(R.id.edt_editStudentName);
        edt_studentClass = findViewById(R.id.edt_editStudentClass);
        rdg_studentGender = findViewById(R.id.rdg_editStudentGender);
        rdb_studentMale = findViewById(R.id.rdb_editStudentMale);
        rdb_studentFemale = findViewById(R.id.rdb_editStudentFemale);
    }


}
