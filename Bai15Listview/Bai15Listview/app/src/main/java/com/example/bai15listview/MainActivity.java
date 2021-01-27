package com.example.bai15listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<DH> arr;
    private ListView lv;
    private DhAdapter adapter;
    private EditText edtMa, edtTen;
    private Button btnSua, btnThem, btnDong;
    private RadioGroup rdtGt, rdtLoai;
    private CheckBox chkKM;
    private RadioButton rdtNam, rdtNu, rdtDa, rdtKimLoai, rdtKhac;
    int currentPosition = - 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initControl();
    }

    private void initControl() {
        lv.setAdapter(adapter);
        btnThem.setOnClickListener(this);
        btnDong.setOnClickListener(this);
        btnSua.setOnClickListener(this);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                DH dh = arr.get(position);
                edtMa.setText(dh.getMa());
                edtTen.setText(dh.getTen());
                if (dh.getGt() == "Nam") {
                    rdtNam.setChecked(true);
                } else {
                    rdtNu.setChecked(true);
                }

                if (dh.getLoai() == "Da") {
                    rdtDa.setChecked(true);
                } else {
                    if (dh.getLoai() == "Kim loại") {
                        rdtKimLoai.setChecked(true);
                    } else {
                        rdtKhac.setChecked(true);
                    }
                }

                if (dh.getKm() == "Có") {
                    chkKM.setChecked(true);
                } else {
                    chkKM.setChecked(false);
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arr.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void initView() {
        arr = new ArrayList<>();
        lv = findViewById(R.id.lv);
        adapter = new DhAdapter(this, R.layout.item, arr);
        edtMa = findViewById(R.id.edt_id);
        edtTen = findViewById(R.id.edt_name);
        btnDong = findViewById(R.id.btn_dong);
        btnSua = findViewById(R.id.btn_sua);
        btnThem = findViewById(R.id.btn_them);
        rdtGt = findViewById(R.id.rdt_gender);
        rdtLoai = findViewById(R.id.rdt_type);
        chkKM = findViewById(R.id.chk_sale);
        rdtNam =findViewById(R.id.rdt_nam);
        rdtDa =findViewById(R.id.rdt_feather);
        rdtNu =findViewById(R.id.rdt_nu);
        rdtKimLoai =findViewById(R.id.rdt_material);
        rdtKhac =findViewById(R.id.rdt_other);

        arr.add(new DH("1", "Thư", "Nam", "Da", "Có"));
        arr.add(new DH("2", "Thịnh", "Nam", "Kim loại", "Có"));
        arr.add(new DH("3", "Thính", "Nữ", "Khác", "Không"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                case R.id.btn_sua:
                    setSua();
                    break;
                case R.id.btn_them:
                    if (Valior()){
                        String ma = edtMa.getText().toString().trim();
                        String ten = edtTen.getText().toString().trim();
                        String gt = rdtGt.getCheckedRadioButtonId()==R.id.rdt_nam?"Nam":"Nữ";
                        String loai = rdtLoai.getCheckedRadioButtonId()==R.id.rdt_feather?"Da":
                                (rdtLoai.getCheckedRadioButtonId()==R.id.rdt_material?"Kim loại":"Khác");
                        String km = chkKM.isChecked()==true?"Có":"Không";
                        DH dh = new DH(ma, ten, gt, loai, km);
                        arr.add(dh);
                        adapter.notifyDataSetChanged();
                    }
                    break;
                case R.id.btn_dong:
                    checkOut();
                    break;
        }
    }

    private void setSua() {
        DH dh = arr.get(currentPosition);
        if (!Valior()){
            return;
        }
        dh.setMa(edtMa.getText().toString().trim());
        dh.setTen(edtTen.getText().toString().trim());
        dh.setGt(rdtNam.isChecked()==true?"Nam":"Nữ");
        dh.setLoai(rdtDa.isChecked()==true?"Da":(rdtKimLoai.isChecked()==true?"Kim loại":"Khác"));
        dh.setKm(chkKM.isChecked()==true?"Có":"Không");
        adapter.notifyDataSetChanged();
    }

    private boolean Valior() {
        if (edtMa.getText().toString().isEmpty() || edtTen.getText().toString().isEmpty()){
            Toast.makeText(this, "Bạn cần nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void checkOut() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Bạn có muốn đóng không")
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .show();
    }
}