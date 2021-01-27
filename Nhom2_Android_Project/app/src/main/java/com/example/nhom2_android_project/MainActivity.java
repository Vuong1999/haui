package com.example.nhom2_android_project;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import com.example.nhom2_android_project.database.PhoDatabase;
import com.example.nhom2_android_project.databinding.ActivityMainBinding;
import com.example.nhom2_android_project.databinding.EditOrderBinding;;
import java.util.*;

public class MainActivity extends AppCompatActivity implements PhoAdapter.SpinnerListener {

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private ActivityMainBinding binding;
    private EditOrderBinding edtbinding;
    private PhoAdapter adapter;
    private List<Pho> oderList = new ArrayList<>();

    private int banAn = 0;
    private String monAn = "";
    private int soLuong = 0;
    private String soThich = "";
    private String kM = "Không";
    private int a = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Add_Order.class);
                startActivityForResult(intent, 1);
            }
        });

        initDataIntoDatabase();

        initData();
    }

    private void initData() {
        adapter = new PhoAdapter(getLayoutInflater());
        adapter.setData(oderList);
        binding.rcOder.setAdapter(adapter);
        adapter.setListener(this);
    }


    private void initDataIntoDatabase() {
        oderList.addAll(PhoDatabase.getInstance(this).phoDao().getAll());
        List<Pho> orderList = new ArrayList<>(PhoDatabase.getInstance(this).phoDao().getAll());
        if (orderList.size() == 0) {
            addDataIntoDatabase();
        }
    }

    private void addDataIntoDatabase() {
        Pho pho1=new Pho(1, "Phở tái" ,4, "Không hành", "Có");
        Pho pho2=new Pho(2, "Phở chín",3, "Giá đỗ", "Có");
        Pho pho3=new Pho(3, "Phở nạm",4, "Ít nước béo", "Không");

        // chèn dữ liệu vào database
        PhoDatabase.getInstance(this).phoDao().insert(pho1);
        PhoDatabase.getInstance(this).phoDao().insert(pho2);
        PhoDatabase.getInstance(this).phoDao().insert(pho3);

        oderList.addAll(PhoDatabase.getInstance(this).phoDao().getAll());

    }


    @Override
    public void onSpinnerClicked(int position) {

    }
    @Override
    public void onSpinnerLongClicked(final int position) {
        a=position;
        androidx.appcompat.widget.PopupMenu popupMenu = new androidx.appcompat.widget.PopupMenu(MainActivity.this, binding.rcOder.getChildAt(position));
        popupMenu.getMenuInflater().inflate(R.menu.item_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_sua:
                        doEdit();
                        break;
                    case R.id.menu_xoa:
                        doDelete();
                        break;
                }
                return false;
            }

            private void doEdit() {
                Intent intent = new Intent(MainActivity.this, Edit_Order.class);
                intent.putExtra("Ban",oderList.get(position).getBan());
                intent.putExtra("Mon",oderList.get(position).getMon());
                intent.putExtra("SoLuong",oderList.get(position).getSoluong());
                intent.putExtra("SoThich",oderList.get(position).getSothich());
                intent.putExtra("KhuyenMai",oderList.get(position).getKm());
                startActivityForResult(intent, 2);
            }

            private void doDelete() {
                Dialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn xoá không?")
                        .setPositiveButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (a != 0) {
                                    PhoDatabase.getInstance(getApplicationContext()).phoDao().delete(oderList.get(a));
                                    oderList.clear();
                                    oderList.addAll(PhoDatabase.getInstance(getApplicationContext()).phoDao().getAll());
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this, "Bạn đã xoá thành công hoá đơn", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Mời bạn chọn hoá đơn cần xoá", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .show();
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null){
            banAn=data.getIntExtra("banAn", 0);
            monAn=data.getStringExtra("monAn");
            soLuong=data.getIntExtra("soLuong", 0);
            soThich=data.getStringExtra("soThich");
            kM=data.getStringExtra("kM");

            Pho pho=new Pho(banAn, monAn, soLuong, soThich, kM);
            PhoDatabase.getInstance(this).phoDao().insert(pho);

            oderList.clear();
            oderList.addAll( PhoDatabase.getInstance(this).phoDao().getAll());
            adapter.notifyDataSetChanged();

            Toast.makeText(this, "Order thành công",Toast.LENGTH_SHORT).show();
        }

        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            banAn=data.getIntExtra("newBan", 0);
            monAn=data.getStringExtra("newMon");
            soLuong=data.getIntExtra("newSl", 0);
            soThich=data.getStringExtra("newSt");
            kM=data.getStringExtra("newKm");

            oderList.get(a).setBan(banAn);
            oderList.get(a).setMon(monAn);
            oderList.get(a).setSoluong(soLuong);
            oderList.get(a).setSothich(soThich);
            oderList.get(a).setKm(kM);
            PhoDatabase.getInstance(this).phoDao().update(oderList.get(a));
            oderList.clear();
            oderList.addAll(PhoDatabase.getInstance(getApplicationContext()).phoDao().getAll());
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        }
    }
}