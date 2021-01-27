package com.ktpm02.bt_11_10_2020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ktpm02.bt_11_10_2020.databinding.Activity2Binding;

public class ActivityThem extends AppCompatActivity implements View.OnClickListener {

    private String maSV = null;
    private String tenSV = null;
    private String lop = null;
    private String diemTB = null;

    private Activity2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_2);
        binding.edtDiemTb.setText(getIntent().getStringExtra("DiemTB1"));
        binding.edtMaSv.setText(getIntent().getStringExtra("MaSV1"));
        binding.edtTenSv.setText(getIntent().getStringExtra("TenSV1"));
        binding.edtLop.setText(getIntent().getStringExtra("Lop1"));
        binding.btnSua.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        maSV = binding.edtMaSv.getText().toString();
        tenSV = binding.edtTenSv.getText().toString();
        lop = binding.edtLop.getText().toString();
        diemTB = binding.edtDiemTb.getText().toString();
        if (maSV != null && tenSV != null && lop != null && diemTB != null) {
            Intent output = new Intent();
            output.putExtra("MaSV", maSV);
            output.putExtra("TenSV", tenSV);
            output.putExtra("Lop", lop);
            output.putExtra("DiemTb", diemTB);
            setResult(Activity.RESULT_OK, output);
            finish();
        }else {
            Toast.makeText(this, "Mời bạn nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }
}
