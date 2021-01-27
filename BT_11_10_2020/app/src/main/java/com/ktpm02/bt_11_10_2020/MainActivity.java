package com.ktpm02.bt_11_10_2020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ktpm02.bt_11_10_2020.databinding.ActivityMainBinding;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SinhVienAdapter.SpinnerListener {


    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private ActivityMainBinding binding;
    private SinhVienAdapter adapter;
    private List<SinhVien> listSV = new LinkedList<>();

    private int a=0;



    private String maSV = null;
    private String tenSV = null;
    private String lop = null;
    private String diemTB = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Khởi tạo 3 dòng dữ liệu và đẩy nó vào database
        initDataIntoDatabase();

        //khởi tạo adapter truyển dữ liệu cho listView
        initData();
    }

    private void initData() {
        adapter = new SinhVienAdapter(getLayoutInflater());
        binding.rcSpinner.setAdapter(adapter);
        adapter.setData(listSV);
        adapter.setListener(this);
    }

    private void initDataIntoDatabase() {
        listSV.addAll(AppDatabase1.getInMemoryDatabase(this).spinnerDao().getAll());
        List<SinhVien> sinhVienList = new LinkedList<>(AppDatabase1.getInMemoryDatabase(this).spinnerDao().getAll());
        if (sinhVienList.size() == 0) {
            addDataIntoDatabase();
        }
    }

    private void addDataIntoDatabase() {
        SinhVien sinhVien1 = new SinhVien("NV01", "Lop 1"
                , "Nguyễn Văn A", "10");
        SinhVien sinhVien2 = new SinhVien("NV02", "Lop 2"
                , "Nguyễn Văn B", "5");
        SinhVien sinhVien3 = new SinhVien("NV03", "Lop 3"
                , "Nguyễn Văn C", "4");

        // chèn dữ liệu vào database
        AppDatabase1.getInMemoryDatabase(this).spinnerDao().insertSpinner(sinhVien1);
        AppDatabase1.getInMemoryDatabase(this).spinnerDao().insertSpinner(sinhVien2);
        AppDatabase1.getInMemoryDatabase(this).spinnerDao().insertSpinner(sinhVien3);
        listSV.addAll(AppDatabase1.getInMemoryDatabase(this).spinnerDao().getAll());
    }

    private void themData() {

    }

    @Override
    public void onSpinnerClicked(int position) {

    }

    // nhấn lâu vào 1 item trong listView
    @Override
    public void onSpinnerLongClicked(int position) {
        a=position;
        // khơi tạo popupmenu với vị trí nằm phía dưới đối tượng tvContext
        // tvContext có thể là textview, imageview, button ...
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, binding.rcSpinner.getChildAt(position));
        // gán giao diện cho popup menu
        popupMenu.getMenuInflater().inflate(R.menu.my_menu, popupMenu.getMenu());
        // bắt sự kiện click item trên menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_sua:
                        Intent intent = new Intent(MainActivity.this, ActivityThem.class);
                        intent.putExtra("TenSV1",listSV.get(position).getTenSinhVien());
                        intent.putExtra("MaSV1",listSV.get(position).getMaSV());
                        intent.putExtra("Lop1",listSV.get(position).getLop());
                        intent.putExtra("DiemTB1",listSV.get(position).getDiemTB());
                        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
                        break;
                    case R.id.menu_dong:
                        finish();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            maSV = data.getStringExtra("MaSV");
            tenSV = data.getStringExtra("TenSV");
            lop = data.getStringExtra("Lop");
            diemTB = data.getStringExtra("DiemTb");
           listSV.get(a).setDiemTB(diemTB);
           listSV.get(a).setTenSinhVien(tenSV);
           listSV.get(a).setMaSV(maSV);
           listSV.get(a).setLop(lop);
            AppDatabase1.getInMemoryDatabase(getApplicationContext()).spinnerDao().update(listSV.get(a));
            listSV.clear();
            listSV.addAll(AppDatabase1.getInMemoryDatabase(this).spinnerDao().getAll());
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        }
    }
}