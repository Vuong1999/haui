package com.example.nhom2_android_project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import androidx.databinding.DataBindingUtil;
import com.example.nhom2_android_project.databinding.AddOrderBinding;

public class Add_Order extends AppCompatActivity implements View.OnClickListener  {
    private AddOrderBinding binding;

    private int banAn = 0;
    private String monAn = "";
    private int soLuong = 0;
    private String soThich = "";
    private String kM = "Không";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.add__order);
        binding.btnOk.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new AlertDialog.Builder(Add_Order.this)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn đóng không?")
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
            }
        });
    }


    @Override
    public void onClick(View v) {

        banAn=Integer.parseInt(binding.edtBan.getText().toString());
        soLuong=Integer.parseInt(binding.edtSoluong.getText().toString());

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
        if(banAn!=0&& monAn!=""&&soLuong!=0&&soThich!=""){
            Intent output=new Intent();
            output.putExtra("banAn", banAn);
            output.putExtra("monAn", monAn);
            output.putExtra("soLuong", soLuong);
            output.putExtra("soThich", soThich);
            output.putExtra("kM", kM);
            setResult(Activity.RESULT_OK, output);
            finish();
        }
    }
}