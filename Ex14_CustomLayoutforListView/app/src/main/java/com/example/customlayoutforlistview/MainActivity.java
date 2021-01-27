package com.example.customlayoutforlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
    //Sử dụng MyArrayAdapter thay thì ArrayAdapter
    myAdapter adapter=null;
    ListView lvNhanvien=null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText editMa,editTen;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap=(Button) findViewById(R.id.btnNhapNv);
        btnRemoveAll=(ImageButton) findViewById(R.id.btnDelete);
        editMa=(EditText) findViewById(R.id.editMaNv);
        editTen=(EditText) findViewById(R.id.editTenNv);
        genderGroup=(RadioGroup) findViewById(R.id.rdGioiTinh);
        lvNhanvien=(ListView) findViewById(R.id.lvNv);
        arrEmployee=new ArrayList<Employee>();
        //Khởi tạo đối tượng adapter và gán Data source
        adapter=new myAdapter(
                this,
                R.layout.my_item_layout,// lấy custom layout
                arrEmployee);
        //gán Adapter vào Lisview
        lvNhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xylyNhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyXoa();
            }
        });
        lvNhanvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                xylyChon(position);
            }
        });


    }

    private void xylyChon(int position) {
        //Lấy dữ liệu lên TextBox ở trên
        Employee myEmpSelected=arrEmployee.get(position);
        editMa.setText(myEmpSelected.getId() + "");
        editTen.setText(myEmpSelected.getName() + "");
        if (myEmpSelected.isGender())
        {
            findViewById(R.id.rbNu).setSelected(true);
            findViewById(R.id.rbNam).setSelected(false);
        }
        else {
            findViewById(R.id.rbNam).setSelected(true);
            findViewById(R.id.rbNu).setSelected(false);
        }
        View v=lvNhanvien.getChildAt(position);

        CheckBox ckDelete=(CheckBox) v.findViewById(R.id.chkitem);
        ckDelete.setChecked(!ckDelete.isChecked());
    }

    private void xulyXoa() {
        //ta nên đi ngược danh sách, kiểm tra phần tử nào checked
        //thì xóa đúng vị trí đó ra khỏi arrEmployee
            for(int i=lvNhanvien.getChildCount()-1;i>=0;i--)
            {
        //lấy ra dòng thứ i trong ListView
        //Dòng thứ i sẽ có 3 phần tử: ImageView, TextView, Checkbox
                View v=lvNhanvien.getChildAt(i);
        //Ta chỉ lấy CheckBox ra kiểm tra
                CheckBox chk=(CheckBox) v.findViewById(R.id.chkitem);
        //Nếu nó Checked thì xóa ra khỏi arrEmployee
                if(chk.isChecked())
                {
        //xóa phần tử thứ i ra khỏi danh sách
                    arrEmployee.remove(i);
                }
        }
        //Sau khi xóa xong thì gọi update giao diện
            adapter.notifyDataSetChanged();
    }

    private void xylyNhap() {
        String ma=editMa.getText()+"";
        String ten=editTen.getText()+"";
        boolean gioitinh=false;//Nam =false
        if(genderGroup.getCheckedRadioButtonId()==R.id.rbNu)
            gioitinh=true;
        //Tạo một employee
        Employee emp=new Employee();

        emp.setId(ma);
        emp.setName(ten);
        emp.setGender(gioitinh);
      //Đưa vào danh sách
        arrEmployee.add(emp);
      //gọi hàm cập nhật giao diện
        adapter.notifyDataSetChanged();
     //Sau khi update thì xóa trắng dữ liệu và cho editma focus
        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();
    }
}