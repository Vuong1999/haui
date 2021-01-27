package com.example.nhom2_android_project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import java.util.*;
import com.example.nhom2_android_project.databinding.EditOrderBinding;

public class Edit_Order extends AppCompatActivity {
    private int banAn = 0;
    private String monAn = "";
    private int soLuong = 0;
    private String soThich = "";
    private String kM = "Không";

    private EditOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String mon = getIntent().getStringExtra("Mon");
        String sothich = getIntent().getStringExtra("SoThich");
        String km = getIntent().getStringExtra("KhuyenMai");
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.edit__order);

        binding.edtBan.setText(getIntent().getIntExtra("Ban", 0)+"");

        if(mon.equals("Phở tái")==true){
            binding.rbTai.setChecked(true);
        }
        if(mon.equals("Phở chín")==true){
            binding.rbChin.setChecked(true);
        }
        if(mon.equals("Phở nạm")==true){
            binding.rbNam.setChecked(true);
        }
        if(mon.equals("Phở gầu")==true){
            binding.rbGau.setChecked(true);
        }
//        binding.edtMon.setText(getIntent().getStringExtra("Mon"));
        binding.edtSoluong.setText(getIntent().getIntExtra("SoLuong", 0)+"");

//        binding.edtSothich.setText(getIntent().getStringExtra("SoThich"));
        if(sothich.equals("Không hành")==true){
            binding.chkKhonghanh.setChecked(true);
        }
        if(sothich.equals("Không mì")==true){
            binding.chkKhongmychinh.setChecked(true);
        }
        if(sothich.equals("Thêm giá")==true){
            binding.chkGiado.setChecked(true);
        }
        if(sothich.equals("Ít nước")==true){
            binding.chkItnuoc.setChecked(true);
        }
//        binding.edtKm.setText(getIntent().getStringExtra("KhuyenMai"));
        if(km.equals("Có")==true){
            binding.ckKm.setChecked(true);
        } else {
            binding.ckKm.setChecked(false);
        }
        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banAn=Integer.parseInt(binding.edtBan.getText().toString());
                soLuong = Integer.parseInt(binding.edtSoluong.getText().toString());
                if(binding.rbTai.isChecked()){
                    monAn="Phở tái";
                }if(binding.rbChin.isChecked()){
                    monAn="Phở chín";
                }if(binding.rbNam.isChecked()){
                    monAn="Phở nậm";
                }if(binding.rbGau.isChecked()){
                    monAn="Phở gầu";
                }

                if(binding.chkKhonghanh.isChecked()){
                    soThich="Không hành";
                }else if(binding.chkKhongmychinh.isChecked()){
                    soThich+="Không mì";
                }else if(binding.chkItnuoc.isChecked()){
                    soThich+="ít nước";
                }else if(binding.chkGiado.isChecked()){
                    soThich+="Thêm giá";
                }
                if (binding.ckKm.isChecked()){
                    kM="Có";
                }
                if (banAn != 0 && monAn != null && soLuong != 0 && soThich != null && kM != null) {
                    Intent output = new Intent();
                    output.putExtra("newBan", banAn);
                    output.putExtra("newMon", monAn);
                    output.putExtra("newSl", soLuong);
                    output.putExtra("newSt", soThich);
                    output.putExtra("newKm", kM);
                    setResult(Activity.RESULT_OK, output);
                    finish();
                }else {
                    Toast.makeText(Edit_Order.this, "Mời bạn nhập đủ dữ liệu", Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Edit_Order.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
