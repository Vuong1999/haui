package com.example.vuducvuong_ktpm2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editCMND;
    RadioGroup rgVung, rgTiepXuc, rgDauHieu;
    RadioButton rbVungCo, rbVungKhong, rbTxCo, rbTxKhong, rbSot, rbHo, rbKhoTho;
    Button btnThem, btnSua, btnDong;
    ListView lvKhaiBao;
    ArrayList<KhaiBao> arrKb = new ArrayList<KhaiBao>();
    myAdapter adapter = null;
    int currentPosition = - 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCMND = findViewById(R.id.editCMND);
        rgVung = findViewById(R.id.rgVung);
        rgTiepXuc = findViewById(R.id.rgTiepXuc);
        rgDauHieu = findViewById(R.id.rgDauHieu);
        rbVungCo = findViewById(R.id.rbVungCo);
        rbVungKhong = findViewById(R.id.rbVungKhong);
        rbTxCo = findViewById(R.id.rbTxCo);
        rbTxKhong = findViewById(R.id.rbTxKhong);
        rbSot = findViewById(R.id.rbSot);
        rbHo = findViewById(R.id.rbHo);
        rbKhoTho = findViewById(R.id.rbKhoTho);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnDong = findViewById(R.id.btnDong);
        lvKhaiBao = findViewById(R.id.lvKhaiBao);

        initView();
        initControl();

        adapter = new myAdapter(this, R.layout.myitemlist, arrKb);

        lvKhaiBao.setAdapter(adapter);
    }

    private void initControl() {
        lvKhaiBao.setAdapter(adapter);
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
        lvKhaiBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                KhaiBao kbSelected = arrKb.get(position);
                editCMND.setText(kbSelected.getCmnd() + "");
                // Check vùng
                if (kbSelected.getVung() == "Có") {
//                    findViewById(R.id.rbNam).setChecked(true);
                    rbVungCo.setChecked(true);
                } else {
                    rbVungKhong.setChecked(true);
                }
                // Check Tiếp xúc
                if (kbSelected.getTiepxuc() == "Có") {
//                    findViewById(R.id.rbNam).setChecked(true);
                    rbTxCo.setChecked(true);
                } else {
                    rbTxKhong.setChecked(true);
                }

                if (kbSelected.getDauhieu() == "Sốt") {
                    rbSot.setChecked(true);
                } else {
                    if (kbSelected.getDauhieu() == "Ho") {
                        rbHo.setChecked(true);
                    } else {
                        if(kbSelected.getDauhieu() == "Khó thở") {
                            rbKhoTho.setChecked(true);
                        }
                        else {
                            rbSot.setChecked(false);
                            rbHo.setChecked(false);
                            rbKhoTho.setChecked(false);
                        }
                    }

                }
            }
        });
        lvKhaiBao.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrKb.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void initView() {
        arrKb = new ArrayList<>();
        arrKb.add(new KhaiBao("036099002857", "Có", "Không", ""));
        arrKb.add(new KhaiBao("036099004681", "Không", "Không", ""));
        arrKb.add(new KhaiBao("036099005810", "Có", "Có", "Ho"));
    }

    private boolean Valior() {
        if (editCMND.getText().toString().isEmpty()){
            Toast.makeText(this, "Bạn cần nhập số CMND", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setBox(){
        editCMND.setText("");
        rbVungCo.setChecked(false);
        rbVungKhong.setChecked(false);
        rbTxCo.setChecked(false);
        rbTxKhong.setChecked(false);
        rbSot.setChecked(false);
        rbHo.setChecked(false);
        rbKhoTho.setChecked(false);
        editCMND.requestFocus();
    }

    private void xulyThem() {
        if (Valior()){
            String cmnd = editCMND.getText().toString().trim();
            String vung = rgVung.getCheckedRadioButtonId()==R.id.rbVungCo?"Có":"Không";
            String tiepxuc = rgTiepXuc.getCheckedRadioButtonId()==R.id.rbTxCo?"Có":"Không";
            String dauhieu = rgDauHieu.getCheckedRadioButtonId()==R.id.rbSot?"Sốt":
                    (rgDauHieu.getCheckedRadioButtonId()==R.id.rbHo?"Ho":"Khó thở");
            KhaiBao kb = new KhaiBao(cmnd, vung, tiepxuc, dauhieu);
            arrKb.add(kb);
            adapter.notifyDataSetChanged();
            //Sau khi update thì xóa trắng dữ liệu và cho editma focus
           setBox();
        }
    }

    private void xulySua() {
        KhaiBao kb = arrKb.get(currentPosition);
        if (!Valior()){
            return;
        }
        kb.setCmnd(editCMND.getText().toString().trim());
        kb.setVung(rbVungCo.isChecked()==true?"Có":"Không");
        kb.setTiepxuc(rbTxCo.isChecked()==true?"Có":"Không");
        kb.setDauhieu(rbSot.isChecked()==true?"Sốt":(rbHo.isChecked()==true?"Ho":"Khó thở"));
        adapter.notifyDataSetChanged();
        setBox();
    }

    private void xulyDong() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Cảnh báo:");
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