package com.example.vuducvuong_2017604374_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.vuducvuong_2017604374_test.databinding.ActivityMainBinding;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SinhVienAdapter.SpinnerListener {


    private ActivityMainBinding binding;
    private SinhVienAdapter adapter;
    private List<SinhVien> listSV = new LinkedList<>();

    private int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initDataIntoDb();
        initData();
    }

    private void initData() {
        adapter = new SinhVienAdapter(getLayoutInflater());
        binding.spinner.setAdapter(adapter);
        adapter.setData(listSV);
        adapter.setListener(this);
    }

    private void initDataIntoDb() {
        listSV.addAll(AppDb.saveDb(this).spinner().getAll());
        List<SinhVien> sinhVienList = new LinkedList<>(AppDb.saveDb(this).spinner().getAll());
        if (sinhVienList.size() == 0) {
            fakeData();
        }
    }

    private void fakeData() {
        SinhVien sv1 = new SinhVien("SV01", "KHMT"
                , "Nguyễn Văn A", "9");
        SinhVien sv2 = new SinhVien("SV02", "CNTT"
                , "Nguyễn Thị B", "7");
        SinhVien sv3 = new SinhVien("SV03", "KTPM"
                , "Hoàng Văn C", "8");

        AppDb.saveDb(this).spinner().insertSpinner(sv1);
        AppDb.saveDb(this).spinner().insertSpinner(sv2);
        AppDb.saveDb(this).spinner().insertSpinner(sv3);
        listSV.addAll(AppDb.saveDb(this).spinner().getAll());
    }

    @Override
    public void onSpinnerClicked(int position) {
    }

    @Override
    public void onSpinnerLongClicked(final int position) {
        a=position;
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, binding.spinner.getChildAt(position));
        popupMenu.getMenuInflater().inflate(R.menu.my_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_sua:
//                        Intent intent = new Intent(this, activity_edit);
                        break;
//                        startActivityForResult(intent, position);
//                        startActivity(intent);
                    case R.id.menu_dong:
                        finish();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}