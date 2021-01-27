package com.example.exercises13listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Ex13_TH4 extends AppCompatActivity {

    EditText editId,editName;
    Button btnNhap;
    RadioGroup radgroup;
    ListView lvNhanvien;
    ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
    ArrayAdapter<Employee>adapter=null;
    //Khai báo 1 employee object
    Employee employee=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex13__t_h4);

        editId=(EditText) findViewById(R.id.editMaNv);
        editName=(EditText) findViewById(R.id.editTenNv);
        btnNhap=(Button) findViewById(R.id.btnNhapNv);
        radgroup=(RadioGroup) findViewById(R.id.rgLoaiNv);
        lvNhanvien=(ListView) findViewById(R.id.lvNv);
        //đưa Data Source là các employee vào Adapter
        adapter=new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        //đưa adapter vào ListView
        lvNhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNhap();
            }
        });
    }
    //Xử lý sự kiện nhập
    public void processNhap()
    {
        //Lấy ra đúng id của Radio Button được checked
        int radId=radgroup.getCheckedRadioButtonId();
        String id=editId.getText()+"";
        String name=editName.getText()+"";
        if(radId==R.id.rbChinhThuc)
        {
        //tạo instance là FullTime
            employee = new EmployeeFulltime();
        }
        else
        {
        //Tạo instance là Partime
            employee = new EmployeeParttime();
        }
        //FullTime hay Partime thì cũng là Employee
        //nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);

        //Đưa employee vào ArrayList
        arrEmployee.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }
}