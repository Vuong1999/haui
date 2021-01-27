package com.example.billinformation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button btnTT,btnTiep,btnTK;
    ImageButton btnThoat;
    EditText editTen,editSl,editTongKh,editTongKhVip,ediTongTT;
    TextView txtTT;
    CheckBox chkVip;
    CustomerList danhsach=new CustomerList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();
        addEvents();
    }

    private void getControls() {
        //Thực hiện lấy các điều khiển trên giao diện
        btnTT = (Button) findViewById(R.id.btnMoneyCalculate);
        btnTiep = (Button) findViewById(R.id.btnContinue);
        btnTK = (Button) findViewById(R.id.btnCount);
        btnThoat = (ImageButton) findViewById(R.id.btnExitBookSellProgram);
        editTen = (EditText) findViewById(R.id.editCustomerName);
        editSl = (EditText) findViewById(R.id.editBookQuantity);
        editTongKh = (EditText) findViewById(R.id.editCustomerSum);
        editTongKhVip = (EditText) findViewById(R.id.editCustomerSumVip);
        ediTongTT = (EditText) findViewById(R.id.editProfitsSum);
        txtTT = (TextView) findViewById(R.id.editMoneyResult);
        chkVip = (CheckBox) findViewById(R.id.chkIsVip);
    }

    private void addEvents() {
        //bắt sự kiện thông qua 1 đối tượng của lớp tự tạo
        btnTT.setOnClickListener(new ProcessMyEvent());
        btnTiep.setOnClickListener(new ProcessMyEvent());
        btnTK.setOnClickListener(new ProcessMyEvent());
        btnThoat.setOnClickListener(new ProcessMyEvent());
    }
    private void doTinhTien()
    {
        Customer kh=new Customer();
        kh.setTenKh(editTen.getText()+"");
                kh.setSlmua(Integer.parseInt(editSl.getText()+""));
                        kh.setVip(chkVip.isChecked());
        txtTT.setText(kh.tinhThanhTien()+"");
                danhsach.addCustomer(kh);
    }
    private void doTiep()
    { editTen.setText("");
        editSl.setText("");
        txtTT.setText("");
        editTen.requestFocus();
    }
    private void doThongKe()
    {
        editTongKh.setText(danhsach.sumCustomer()+"");
                editTongKhVip.setText(danhsach.sumCustomerVip()+"");
                        ediTongTT.setText(danhsach.sumProfits()+"");
    }
    private void doThoat()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
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
    private class ProcessMyEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View arg0) {
            switch(arg0.getId())
            {
                case R.id.btnMoneyCalculate:doTinhTien(); break;
                case R.id.btnContinue: doTiep(); break;
                case R.id.btnCount: doThongKe(); break;
                case R.id.btnExitBookSellProgram: doThoat(); break;
            }
        }
    }
}