package com.example.nhom2_android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.nhom2_android_project.database.PhoDatabase;
import com.example.nhom2_android_project.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private String userName="";
    private String passWord="";
    List<User> userList=new ArrayList<>();
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        addUser();
        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=binding.edtUsername.getText().toString();
                passWord=binding.edtPassword.getText().toString();
                for (User user: userList){
                    if(user.getUserName().equals(userName)&&user.getPassWord().equals(passWord)){
                        Intent intent=new Intent(LoginActivity.this, App_Infor.class);
                        startActivity(intent);
                        return;
                    }
                }
                Toast.makeText(LoginActivity.this, "Đăng nhập không thành công! ", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void addUser(){
        userList.addAll(PhoDatabase.getInstance(this).userDao().getAll());
        List<User> orderList = new ArrayList<>(PhoDatabase.getInstance(this).userDao().getAll());
        if (orderList.size() == 0) {
            initdataUser();
        }
    }

    private void initdataUser() {
        User user1=new User("Admin1","12345");
        User user2=new User("Admin2","54321");
        User user3=new User("Admin3","54321");
        PhoDatabase.getInstance(this).userDao().insert(user1);
        PhoDatabase.getInstance(this).userDao().insert(user2);
        PhoDatabase.getInstance(this).userDao().insert(user3);
    }
}