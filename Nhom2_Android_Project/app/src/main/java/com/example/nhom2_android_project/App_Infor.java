package com.example.nhom2_android_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class App_Infor extends AppCompatActivity {

    TextView txt_appinfor, txt_footer;
    Button btnMain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__infor);
        txt_appinfor = findViewById(R.id.txt_appinfor);
        txt_footer = findViewById(R.id.txt_footer);

        txt_appinfor.setText("Phần mềm quản lý gọi món của hàng phở Thu Vương" +
                "\nPhiên bản: 1.0" +
                "\nPhần mềm quản lý gọi món là ứng dụng của nhóm 2 giúp cho việc đặt phở của nhà hàng Thu Vương dễ dàng quản lý hơn." +
                "Ứng dụng đưa ra các thống kê đặt hàng rõ ràng cũng như cung cấp việc thêm, sửa, xoá đặt phở với đầy đủ các loại phở mà nhà hàng cung cấp." );
        txt_footer.setText("Copyright © Nhom 2 KTPM2" +
                "\nPham Van Thu - Vu Duc Vuong");

        btnMain = findViewById(R.id.btn_main);
        btnExit = findViewById(R.id.btn_exit);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(App_Infor.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doExit();
            }
        });
    }
    private void doExit(){
        androidx.appcompat.app.AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Hỏi thoát chương trình");
        builder.setMessage("Bạn muốn thoát chương trình?");
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create().show();
    }
}