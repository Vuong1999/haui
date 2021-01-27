package com.example.testpractice;
import androidx.appcompat.app.*;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editMaDH, editTenDH;
    Button btnSua, btnThem, btnDong;
    RadioButton rbNam, rbNu, rbDa, rbKimLoai, rbKhac;
    RadioGroup rdLoaiDH, rdLoaiD;
    CheckBox chkKhuyenMai;
    ListView lv;
    ArrayList<DonHang> arrDh = new ArrayList<DonHang>();
    MyAdapter adapter = null;
    int currentPosition = - 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMaDH = (EditText) findViewById(R.id.editMaDH);
        editTenDH = (EditText) findViewById(R.id.editTenDH);
        btnSua = (Button) findViewById(R.id.btnSua);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnDong = (Button) findViewById(R.id.btnDong);
        rdLoaiDH = (RadioGroup) findViewById(R.id.rdLoaiDH);
        rdLoaiD = (RadioGroup) findViewById(R.id.rdLoaiDay);
        chkKhuyenMai = (CheckBox) findViewById(R.id.chkKhuyenMai);
        rbNam = (RadioButton) findViewById(R.id.rbNam);
        rbNu = (RadioButton) findViewById(R.id.rbNu);
        rbDa = (RadioButton) findViewById(R.id.rbDa);
        rbKimLoai = (RadioButton) findViewById(R.id.rbKimLoai);
        rbKhac = (RadioButton) findViewById(R.id.rbKhac);

        lv = (ListView) findViewById(R.id.lv);

        initView();
        initControl();

        adapter = new MyAdapter(this, R.layout.myitemlist, arrDh);

        lv.setAdapter(adapter);
    }

    private void initControl() {
        lv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyThem();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulySua();
            }
        });
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyDong();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                DonHang dhSelected = arrDh.get(position);
                editMaDH.setText(dhSelected.getMaDH() + "");
                editTenDH.setText(dhSelected.getTenDH() + "");
                if (dhSelected.getLoaiDH() == "Nam") {
//                    findViewById(R.id.rbNam).setChecked(true);
                    rbNam.setChecked(true);
                } else {
                    rbNu.setChecked(true);
                }

                if (dhSelected.getLoaiDay() == "Da") {
                    rbDa.setChecked(true);
                } else {
                    if (dhSelected.getLoaiDay() == "Kim loại") {
                        rbKimLoai.setChecked(true);
                    } else {
                        rbKhac.setChecked(true);
                    }
                }

                if (dhSelected.getKhuyenMai() == "Có") {
                    chkKhuyenMai.setChecked(true);
                } else {
                    chkKhuyenMai.setChecked(false);
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrDh.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private boolean Valior() {
        if (editMaDH.getText().toString().isEmpty() || editTenDH.getText().toString().isEmpty()){
            Toast.makeText(this, "Bạn cần nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void xulyThem() {
        if (Valior()){
            String ma = editMaDH.getText().toString().trim();
            String ten = editTenDH.getText().toString().trim();
            String gt = rdLoaiDH.getCheckedRadioButtonId()==R.id.rbNam?"Nam":"Nữ";
            String loai = rdLoaiD.getCheckedRadioButtonId()==R.id.rbDa?"Da":
                    (rdLoaiD.getCheckedRadioButtonId()==R.id.rbKimLoai?"Kim loại":"Khác");
            String km = chkKhuyenMai.isChecked()==true?"Có":"Không";
            DonHang dh = new DonHang(ma, ten, gt, loai, km);
            arrDh.add(dh);
            adapter.notifyDataSetChanged();
            //Sau khi update thì xóa trắng dữ liệu và cho editma focus
            editMaDH.setText("");
            editTenDH.setText("");
            rbNam.setChecked(false);
            rbNu.setChecked(false);
            rbDa.setChecked(false);
            rbKimLoai.setChecked(false);
            rbKhac.setChecked(false);
            chkKhuyenMai.setChecked(false);
            editMaDH.requestFocus();
        }
    }

    private void xulySua() {
        DonHang dh = arrDh.get(currentPosition);
        if (!Valior()){
            return;
        }
        dh.setMaDH(editMaDH.getText().toString().trim());
        dh.setTenDH(editTenDH.getText().toString().trim());
        dh.setLoaiDH(rbNam.isChecked()==true?"Nam":"Nữ");
        dh.setLoaiDay(rbDa.isChecked()==true?"Da":(rbKimLoai.isChecked()==true?"Kim loại":"Khác"));
        dh.setKhuyenMai(chkKhuyenMai.isChecked()==true?"Có":"Không");
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        arrDh = new ArrayList<>();
        arrDh.add(new DonHang("DH01", "Casio", "Nam", "Da", "Có"));
        arrDh.add(new DonHang("DH02", "Samsung", "Nam", "Kim loại", "Có"));
        arrDh.add(new DonHang("DH03", "Google", "Nữ", "Khác", "Không"));
    }

//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnSua:
//                xulySua();
//                break;
//            case R.id.btnThem:
//                if (Valior()){
//                    String ma = editMaDH.getText().toString().trim();
//                    String ten = editTenDH.getText().toString().trim();
//                    String gt = rdLoaiDH.getCheckedRadioButtonId()==R.id.rbNam?"Nam":"Nữ";
//                    String loai = rdLoaiD.getCheckedRadioButtonId()==R.id.rbDa?"Da":
//                            (rdLoaiD.getCheckedRadioButtonId()==R.id.rbKimLoai?"Kim loại":"Khác");
//                    String km = chkKhuyenMai.isChecked()==true?"Có":"Không";
//                    DonHang dh = new DonHang(ma, ten, gt, loai, km);
//                    arrDh.add(dh);
//                    adapter.notifyDataSetChanged();
//                }
//                break;
//            case R.id.btnDong:
//                xulyDong();
//                break;
//        }
//    }

//    private void xulyThem() {
//
//        String ma=editMaDH.getText()+"";
//        String ten=editTenDH.getText()+"";
//
//       String loaidh = "";
//       int checkDh = rdLoaiDH.getCheckedRadioButtonId();
//       if(checkDh==(R.id.rbNam)){ loaidh="Nam";}
//        if(checkDh==(R.id.rbNu)){ loaidh="Nu";}
//
//
//        // Check loai day
//        String loaiDay = "";
//        int checkDay = rdLoaiD.getCheckedRadioButtonId();
//        if(checkDay==(R.id.rbDa)){
//            loaiDay = "Da";
//        }
//        if(checkDay==(R.id.rbKimLoai)){ loaiDay = "Kim Loai";}
//        if(checkDay==(R.id.rbKhac)){ loaiDay = "Khac"; }
//
//        // Check khuyen mai
//        boolean khuyemai = true;// Co KM
//        if(chkKhuyenMai.isChecked()==false) khuyemai = false;
//
//
//        //Tạo một DonHang
//        DonHang dh=new DonHang();
//
//        dh.setMaDH(ma);
//        dh.setTenDH(ten);
//        dh.setLoaiDH(loaidh);
//        dh.setLoaiDay(loaiDay);
//        dh.setKhuyenMai(khuyemai);
//
//        //Đưa vào danh sách
//        arrDh.add(dh);
//        //gọi hàm cập nhật giao diện
//        adapter.notifyDataSetChanged();
//        //Sau khi update thì xóa trắng dữ liệu và cho editma focus
//        editMaDH.setText("");
//        editTenDH.setText("");
//        editMaDH.requestFocus();
//
//    }

    private void xulyDong() {
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
}