package com.example.vuducvuong_2017604374_test2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vuducvuong_2017604374_test2.

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
    //Khai báo ArrayAdapter cho ListView
    ArrayAdapter<SinhVien> adapter = null;
    SinhVienDao spnLop;
    EditText editMaSv, editTenSv, editDiem;
    ListView lv;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getFormWidgets();
        getDefaultInfor();
        addEventFormWidgets();
        binding.btncongviec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processAddJob();
            }
        });
    }

    private void initData() {
        SinhVien sv1 = new SinhVien("Sv01", "Nguyễn Văn A", "8.5");
        SinhVien sv2 = new SinhVien("Sv02", "Vũ Thị B","8.0");
        SinhVien sv3 = new SinhVien("Sv03", "Trần Hoàng C", "7.7");
        arrSv.add(sv1);
        arrSv.add(sv2);
        arrSv.add(sv3);
        arrSv.addAll(AppDatabase.getInMemoryDatabase(this).SinhVienDao().getAll());
        adapter.notifyDataSetChanged();
    }
    private void addEventFormWidgets() {
    }

    private void getDefaultInfor() {
    }

    private void getFormWidgets() {
        adapter = new ArrayAdapter<SinhVien>()
                (this, android.R.layout.simple_list_item_1, arrSv);
        binding.lv.setAdapter(adapter);
        initData();
    }
}