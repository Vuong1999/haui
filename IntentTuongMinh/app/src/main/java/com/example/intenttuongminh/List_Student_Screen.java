package com.example.intenttuongminh;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List_Student_Screen extends AppCompatActivity {

    ListView lv_listStudent;
    ArrayList<Student> studentList = new ArrayList<>();
    CustomAdapter adapter;
    int REQUEST_CODE = 1;
    public static final String STUDENT_CODE = "Student_Code";
    public static final String STUDENT_NAME = "Student_Name";
    public static final String STUDENT_GENDER = "Student_Gender";
    public static final String STUDENT_CLASS = "Student_Class";
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_infomation);

        lv_listStudent = findViewById(R.id.lv_listStudent);

        //Nhận dữ liệu từ màn hình 1 gửi sang
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        studentList = bundle.getParcelableArrayList("key");

        //Đẩy dữ liệu lên listview
        adapter = new CustomAdapter(List_Student_Screen.this, R.layout.one_student, studentList);
        adapter.notifyDataSetChanged();
        lv_listStudent.setAdapter(adapter);

        //Khai báo giao diện context Menu gắn với view là ListView
        registerForContextMenu(lv_listStudent);

        lv_listStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(List_Student_Screen.this)
                        .setTitle("Student Information")
                        .setMessage("Student Code: " + studentList.get(position).getStudentCode() + "\n"
                                +"Student Name: " + studentList.get(position).getStudentName() + "\n"
                                +"Student Gender: " + studentList.get(position).getStudentGender() + "\n"
                                +"Student Class: " + studentList.get(position).getStudentClass())
                        .setNegativeButton("OK", null)
                        .create()
                        .show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Gán Context Menu cho ListView
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Demo Menu");

        //Gán menu đã thiết kế cho sự kiện click theo từng item Listview
        getMenuInflater().inflate(R.menu.item_option, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.menu_edit:
                Intent intent = new Intent(List_Student_Screen.this, Edit_Student_Screen.class);
                intent.putExtra(STUDENT_CODE, studentList.get(info.position).getStudentCode());
                intent.putExtra(STUDENT_NAME, studentList.get(info.position).getStudentName());
                intent.putExtra(STUDENT_GENDER, studentList.get(info.position).getStudentGender());
                intent.putExtra(STUDENT_CLASS, studentList.get(info.position).getStudentClass());
                position = info.position;
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.menu_delete:
                studentList.remove(info.position);
                adapter.notifyDataSetChanged();
                lv_listStudent.setAdapter(adapter);
                Toast.makeText(List_Student_Screen.this, "Delete successfully", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //requestCode: kiểu như là mật hiệu khi ActivityInput gửi dữ liệu đi cho một
        // Activity nào đó,  dựa vào thằng này mà nó biết là dữ liệu được trả về từ Activity nào.
        //
        //VD: Trong trường hợp ActivityA gửi đi cho 2 Activity B và C ,
        // thì cả B và C đều trả về ActivityA dữ liệu thì ActivityA sẽ dựa vào requestCode này để biết nó đến từ B hay C.

        //resultCode: khi một activity gửi dữ liệu về thì gọi hàm setResult() và truyền vào resultCode,
        // và đây mà cách mà activity nhận sẽ lấy dữ liệu cho đúng trong trường hợp gửi về nhiều result
        // và nó cũng cho bạn biết được Intent gửi về tương ứng là gì.
        //
        //VD: ActivityA gửi cho ActivityB số A và B, sau đó ActivityB nhận được 2 số và
        // thực hiện 2 phép toán trừ và cộng.ActivityB truyền lại kết quả cho A với resultcode
        // phép cộng là 1, phép trừ là 2.Vậy ActivityA sẽ dựa vào resultCode này để biết kết quả trả về là cộng hay trừ.
        //
        //data: dữ liệu gửi về sẽ lưu trong intent và đây là cái để bạn getExtra ra.

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Student student = data.getParcelableExtra(Edit_Student_Screen.RESULT);
                studentList.set(position, student);
                lv_listStudent.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
